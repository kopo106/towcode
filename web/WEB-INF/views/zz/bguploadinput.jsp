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
<%@ include file="header.jsp" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li><a href="<%=basePath%>index.do">主页 </a></li>
            </ul>

        </div>
        <div class="col-md-9 col-md-offset-2 main">
            <br/>
            <h1 class="page-header">报告上传自动录入</h1>
            <br/>
            <input type="hidden" id="errorif" value="${error}" />
            <div class="row">
                <div class="col-md-6 col-md-offset-3 " id="test2">
                </div>
            </div>
            <form class="form-inline" action="<%=basePath%>bguploadtrans.do" enctype="multipart/form-data" method="post">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="uploadFile"><h3>上传报告</h3></label>
                            <input class="form-control" type="file" id="uploadFile" name="uploadFile" />

                        </div>
                        <br>
                        <div>
                            <input type="submit" value="提交">
                        </div>
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

<%}%>