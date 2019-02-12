<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.io.*,java.text.*,java.util.*,java.sql.*,java.text.SimpleDateFormat,java.text.DateFormat,java.util.Date,javax.servlet.*,javax.servlet.http.*,DBstep.iDBManager2000.*" %>
<%!
  /**
   * ���ܻ����ã���ʽ������ʱ��
   * @param DateValue �������ڻ�ʱ��
   * @param DateType ��ʽ�� EEEE������, yyyy����, MM����, dd����, HH��Сʱ, mm�Ƿ���,  ss����
   * @return ����ַ���
   */
  public String FormatDate(String DateValue,String DateType)
  {
    String Result;
    SimpleDateFormat formatter = new SimpleDateFormat(DateType);
    try{
      Date mDateTime = formatter.parse(DateValue);
      Result = formatter.format(mDateTime);
    }catch(Exception ex){
      Result = ex.getMessage();
    }
    if (Result.equalsIgnoreCase("1900-01-01")){
      Result = "";
    }
    return Result;
  }
%>
<%
  ResultSet result=null;
  String mSubject=null;
  String mStatus=null;
  String mAuthor=null;
  String mFileDate=null;
  String mFileName ="�����ĵ�";

  //�Զ���ȡOfficeServer��OCX�ļ�����URL·��
  String mHttpUrlName=request.getRequestURI();
  String mScriptName=request.getServletPath();
  String mServerName="PDFServer.jsp";

  String mServerUrl="http://"+request.getServerName()+":"+request.getServerPort()+mHttpUrlName.substring(0,mHttpUrlName.lastIndexOf(mScriptName))+"/"+mServerName;//ȡ��OfficeServer�ļ�������URL
  String mHttpUrl="http://"+request.getServerName()+":"+request.getServerPort()+mHttpUrlName.substring(0,mHttpUrlName.lastIndexOf(mScriptName))+"/";

  String mRecordID=request.getParameter("RecordID");
  String mUserName=new String(request.getParameter("UserName").getBytes("8859_1"));

  //ȡ�ñ��
  if ( mRecordID==null)
  {
     mRecordID="";	//���Ϊ��
  }
  //ȡ���û���
  if (mUserName==null || mUserName=="")
  {
    mUserName="���Ƽ�";
  }

  //�����ݿ�
  DBstep.iDBManager2000 DbaObj=new DBstep.iDBManager2000();
  if (DbaObj.OpenConnection())
  {
    String mSql="Select * From Document Where RecordID='"+ mRecordID + "'";
    try
    {
      result=DbaObj.ExecuteQuery(mSql);
      if (result.next())
      {
        mRecordID=result.getString("RecordID");
        mSubject=result.getString("Subject");
        mAuthor=result.getString("Author");
        mFileDate=result.getString("FileDate");
        mStatus=result.getString("Status");
      }
      else
      {
	//ȡ��Ψһֵ(mRecordID)
        java.util.Date dt=new java.util.Date();
        long lg=dt.getTime();
        Long ld=new Long(lg);
	//��ʼ��ֵ
        mRecordID=ld.toString();//��������ĵ��ı�ţ�ͨ���ñ�ţ����������ҵ���������������¼���ĵ�
        mSubject="����������";
        mAuthor=mUserName;
        mFileDate=DbaObj.GetDateTime();
        mStatus="DERF";
      }
      result.close();
    }
    catch(SQLException e)
    {
      System.out.println(e.toString());
    }
    DbaObj.CloseConnection() ;
  }
%>

<html>
<head>
<title>���iWebPDFʾ������</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel='stylesheet' type='text/css' href='test.css'>
<!--
<script language="javascript" for=WebPDF event="OnOpen()">
  alert("�򿪳ɹ�");
</script>

<script language="javascript" for=WebPDF event="OnClose()">
  alert("�رճɹ�");
</script>
-->
<script language=javascript>
/*
form������:webform
iWebPDF����:WebPDF
*/

//���ã���ʾ����״̬
function StatusMsg(mString){
  webform.StatusBar.value=mString;
}

//���ã�����iWebPDF
function Load(){
  try{
    //�������Ա������ã�ʵʼ��iWebPDF
    webform.WebPDF.WebUrl="<%=mServerUrl%>";    //WebUrl:ϵͳ������·������������ļ������������籣�桢���ĵ� 
    webform.WebPDF.RecordID="<%=mRecordID%>";   //RecordID:���ĵ���¼���
    webform.WebPDF.FileName="<%=mFileName%>";   //FileName:�ĵ�����
    webform.WebPDF.UserName="<%=mUserName%>";   //UserName:�����û���

    webform.WebPDF.ShowTools = 1;               //�������ɼ���1,�ɼ���0,���ɼ���
    webform.WebPDF.SaveRight = 1;               //�Ƿ������浱ǰ�ĵ���1,����0,������
    webform.WebPDF.PrintRight = 1;              //�Ƿ������ӡ��ǰ�ĵ���1,����0,������
    webform.WebPDF.AlterUser = false;           //�Ƿ������ɿؼ�������ʾ�� true��ʾ����  false��ʾ������

    webform.WebPDF.ShowBookMark = 1;			//�Ƿ���ʾ��ǩ����ť��1,��ʾ��0,����ʾ��
    webform.WebPDF.ShowSigns = 1;         	    //����ǩ�¹�������ǰ�Ƿ�ɼ���1,�ɼ���0,���ɼ���
    //alert(webform.WebPDF.SideWidth);          //��ʾ������Ŀ��
    webform.WebPDF.SideWidth = 100;             //���ò�����Ŀ��

    webform.WebPDF.WebOpen();                   //�򿪸��ĵ�    ����OfficeServer��OPTION="LOADFILE"    <�ο������ĵ�>
    StatusMsg(webform.WebPDF.Status);           //״̬��Ϣ

    webform.WebPDF.Zoom = 100;                  //���ű���
    webform.WebPDF.Rotate = 360;                //����ʾҳ�ͷŽǶ�
    webform.WebPDF.CurPage = 1;                 //��ǰ��ʾ��ҳ��
  }catch(e){
    alert(e.description);                       //��ʾ��������Ϣ
  }
}

//���ã��˳�iWebPDF
function UnLoad(){
  try{
    if (!webform.WebPDF.WebClose()){
      StatusMsg(webform.WebPDF.Status);
    }else{
      StatusMsg("�ر��ĵ�...");
    }
  }catch(e){
    alert(e.description);
  }
}

//���ã����ĵ�
function LoadDocument(){
  StatusMsg("���ڴ��ĵ�...");
  if (!webform.WebPDF.WebOpen()){               //�򿪸��ĵ�    ����OfficeServer��OPTION="LOADFILE"
    StatusMsg(webform.WebPDF.Status);
  }else{
    StatusMsg(webform.WebPDF.Status);
  }
}

//���ã������ĵ�
function SaveDocument(){
  //webform.WebPDF.WebSetMsgByName("mydefine1","�Զ������ֵ");  //���ñ���MyDefine1="�Զ������ֵ1"�������������ö��  ��WebSave()ʱ��һ���ύ��OfficeServer��
  if (!webform.WebPDF.WebSave()){               //����OfficeServer��OPTION="SAVEFILE"
    StatusMsg(webform.WebPDF.Status);
    return false;
  }else{
    StatusMsg(webform.WebPDF.Status);
    return true;
  }
}

//���ã��ر��ĵ�
function WebClose(){
  try{
    webform.WebPDF.WebClose();
    StatusMsg(webform.WebPDF.Status);
  }catch(e){
    alert(e.description);
  }
}

//���ã����汾���ĵ�
function WebSaveLocal(){
  try{
    webform.WebPDF.WebSaveLocal();
    StatusMsg(webform.WebPDF.Status);
  }catch(e){
    alert(e.description);
  }
}

//���ã��򿪱����ĵ�
function WebOpenLocal(){
  try{
    webform.WebPDF.WebOpenLocal();
    StatusMsg(webform.WebPDF.Status);
  }catch(e){
    alert(e.description);
  }
}

//���ã���ӡ�ĵ����ƴ�ӡ����
function WebPrintCtrl(Ctrl){
  try{
	webform.WebPDF.WebPrint(Ctrl,"",1,webform.WebPDF.PageCount,true);
    StatusMsg(webform.WebPDF.Status);
  }
  catch(e){
    alert(e.description);
  }
}

//���ã�������һҳ
function WebGotoFirstPage(){
  try{
    webform.WebPDF.GotoFirstPage();
    StatusMsg(webform.WebPDF.Status);
  }catch(e){
    alert(e.description);
  }
}

//���ã��������һҳ
function WebGotoLastPage(){
  try{
    webform.WebPDF.GotoLastPage();
    StatusMsg(webform.WebPDF.Status);
  }catch(e){
    alert(e.description);
  }
}

//���ã�����ǰһҳ
function WebGotoPreviousPage(){
  try{
    webform.WebPDF.GotoPreviousPage();
    StatusMsg(webform.WebPDF.Status);
  }catch(e){
    alert(e.description);
  }
}

//���ã�������һҳ
function WebGotoNextPage(){
  try{
    webform.WebPDF.GotoNextPage();
    StatusMsg(webform.WebPDF.Status);
  }catch(e){
    alert(e.description);
  }
}

//���ã���ȡ��ǰ�ĵ�ҳ��
function WebPageCount(){
  try{
    var mCount = webform.WebPDF.PageCount;
    alert("��ǰ�ĵ���ҳ��Ϊ��"+mCount)
  }catch(e){
    alert(e.description);
  }
}

//���ã���ǰ��ʾģʽ��1 ��ҳ 2 ˫ҳ 3 ������ҳ(Ĭ��) 4 ����˫ҳ��
function WebDisplayMode(mValue){
  try{
    webform.WebPDF.DisplayMode = mValue;
    StatusMsg(webform.WebPDF.Status);
  }catch(e){
    alert(e.description);
  }
}

//����:����,����ȫ�����ܰ�ť(����ToolsName:��ť������;mValue:true���� flase����)
function WebEnableTools(ToolNames,mValue){
  try{
    webform.WebPDF.EnableTools(ToolNames,mValue);
    StatusMsg(webform.WebPDF.Status);
  }catch(e){
    alert(e.description)
  }
}

//���ã�ͨ��Url���ĵ�
function WebOpenUrlFile(mUrl){
  try{
    webform.WebPDF.WebOpenUrlFile(mUrl);
    StatusMsg(webform.WebPDF.Status);
  }catch(e){
    alert(e.description);
  }
}

//���ã�����ָ���ļ�
function WebDownLoadFile(mUrl,mFileName){
  try{
    webform.WebPDF.WebDownLoadFile(mUrl,mFileName);
    alert("���ر���ɹ��������ַΪC:\\123.pdf��");
  }catch(e){
    alert(e.description);
  }
}

//���ã��ͻ��˺ͷ���������Ϣ����
function WebSendInformation(){
  var info = window.prompt("������Ҫ��������������ҳ���ϵ�����:","��������");
  if (info==null){return false}

  webform.WebPDF.WebSetMsgByName("COMMAND","SELFINFO");     //���ñ���COMMAND="SELFINFO"�������ڷ����������жϣ��Խ��봦���Զ���������ݵĴ��롣
  webform.WebPDF.WebSetMsgByName("TESTINFO",info);          //�Զ����һ������"TESTINFO"����info��������Ϣ���õ���Ϣ���У��Ա㴫����̨��
  if (webform.WebPDF.WebSendMessage()){                     //���̨����Ϣ��������OfficeServer��OPTION="SENDMESSAGE"��
    info = webform.WebPDF.WebGetMsgByName("RETURNINFO");    //��������ɹ������ܷ������˷��ص���Ϣ��
    alert(info);
  }
  else{
    StatusMsg(webform.WebPDF.Status);
  }
}


//���ã���PDF�ĵ�������ˮӡ
function WebSetWateMark(mText){
  try{
    var mPageCount = webform.WebPDF.PageCount;                              //webform.WebPDF.PageCount��õ�ǰ��ҳ��
    if (webform.WebPDF.EditStatus){                                         //��ȡ��ǰPDF�ĵ�״̬������������ĵ��ĵ��Ϳ���ִ��ˮӡд����
      webform.WebPDF.WateMark(1,mPageCount,mText,25,125,45,true,-1,-1);     //����ˮӡ������һ����ʼҳ��������������ҳ����������ˮӡ�ı��������ģ�͸���ȣ������壺�����С������������ת�Ƕȣ���ʱ�룩�������ߣ�ˮӡλ�ã������ˣ�ˮӡX���ꣻ�����ţ�ˮӡY���ꡣ
      //alert("��PDF�ĵ�����༭������ˮӡ�ɹ�");
    }else{
      alert("��PDF�ĵ�������༭���޷�����ˮӡ");
    }
  }catch(e){
    alert(e.description);                                       //��ʾ��������Ϣ
  }
}

//=====================iSignature PDF����ǩ����ؽӿ�========================================


//���ã�����ǩ�´���
function WebShowSignDlg(){
  if (!(webform.WebPDF.ShowSignDlg())){
    alert("����ǩ�´���ʧ��");  
  }
}

//���ã�����������֤
function WebShowCheckDlg(){
  if (!(webform.WebPDF.ShowCheckDlg())){
    alert("����������֤ʧ��");  
  }
}

//���ã����ò������ô���
function WebShowParamDlg(){
  if (!(webform.WebPDF.ShowParamDlg())){
    alert("���ò������ô���ʧ��");  
  }
}

//���ã���ȡǩ��XML������UTF-8�룩
function WebSignatureItem(){
  alert(webform.WebPDF.SignatureItem(-1));
}

//���ã���ȡ�ĵ���ǩ������XML
function GetSignatureItemsXML(){
  var i;
  var LoadOk;
  var ErrorObj;
  var XmlObj = new ActiveXObject("Microsoft.XMLDOM");
  var XmlText;
  
  XmlObj.async = false;
  LoadOk=XmlObj.loadXML(webform.WebPDF.SignatureItem(-1));
  //alert(webform.WebPDF.SignatureItem());
  ErrorObj = XmlObj.parseError;
  if (ErrorObj.errorCode != 0){
    alert("������Ϣ����..." + ErrorObj.reason);
  }
  else{
    var CurNodes=XmlObj.getElementsByTagName("Signature_PDF");
    if( 1 == CurNodes.length ){
      var SignNode=CurNodes.item(0);
      if( SignNode.hasChildNodes() ){
        var SignNodes = SignNode.childNodes;
        for (var iXml=0;iXml<SignNodes.length;iXml++){
          var signItem = SignNodes.item(iXml);
          XmlText = "ǩ���Ƿ񱣻��ĵ���" + signItem.selectSingleNode("SignatureProtect").text + ";    True: �ĵ��Ķ�ǩ�»�仯��False: �ĵ��Ķ�ǩ�²���仯\r\n";
          XmlText = XmlText + "�ĵ��Ƿ�������" + signItem.selectSingleNode("SignatureResult").text + ";    True: �ĵ�������False: �ĵ�������\r\n";
          XmlText = XmlText + "ǩ�����ƣ�" + signItem.selectSingleNode("SignatureName").text + ";\r\n";
          XmlText = XmlText + "ǩ��Ӧ�ó���" + signItem.selectSingleNode("SignatureApp").text + ";\r\n";	
          XmlText = XmlText + "ǩ�µ�λ��" + signItem.selectSingleNode("SignatureUnit").text + ";\r\n";	
          XmlText = XmlText + "ǩ���û���" + signItem.selectSingleNode("SignatureUser").text + ";\r\n";
          XmlText = XmlText + "ǩ�´���Կ�������кţ�" + signItem.selectSingleNode("SignatureKeySN").text + ";\r\n";
          XmlText = XmlText + "ǩ�����кţ�" + signItem.selectSingleNode("SignatureSN").text + ";\r\n";
          XmlText = XmlText + "ǩ��ʱ�䣺" + signItem.selectSingleNode("SignatureDate").text + ";\r\n";
          XmlText = XmlText + "ǩ�����ͣ�" + signItem.selectSingleNode("SignatureType").text + ";    ǩ�����ͣ�0��û�н���ǩ�£�1������ǩ�£�2����дǩ�£�3����ά����\r\n";
          XmlText = XmlText + "�ĵ�������" + signItem.selectSingleNode("SignatureLocked").text + ";    True:����ĵ���������״̬���Ǹ�ǩ��ִ�е���������; False:����ĵ���������״̬�����Ǹ�ǩ��ִ�е���������\r\n";
          alert(XmlText);
        }
      }
    }
  }
  delete XmlObj;
}

//���ã���ҳ����ת��ָ�����Ƶ���ǩλ��(����ֵΪ�����ʾ�ɹ���λ�����ʾ����ָ�����Ƶ���ǩʧ��)
function WebGotoBookMark(){
  try{
    var mBookMark = window.prompt("������Ҫ��ת������ǩ����","��ǩ����");
    if(mBookMark==null){return false;}
    webform.WebPDF.GotoBookMark(mBookMark);
  }catch(e){
    alert(e.description); 
  }
}

//����:����ҳ���Ƿ���ʾ(����Pages:ҳ�淶Χ;Enable:true��ʾ flase����ʾ;Text��ʾ������)
function WebEnablePages(){
  try{
    alert("ʾ���н���ֹ��ʾ��һҳ������");
    webform.WebPDF.EnablePages(1,false,"��һҳ�ѱ���ֹ��ʾ");//���Խ�ֹ��ʾ��ҳ���磺"1-10,15,20"��
  }catch(e){
    alert(e.description)
  }
}

//���ã���ȡָ������������Ĵ����ı�
function WebGetErrorString(){
   try{
     var mCode = window.prompt("��������Ҫ��ѯ�Ĵ�����룬�������ӡ�-1������32���ܹ�34����","14");
     if(mCode==null){return false;}
     var mError=webform.WebPDF.GetErrorString(mCode); //ͨ����������ô�����Ϣ���������ӡ�-1������32�����ܹ�34����
     alert("�����Ӧ�Ĵ�����ϢΪ��"+mError);
  }catch(e){
    alert(e.description);
  }
}

//���ã���ȡָ��ҳ�ĳ��ȡ���ȼ��Ƕ�
function WebGetPageSize(){
  try{
    var mWidth = webform.WebPDF.GetPageSize(1,0); //����ҳ����ߡ��Ƕȡ� ����һ����ʼҳ��������������ֵ���ͣ�0����� 1���߶� 2����ת�Ƕ�
    var mHeight = webform.WebPDF.GetPageSize(1,1);
    var meight = webform.WebPDF.GetPageSize(1,2);

    alert("�����з��ص�һҳ�Ŀ�ȣ�"+mWidth+"���߶ȣ�"+mHeight+"����ת�Ƕȣ�"+webform.WebPDF.GetPageSize(1,2));
  }catch(e){
    alert(e.description);
  }
}

//���ã��ж��ĵ��Ƿ��
function FileisOpen(){
  try{
    var mOpen = webform.WebPDF.isOpen; //����1Ϊ�򿪣�0Ϊû�д�
    if(mOpen==1){
      mOpen = "�ĵ��Ѿ��򿪣�";
    }else{
      mOpen = "û���ĵ����򿪣�";
    }
    alert(mOpen);
  }catch(e){
    alert(e.description);
  }
}

//���ã���ȡ��ǰ�ĵ��е������������ݣ������ݿ���������ȫ�ļ���
function GetContentText(){
  try{    
    alert(webform.WebPDF.ContentText);
  }catch(e){
    alert(e.description);
  }
}

</script>
</head>
<body bgcolor="#ffffff" onLoad="Load()" onUnload="UnLoad()">  <!--�������˳�iWebPDF-->
<form name="webform" method="post" action="DocumentSave.jsp" onSubmit="return SaveDocument();">  <!--����iWebPDF���ύ����Ϣ-->
<input type=hidden name=RecordID value="<%=mRecordID%>">
<table border=0 cellspacing='0' cellpadding='0' width=100% height=100% align=center class=TBStyle>
      <tr>
        <td height="24" align=center class="TDTitleStyle">������</td>
        <td class="TDStyle">&nbsp;<input type="text" name="Subject" value="<%=mSubject%>" class="IptStyle" style="WIDTH:75%">&nbsp;|������������</td>
        <td width="400" rowspan="4" class="TDTitleStyle" align="center"><input type="submit"  value="�����ĵ�">&nbsp;<input type=button onClick="history.back()" value="�����б�"><br><br>ע�⣺ֻ�н��С������ĵ����������Ĳ�������Ч��</td>
      </tr>
      <tr>
        <td height="24" align=center class="TDTitleStyle">������</td>
        <td class="TDStyle">&nbsp;<input type=text name=Author value="<%=mAuthor%>" class="IptStyle"  style="WIDTH:75%">&nbsp;|������������</td>
      </tr>
      <tr>
        <td height="24" align=center class="TDTitleStyle">ʱ����</td>
        <td class="TDStyle">&nbsp;<input type=text name=FileDate value="<%=mFileDate%>" readonly class="IptStyleBlack" style="WIDTH:75%">&nbsp;|���༭ʱ��</td>
      </tr>
      <tr>
        <td height="24" align=center class="TDTitleStyle">״��̬</td>
        <td class="TDStyle">&nbsp;<input type=text name=StatusBar readonly class="IptStyleBlack" style="WIDTH:75%">&nbsp;|��״̬��Ϣ</td>
      </tr>
      <tr width="100" height="28">
        <td align="center" class="TDTitleMiddleStyle">
          <font color="#FF0000"><b>���ĵ��Ķ����ܡ�</b></font>	    </td>
        <td height="100%" colspan="2" rowspan="7" align="right" valign="top" class="TDStyle" hegith="90%">
          <table border="0" cellspacing="0" cellpadding="0" width="100%" height="100%">
            <tr>
              <td bgcolor="menu" height="98%" valign="top">
                <!--����iWebPicture��ע��汾�ţ�����������-->
			    <script src="iWebPDF.js"></script>              </td>
            </tr>
          </table>        </td>
      </tr>
      <tr width="100">
        <td align="center" valign=top class="TDTitleStyle" width="100" height="90%">
          <input type=button class=SideButton onClick="WebOpenLocal()" value="�򿪱����ĵ�">
          <input type=button class=SideButton onClick="WebSaveLocal()" value="�ĵ����汾��">
          <input type=button class=SideButton onClick="WebOpenUrlFile('http://www.goldgrid.com/iWebPDF/Demo.pdf')" value="��Url�ĵ�">
          <input type=button class=SideButton onClick="WebClose()" value="�رյ�ǰ�ĵ�">
          <input type=button class=SideButton onClick="WebGotoFirstPage()" value="������ǰҳ">
          <input type=button class=SideButton onClick="WebGotoPreviousPage()" value="��ǰ��һҳ">
          <input type=button class=SideButton onClick="WebGotoNextPage()" value="���һҳ">
          <input type=button class=SideButton onClick="WebGotoLastPage()" value="�������ҳ">
          <input type=button class=SideButton onClick="WebDisplayMode(1)" value="������ҳ��ʾ">
          <input type=button class=SideButton onClick="WebDisplayMode(3)" value="������ҳ��ʾ">
          <input type=button class=SideButton onClick="WebDisplayMode(2)" value="����˫ҳ��ʾ">
          <input type=button class=SideButton onClick="WebDisplayMode(4)" value="����˫ҳ��ʾ">        </td>
      </tr>
      <tr width="100">
        <td align="center" class="TDTitleMiddleStyle" height="28">
          <font color="#FF0000"><b>���ĵ����ƹ��ܡ�</b></font>	    </td>
      </tr>
      <tr width="100">
        <td align="center" valign=top class="TDTitleStyle" width="100">
          <input type=button class=SideButton onClick="WebEnableTools('��ӡ�ĵ�',false)" value="��ֹ��ӡ��ť">
          <input type=button class=SideButton onClick="WebEnableTools('���ĵ�;�����ĵ�;���Ϊ;�ر��ĵ�;��ӡ�ĵ�;ʵ�ʴ�С;��Ӧҳ��;��Ӧ�߶�;����ת;���ҷ�ת;�ĵ�����;����ǩ��;������֤;�ı�ѡ��;���չ���;ǩ�²���;�����ı�;���ڽ��',0)" value="��ֹȫ����ť">
          <input type=button class=SideButton onClick="WebEnableTools('���ĵ�;�����ĵ�;���Ϊ;�ر��ĵ�;��ӡ�ĵ�;ʵ�ʴ�С;��Ӧҳ��;��Ӧ�߶�;����ת;���ҷ�ת;�ĵ�����;����ǩ��;������֤;�ı�ѡ��;���չ���;ǩ�²���;�����ı�;���ڽ��',1)" value="����ȫ����ť">
          <input type=button class=SideButton onClick="WebPageCount()" value="��ȡ��ҳ��">
          <input type=button class=SideButton onClick="GetContentText()" value="��ȡ�ĵ�����">
          <input type=button class=SideButton onClick="WebGotoBookMark()" value="��תָ��λ��">
          <input type=button class=SideButton onClick="WebEnablePages()" value="��ֹ��ʾĳҳ">
          <input type=button class=SideButton onClick="WebGetErrorString()" value="��ȡ�����ı�">
          <input type=button class=SideButton onClick="WebGetPageSize()" value="��ʾҳ�����">
          <input type=button class=SideButton onClick="FileisOpen()" value="�ĵ��Ƿ��">
          <input type=button class=SideButton onClick="WebPrintCtrl(3)" value="��ӡ�ĵ�����">
          <input type=button class=SideButton onClick="WebDownLoadFile('http://www.goldgrid.com/iWebPDF/Demo.pdf','C:\\123.pdf')" value="����ָ���ļ�">
          <input type=button class=SideButton onClick="WebSendInformation()" value="��ˢ����Ϣ����">
          <input type=button class=SideButton onClick="WebSetWateMark('���Ƽ�')" value="����ˮӡ">        </td>
      </tr>
      <tr width="100">
        <td align="center" class="TDTitleMiddleStyle" height="28">
          <font color="#FF0000"><b>������ǩ�¹��ܡ�</b></font>	    </td>
      </tr>
      <tr width="100">
        <td align="center" valign=top class="TDTitleStyle" width="100">
          <input type=button class=SideButton onClick="WebShowSignDlg()" value="����ǩ��">
          <input type=button class=SideButton onClick="WebShowCheckDlg()" value="������֤">
          <input type=button class=SideButton onClick="WebShowParamDlg()" value="��������">
          <input type=button class=SideButton onClick="WebSignatureItem()" value="����ǩ��XML">
          <input type=button class=SideButton onClick="GetSignatureItemsXML()" value="��ȡǩ��XML"></td>
      </tr>      
    </table>
</form>
</body>
</html>