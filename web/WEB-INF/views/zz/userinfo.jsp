<%--<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>--%>
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
    <%--<meta charset="utf-8">--%>
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
                <li class="active" ><a href="<%=basePath%>userinfo.do"><span class="sr-only">(current)</span>用户密码修改 </a></li>
            </ul>

        </div>
        <div class="col-md-10 col-md-offset-2 main">
            <h1 class="page-header">用户密码修改</h1><br>
            <br><br>
            <form class="form-horizontal" action="<%=basePath%>useredit.do" method="post">
                <div class="form-group">
                    <label for="oldps" class="col-md-2 control-label">原密码</label>
                    <div class="col-md-3">
                        <input type="password" class="form-control" id="oldps" name="oldps" placeholder="原先密码">
                    </div>
                </div>
                <div class="form-group">
                    <label for="newps" class="col-md-2 control-label">新密码</label>
                    <div class="col-md-3">
                        <input type="password" class="form-control" id="newps" name="newps" placeholder="输入新密码">
                    </div>
                </div>
                <div class="form-group">
                    <label for="renewps" class="col-md-2 control-label">新密码确认</label>
                    <div class="col-md-3">
                        <input type="password" class="form-control" id="renewps" name="renewps" placeholder="重新输入新密码确认">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-offset-2 col-md-3">
                        <input type="hidden" name="loginname" value="<%=loginuser.getLoginname()%>">
                        <button type="submit" class="btn btn-default">提交保存</button>
                        <button type="reset" class="btn btn-default">重新填写</button>
                    </div>
                </div>
                <h2>${error}</h2>
            </form>



            <%--<form class="form-inline" action="<%=basePath%>useredit.do" method="post">--%>

                    <%--<div class="form-group">--%>
                        <%--<label for="oldps">原密码</label>--%>
                        <%--<input type="password" name="oldps" class="form-control" id="oldps" placeholder="原密码" >--%>
                    <%--</div>--%>

                <%--<br>--%>

                    <%--<div class="form-group">--%>
                        <%--<label for="newps">新密码</label>--%>
                        <%--<input type="password" name="newps" class="form-control" id="newps" placeholder="新密码" >--%>
                    <%--</div>--%>

                <%--<br>--%>

                    <%--<div class="form-group">--%>
                        <%--<label for="renewps">确认新密码</label>--%>
                        <%--<input type="password" name="renewps" class="form-control" id="renewps" placeholder="确认新密码">--%>
                    <%--</div>--%>

                <%--<br>--%>

                    <%--<input type="hidden" name="loginname" value="<%=users.getLoginname()%>">--%>
                    <%--<p class="text-center">--%>
                        <%--<input class="btn btn-default" type="submit" value="提交保存">--%>
                        <%--<input class="btn btn-default" type="reset" value="重新填写">--%>
                    <%--</p>--%>


                <%--<h2>${error}</h2>--%>
            <%--</form>--%>
        </div>


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
</body>
</html>
<script>
    $("#biaoti").css({color:"#F4FBFF",
        fontSize:30,fontType:"楷体"});
</script>


<%}%>