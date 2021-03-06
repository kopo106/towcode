<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.hnkypg.pojo.User" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%--<c: if test="${user.userid!=null}">--%>
<% if(request.getSession().getAttribute("user")!=null){ %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <base href="<%=basePath%>">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>河南开源技术部</title>

    <!-- Bootstrap core CSS -->
    <link href="dashboard/css/bootstrap.min.css" rel="stylesheet">
    <link href="dashboard/css/bootstrap-table.min.css" rel="stylesheet">
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="dashboard/css/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<%User loginuser = (User) request.getSession().getAttribute("user"); %>
<%@ include file="../zz/header.jsp" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li><a href="<%=basePath%>fgsindex.do">主页 </a></li>
                <li class="active" ><a href="<%=basePath%>lyinput.do"><span class="sr-only">(current)</span>报告录入</a></li>
            </ul>

        </div>
        <div class="col-md-9 col-md-offset-2 main">
            <br/>
            <h1 class="page-header">报告录入</h1>
            <br/>
            <input type="hidden" id="errorif" value="${error}" />
            <div class="row">
                <div class="col-md-6 col-md-offset-3 " id="test2">
                </div>
            </div>

            <form class="form-inline" action="<%=basePath%>lyinputfix.do" method="post">
                <div class="row">
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="select">报告类型</label>
                            <select class="form-control" id="select" name="baogaotype">
                                <c:if test="${bgl.baogaotype !=null}"><option>${bgl.baogaotype}</option></c:if>
                                <option>------------</option>
                                <option>预评报告</option>
                                <option>正式报告</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="select">部门</label>
                            <select class="form-control" id="bumen" name="bumen">
                                <c:if test="${bgl.bumen !=null}"><option>${bgl.bumen}</option></c:if>
                                <option>------------</option>
                                <option>洛阳市</option>
                                <option>新乡市</option>
                                <option>安阳市</option>
                                <option>商丘市</option>
                                <option>三门峡市</option>
                                <option>平顶山市</option>
                            </select>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="bgnum">报告编号</label>
                            <input type="text" name="bgnum" class="form-control" id="bgnum" placeholder="正式/预评报告编号"  <c:if test="${bgl.bgnum !=null}"> value="${bgl.bgnum}"</c:if>>
                        </div>
                    </div>
                    <br/><br/><br>
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="laiyuan">项目来源</label>
                            <input type="text" name="laiyuan" class="form-control" id="laiyuan" placeholder="项目来源渠道" <c:if test="${bgl.laiyuan !=null}"> value="${bgl.laiyuan}"</c:if>>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="shidian">价值时点</label>
                            <input type="date" name="shidian" class="form-control" id="shidian" placeholder="价值时点"  <c:if test="${bgl.shidian !=null}"> value="${bgl.shidian}"</c:if>>
                        </div>
                    </div>


                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="chujudate">出具日期</label>
                            <input type="date" name="chujudate" class="form-control" id="chujudate" placeholder="报告出具日期"  <c:if test="${bgl.chujudate !=null}"> value="${bgl.chujudate}"</c:if>>
                        </div>
                    </div>
                    <br/><br/><br>

                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="fuzeren">项目负责人</label>
                            <input type="text" autocomplete="off" data-provide="typeahead" name="fuzeren" class="form-control" id="fuzeren" placeholder="项目负责人"  <c:if test="${bgl.fuzeren.username !=null}"> value="${bgl.fuzeren.username}---${bgl.fuzeren.bumen}" </c:if>>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="gujiashi">签字估价师</label>
                            <input type="text"  name="gujiashi" class="form-control" id="gujiashi" placeholder="估价师" <c:if test="${bgl.gujiashi !=null}"> value="${bgl.gujiashi}" </c:if>>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="tel">联系电话</label>
                            <input type="text" name="tel" class="form-control" id="tel" placeholder="报告联系人电话" <c:if test="${bgl.tel !=null}"> value="${bgl.tel}" </c:if>>
                        </div>
                    </div>

                    <br><br><br>


                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="memo">备注</label>
                            <input type="text" name="memo" class="form-control" id="memo" placeholder="备注" <c:if test="${bgl.memo !=null}"> value="${bgl.memo}" </c:if>>
                        </div>
                    </div>
                    <br><br><br>



                    <h3>添加标的物</h3>
                    <hr>
                    <div class="col-md-3">
                        <div class="form-group">
                            <input type="button"  name="add" class="form-control" id="add" value="添加标的物">
                        </div>
                    </div>
                    <br><br><br>
                    <div id ="biaodiwu">
                        <c:if test="${bgs !=null}">
                            <c:forEach var="b" items="${bgs}" varStatus="status">
                                <div id="bdw${status.index+1}">
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label for="chanquanren">产权人</label>
                                            <input type="text" name="chanquanren${status.index+1}" class="form-control" id="chanquanren" placeholder="产权人姓名" value="${b.chanquanren}">
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label for="zuoluo">房屋坐落</label>
                                            <input type="text" name="zuoluo${status.index+1}" class="form-control" id="zuoluo" placeholder="正式/预评报告编号" value="${b.zuoluo}">
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label for="mianji">建筑面积</label>
                                            <input type="text" name="mianji${status.index+1}" class="form-control" id="mianji" placeholder="建筑面积"  value="${b.mianji}">
                                        </div>
                                    </div>
                                    <br><br><br>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label for="niandai">建筑年代</label>
                                            <input type="text" name="niandai${status.index+1}" class="form-control" id="niandai" placeholder="竣工年代"  value="${b.niandai}">
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label for="suo">所在层数</label>
                                            <input type="text" name="suo${status.index+1}" class="form-control" id="suo" placeholder="所在层"  value="${b.suo}">
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label for="zong">总层数</label>
                                            <input type="text" name="zong${status.index+1}" class="form-control" id="zong" placeholder="总层数"  value="${b.zong}">
                                        </div>
                                    </div>
                                    <br><br><br>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label for="yongtu">规划用途</label>
                                            <input type="text" name="yongtu${status.index+1}" class="form-control" id="yongtu" placeholder="规划用途"  value="${b.yongtu}">
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label for="dan">单价（元/㎡）</label>
                                            <input type="text" name="danjia${status.index+1}" class="form-control" id="dan" placeholder="评估单价"  value="${b.danjia}">
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label for="proname">小区名称</label>
                                            <input type="text" name="proname${status.index+1}" class="form-control" id="proname" placeholder="小区名称"  value="${b.proname}">
                                        </div>
                                    </div>
                                    <br/><br/><br>
                                    <div class="col-md-5">
                                        <div class="form-group">
                                            <label for="zongjia">总价（万元）</label>
                                            <input type="text" name="zongjia${status.index+1}" class="form-control" id="zongjia" placeholder="标的物总价"  value="${b.zongjia}">
                                            <select class="form-control" id="point" name="point${status.index+1}" >
                                                <option>${b.point}</option>
                                                <option>保留二位</option>
                                                <option>保留一位</option>
                                                <option>不保留</option>
                                            </select>
                                        </div>
                                    </div>
                                    <input type="button" class="form-control del" id="${status.index+1}" value="移除该标的物" />
                                    <br/><br/><br>
                                </div>
                            </c:forEach>
                        </c:if>

                    </div>

                    <div class="col-md-10">
                        <input type="hidden" name="bdwct" id="bdwct" <c:if test="${bdwct !=null}"> value="${bdwct}" </c:if>/>
                        <p class="text-center">
                            <input class="btn btn-default" type="submit" value="提交报告">
                            <input class="btn btn-default" type="reset" value="重新填写">
                        </p>

                    </div>
                </div>


            </form>


        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="dashboard/js/jquery-3.2.0.min.js"></script>

<script src="dashboard/js/bootstrap.min.js"></script>
<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<script src="dashboard/js/bootstrap-table.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="dashboard/js/bootstrap-table-zh-CN.js"></script>
<script src="dashboard/js/bootstrap3-typeahead.js"></script>
</body>
</html>
<script>
    $("#biaoti").css({color:"#F4FBFF",
        fontSize:30,fontType:"楷体"});
</script>
<script>
    $("#zhuanxie").typeahead({
        source: function (query, process) {
            var parameter = {query: query};
            $.post('testa.do', parameter, function (data) {
                process(data);
            });
        },
        items: 8,//最多显示个数
        updater: function (item) {
            return item;//这里一定要return，否则选中不显示，外加调用display的时候null reference错误。
        },
        displayText: function (item) {
            return item;//返回字符串
        },
        afterSelect: function (item) {
            //选择项之后的事件 ，item是当前选中的。
        },
        delay: 500//延迟时间
    });

    $("#shenhe").typeahead({
        source: function (query, process) {
            var parameter = {query: query};
            $.post('testa.do', parameter, function (data) {
                process(data);
            });
        },
        items: 8,//最多显示个数
        updater: function (item) {
            return item;//这里一定要return，否则选中不显示，外加调用display的时候null reference错误。
        },
        displayText: function (item) {
            return item;//返回字符串
        },
        afterSelect: function (item) {
            //选择项之后的事件 ，item是当前选中的。
        },
        delay: 500//延迟时间
    });

    $("#kancha").typeahead({
        source: function (query, process) {
            var parameter = {query: query};
            $.post('testa.do', parameter, function (data) {
                process(data);
            });
        },
        items: 8,//最多显示个数
        updater: function (item) {
            return item;//这里一定要return，否则选中不显示，外加调用display的时候null reference错误。
        },
        displayText: function (item) {
            return item;//返回字符串
        },
        afterSelect: function (item) {
            //选择项之后的事件 ，item是当前选中的。
        },
        delay: 500//延迟时间
    });

    $("#jiazhigoutong").typeahead({
        source: function (query, process) {
            var parameter = {query: query};
            $.post('testa.do', parameter, function (data) {
                process(data);
            });
        },
        items: 8,//最多显示个数
        updater: function (item) {
            return item;//这里一定要return，否则选中不显示，外加调用display的时候null reference错误。
        },
        displayText: function (item) {
            return item;//返回字符串
        },
        afterSelect: function (item) {
            //选择项之后的事件 ，item是当前选中的。
        },
        delay: 500//延迟时间
    });
    $("#dingjia").typeahead({
        source: function (query, process) {
            var parameter = {query: query};
            $.post('testa.do', parameter, function (data) {
                process(data);
            });
        },
        items: 8,//最多显示个数
        updater: function (item) {
            return item;//这里一定要return，否则选中不显示，外加调用display的时候null reference错误。
        },
        displayText: function (item) {
            return item;//返回字符串
        },
        afterSelect: function (item) {
            //选择项之后的事件 ，item是当前选中的。
        },
        delay: 500//延迟时间
    });
    $("#shidikc").typeahead({
        source: function (query, process) {
            var parameter = {query: query};
            $.post('testa.do', parameter, function (data) {
                process(data);
            });
        },
        items: 8,//最多显示个数
        updater: function (item) {
            return item;//这里一定要return，否则选中不显示，外加调用display的时候null reference错误。
        },
        displayText: function (item) {
            return item;//返回字符串
        },
        afterSelect: function (item) {
            //选择项之后的事件 ，item是当前选中的。
        },
        delay: 500//延迟时间
    });

    $("#jszhuanxie").typeahead({
        source: function (query, process) {
            var parameter = {query: query};
            $.post('testa.do', parameter, function (data) {
                process(data);
            });
        },
        items: 8,//最多显示个数
        updater: function (item) {
            return item;//这里一定要return，否则选中不显示，外加调用display的时候null reference错误。
        },
        displayText: function (item) {
            return item;//返回字符串
        },
        afterSelect: function (item) {
            //选择项之后的事件 ，item是当前选中的。
        },
        delay: 500//延迟时间
    });

    $("#fuzeren").typeahead({
        source: function (query, process) {
            var parameter = {query: query};
            $.post('testa.do', parameter, function (data) {
                process(data);
            });
        },
        items: 8,//最多显示个数
        updater: function (item) {
            return item;//这里一定要return，否则选中不显示，外加调用display的时候null reference错误。
        },
        displayText: function (item) {
            return item;//返回字符串
        },
        afterSelect: function (item) {
            //选择项之后的事件 ，item是当前选中的。
        },
        delay: 500//延迟时间
    });

</script>

<script type="text/javascript" charset="utf-8">
    $(function() {
        var sss = $("#bdwct").val();
//        alert(sss);
        if(sss.length<1){
            var dels =  new Array();
            var bdwv = new Array();
            var fieldCount = 1;
            var bdwnow =0 ;
        }else if(sss.length==1) {
            var dels =  new Array();
            var bdwv = new Array();
            var fieldCount = 2;
            var bdwnow =0 ;

            bdwv.push(1);
        }else{
            var dels =  new Array();
            var bdwv = sss.split(",");
            var fieldCount = bdwv.length+1;
            var bdwnow =0 ;
        }

        $("#add").click(function() {
            if(fieldCount <= 5)
            {
                if(dels.length <1){
                    var fieldID = fieldCount;
                    var inputbdw ='\
                <div id=bdw"'+fieldID+'">\
                    <div class="col-md-3">\
                        <div class="form-group">\
                            <label for="chanquanren">产权人</label>\
                            <input type="text" name="chanquanren'+fieldID+'" class="form-control" id="chanquanren" placeholder="产权人姓名">\
                        </div>\
                    </div>\
                    <div class="col-md-3">\
                        <div class="form-group">\
                            <label for="zuoluo">房屋坐落</label>\
                            <input type="text" name="zuoluo'+fieldID+'" class="form-control" id="zuoluo" placeholder="正式/预评报告编号">\
                        </div>\
                    </div>\
                    <div class="col-md-3">\
                        <div class="form-group">\
                            <label for="mianji">建筑面积</label>\
                            <input type="text" name="mianji'+fieldID+'" class="form-control" id="mianji" placeholder="建筑面积">\
                        </div>\
                    </div>\
                    <br><br><br>\
                    <div class="col-md-3">\
                        <div class="form-group">\
                            <label for="niandai">建筑年代</label>\
                            <input type="text" name="niandai'+fieldID+'" class="form-control" id="niandai" placeholder="竣工年代">\
                        </div>\
                    </div>\
                    <div class="col-md-3">\
                        <div class="form-group">\
                            <label for="suo">所在层数</label>\
                            <input type="text" name="suo'+fieldID+'" class="form-control" id="suo" placeholder="所在层">\
                        </div>\
                    </div>\
                    <div class="col-md-3">\
                        <div class="form-group">\
                            <label for="zong">总层数</label>\
                            <input type="text" name="zong'+fieldID+'" class="form-control" id="zong" placeholder="总层数">\
                        </div>\
                    </div>\
                    <br><br><br>\
                    <div class="col-md-3">\
                        <div class="form-group">\
                            <label for="yongtu">规划用途</label>\
                            <input type="text" name="yongtu'+fieldID+'" class="form-control" id="yongtu" placeholder="规划用途">\
                        </div>\
                    </div>\
                    <div class="col-md-3">\
                        <div class="form-group">\
                            <label for="dan">单价（元/㎡）</label>\
                            <input type="text" name="danjia'+fieldID+'" class="form-control" id="dan" placeholder="评估单价">\
                        </div>\
                    </div>\
                    <div class="col-md-3">\
                        <div class="form-group">\
                            <label for="proname">小区名称</label>\
                            <input type="text" name="proname'+fieldID+'" class="form-control" id="proname" placeholder="小区名称">\
                        </div>\
                    </div>\
                    <br/><br/><br>\
                    <div class="col-md-5">\
                        <div class="form-group">\
                            <label for="zongjia">总价（万元）</label>\
                            <input type="text" name="zongjia'+fieldID+'" class="form-control" id="zongjia" placeholder="标的物总价">\
                            <select class="form-control" id="point" name="point'+fieldID+'">\
                            <option>保留二位</option>\
                            <option>保留一位</option>\
                            <option>不保留</option>\
                            </select>\
                        </div>\
                    </div>\
                <input type="button" class="form-control del" id="'+fieldID+'" value="移除该标的物" />\
                <br/><br/><br>\
                </div>';
                    $("#biaodiwu").append(inputbdw);
                    bdwv.push(fieldCount);
                    fieldCount++;

                }
                else{

                    var inputbdw ='\
                <div id=bdw"'+fieldID+'">\
                    <div class="col-md-3">\
                        <div class="form-group">\
                            <label for="chanquanren">产权人</label>\
                            <input type="text" name="chanquanren'+dels[0]+'" class="form-control" id="chanquanren" placeholder="产权人姓名">\
                        </div>\
                    </div>\
                    <div class="col-md-3">\
                        <div class="form-group">\
                            <label for="zuoluo">房屋坐落</label>\
                            <input type="text" name="zuoluo'+dels[0]+'" class="form-control" id="zuoluo" placeholder="正式/预评报告编号">\
                        </div>\
                    </div>\
                    <div class="col-md-3">\
                        <div class="form-group">\
                            <label for="mianji">建筑面积</label>\
                            <input type="text" name="mianji'+dels[0]+'" class="form-control" id="mianji" placeholder="建筑面积">\
                        </div>\
                    </div>\
                    <br><br><br>\
                    <div class="col-md-3">\
                        <div class="form-group">\
                            <label for="niandai">建筑年代</label>\
                            <input type="text" name="niandai'+dels[0]+'" class="form-control" id="niandai" placeholder="竣工年代">\
                        </div>\
                    </div>\
                    <div class="col-md-3">\
                        <div class="form-group">\
                            <label for="suo">所在层数</label>\
                            <input type="text" name="suo'+dels[0]+'" class="form-control" id="suo" placeholder="所在层">\
                        </div>\
                    </div>\
                    <div class="col-md-3">\
                        <div class="form-group">\
                            <label for="zong">总层数</label>\
                            <input type="text" name="zong'+dels[0]+'" class="form-control" id="zong" placeholder="总层数">\
                        </div>\
                    </div>\
                    <br><br><br>\
                    <div class="col-md-3">\
                        <div class="form-group">\
                            <label for="yongtu">规划用途</label>\
                            <input type="text" name="yongtu'+dels[0]+'" class="form-control" id="yongtu" placeholder="规划用途">\
                        </div>\
                    </div>\
                    <div class="col-md-3">\
                        <div class="form-group">\
                            <label for="dan">单价（元/㎡）</label>\
                            <input type="text" name="danjia'+dels[0]+'" class="form-control" id="dan" placeholder="评估单价">\
                        </div>\
                    </div>\
                    <div class="col-md-3">\
                        <div class="form-group">\
                            <label for="proname">小区名称</label>\
                            <input type="text" name="proname'+dels[0]+'" class="form-control" id="proname" placeholder="小区名称">\
                        </div>\
                    </div>\
                    <br/><br/><br>\
                    <div class="col-md-5">\
                        <div class="form-group">\
                            <label for="zongjia">总价（万元）</label>\
                            <input type="text" name="zongjia'+dels[0]+'" class="form-control" id="zongjia" placeholder="标的物总价">\
                            <select class="form-control" id="point" name="point'+dels[0]+'">\
                            <option>保留二位</option>\
                            <option>保留一位</option>\
                            <option>不保留</option>\
                            </select>\
                        </div>\
                    </div>\
                    <input type="button" class="form-control del" id="'+dels[0]+'" value="移除该标的物" />\
                <br/><br/><br>\
                </div>';
                    $("#biaodiwu").append(inputbdw);
                    bdwv.push(dels[0]);
                    dels.shift();
                    fieldCount++;

                }

            }
            else
            {
                alert("超出最大标的物数量");
            }
            $('#bdwct').val(bdwv.toString())
            alert($("#bdwct").val()+'总共多少个标的物');
        });
        $(document).on("click",".del",function(){
            bdwnow =$(this).attr('id');
            dels.push(bdwnow);
            bdwv.remove(bdwnow);
            fieldCount = fieldCount - 1;
            $(this).parent('div').remove();
            $("#bdwct").val(bdwv.toString());
            alert(bdwnow+'测试删除的是第几个标的物');
            alert($("#bdwct").val()+'总过多少个标的物');

        });

    });
    Array.prototype.indexOf = function(val) {
        for (var i = 0; i < this.length; i++) {
            if (this[i] == val) return i;
        }
        return -1;
    };
    Array.prototype.remove = function(val) {
        var index = this.indexOf(val);
        if (index > -1) {
            this.splice(index, 1);
        }
    };

    $(document).ready(function(){
        var err = $("#errorif").val();
        var iii ='<div class="alert alert-danger center-jsb">\
            <a href="#" class="close" data-dismiss="alert">\
            &times;\
        </a>\
        <strong>警告！</strong>'+err+'\
        </div>';
        if(err.length>0){
//            alert(err);
            $("#test2").append(iii)
        }
    })
</script>
<%}%>