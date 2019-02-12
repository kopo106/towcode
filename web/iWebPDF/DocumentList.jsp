<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.util.*,java.sql.*,java.text.SimpleDateFormat,java.text.DateFormat,java.util.Date,DBstep.iDBManager2000.*" %>
<%!
DBstep.iDBManager2000 DbaObj=new DBstep.iDBManager2000();
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
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>���iWebPDFʾ������</title>
<link rel='stylesheet' type='text/css' href='test.css'>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<script type="" language="javascript">
  function aaa()
  {
    alert("aaa");
  }
</script>
</head>
<body bgcolor="#ffffff">
<div align="center"><font size="4" color="ff0000">iWebPDF���߹����м�����Ķ��棩ʾ������</font></div>
<br>
<table width="100%"><tr><td height="600"><script src="iWebPDF.js"></script></td></tr></table>
<h1>���Ƿָ�����Ҫ���������ģ�</h1>
<hr size=1>
<table border=0  cellspacing='0' cellpadding='0' width=100% align=center class=TBStyle>
<tr>
  <td nowrap class="TDTitleStyle" style="line-height:20px; padding-left:10px;">
    <p style="color:#000000">����ע�⣺<br>
      ����ʽ���ʵ�ָ�ǿ��Ĺ��ܣ���Ҫ��ʽ��������Ƽ���ϵ��0791-82221588����<br>
      �����ϣ����ȷ��ʾ��ʾ��������Ҫ��������������<br>
      ��1����ʹ��Windows XP���ϲ���ϵͳ��IE6���ϵ��������<br>
      ��2�����ڴ򿪱�ҳ�浯����װ����Ĵ���ʱѡ�񡾰�װ����ť������������װiWebPDF�����<br>
      ��3��������������Զ���װiWebPDF���������������<a href="iWebPDF.cab">���ذ�װ����</a>��<br>
	  </p>
  </td>  
  <td height="32" width="350" align=center nowrap class="TDTitleStyle">��ǰ�û���
    <input type=text name="username" size=12 value="��ʾ��">��
    <input type="button" name="CreatPDF" value="�½�PDF" onClick="javascript:location.href='DocumentEdit.jsp?UserName='+username.value;">
  </td>
</tr>
</table>
<br>

<table border=0  cellspacing='0' cellpadding='0' width=100% align=center class=TBStyle>
<tr>
  <td width="100" height="25" align=center nowrap class="TDTitleStyle">���</td>
  <td align=center nowrap class="TDTitleStyle">����</td>
  <td width="150" align=center nowrap class="TDTitleStyle">����</td>
  <td width="150" align=center nowrap class="TDTitleStyle">����</td>
  <td width="150" align=center nowrap class="TDTitleStyle">����</td>
  <td width="150" align=center nowrap class="TDTitleStyle">����</td>
</tr>

<%
  try {
      if (DbaObj.OpenConnection()) {
        try {
          ResultSet result = DbaObj.ExecuteQuery("select * from Document order by DocumentID desc");
          while (result.next()) {
%>
<tr>
  <td align="center" class="TDStyle"><%=result.getString("DocumentID")%>&nbsp;</td>
  <td align="center" class="TDStyle"><%=result.getString("Subject")%>&nbsp;</td>
  <td align="center" class="TDStyle"><%=result.getString("Author")%>&nbsp;</td>
  <td align="center" class="TDStyle"><%=result.getString("FileType")%>&nbsp;</td>
  <td align="center" class="TDStyle"><%=FormatDate(result.getString("FileDate"),"yyyy-MM-dd")%>&nbsp;</td>
  <td align="center"  nowrap class="TDStyle">
    <input type=button  onclick="javascript:location.href='DocumentEdit.jsp?RecordID=<%=result.getString("RecordID")%>&UserName='+username.value;" value="�Ķ�"></td>
</tr>
<%
          }
          result.close();
        }
        catch (SQLException sqlex) {
          System.out.println(sqlex.toString());
        }
      }
      else {
        out.println("OpenDatabase Error");
      }
    }
    finally {
      DbaObj.CloseConnection();
    }
%>
</table>
</body>
</html>
