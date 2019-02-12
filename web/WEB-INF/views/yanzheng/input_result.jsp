<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.hnkypg.pojo.User" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>河南开源技术部</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <link href="newtemple/css/bootstrap.min.css" rel="stylesheet">
    <link href="newtemple/css/bootstrap-responsive.min.css" rel="stylesheet">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600"
          rel="stylesheet">
    <link href="newtemple/css/font-awesome.css" rel="stylesheet">
    <link href="newtemple/css/style.css" rel="stylesheet">
    <link href="newtemple/css/pages/dashboard.css" rel="stylesheet">
    <link href="dashboard/css/bootstrap-table.min.css" rel="stylesheet">
</head>

<body>
<%User loginuser = (User) request.getSession().getAttribute("user"); %>
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container"> <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"><span
                class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span> </a><a class="brand" href="#">报告防伪验证 </a>
            <div class="nav-collapse">
                <ul class="nav pull-right">
                    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
                            class="icon-user"></i> <%=loginuser.getUsername()%>----<%=loginuser.getBumen()%><b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="<%=basePath%>userinfo.do">密码修改</a></li>
                            <li><a href="<%=basePath%>toLogin.do">用户注销</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
        <!-- /container -->
    </div>
    <!-- /navbar-inner -->
</div>
<!-- /navbar -->
<div class="subnavbar">
    <div class="subnavbar-inner">
        <div class="container">
            <ul class="mainnav">
                <li><a href="<%=basePath%>ewmlist.do"><i class="icon-dashboard"></i><span>主页</span></a></li>
                <li><a href="<%=basePath%>ewminput.do"><i class="icon-list-alt"></i><span>报告信息录入</span></a></li>
                <%--<li><a href="guidely.html"><i class="icon-facetime-video"></i><span>报告信息修改</span></a></li>--%>
                <%--<li><a href="charts.html"><i class="icon-bar-chart"></i><span>报告状态修改</span></a></li>--%>
            </ul>
        </div>
        <!-- /container -->
    </div>
    <!-- /subnavbar-inner -->
</div>
<!-- /subnavbar -->
<div class="main">
    <div class="main-inner">
        <div class="container">
            <div class="row">
                <div class="span12">
                    <div class="widget widget-nopad">
                        <div class="widget-header"> <i class="icon-list-alt"></i>
                            <h3>报告下载页面</h3>
                        </div>
                        <!-- /widget-header -->
                        <div class="widget-content">
                            <div class="widget big-stats-container">
                                <div class="widget-content">
                                    <h6 class="bigstats">报告下载</h6>
                                    <div class="span12">
                                        <%--<h1>下载下来看看</h1>--%>
                                        <br><br>
                                        <h2>点击下载报告</h2><br>
                                            <a href="/jsb/testHttpMessageDown.do?filename=${downloadurl}"><h3>${downloadurl}</h3></a>
                                            <%--<a href="/jsb/testHttpMessageDown.do?filename=${downloadpdf}"><h3>${downloadpdf}</h3></a>--%>
                                        <br>

                                    </div>



                                </div>

                            </div>
                            <!-- /widget-content -->

                        </div>
                    </div>
                </div>

            </div>

        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /main-inner -->
</div>

<!-- Placed at the end of the document so the pages load faster -->
<%--<script src="newtemple/js/jquery-1.7.2.min.js"></script>--%>
<script src="dashboard/js/jquery-3.2.0.min.js"></script>
<script src="newtemple/js/excanvas.min.js"></script>
<script src="newtemple/js/chart.min.js" type="text/javascript"></script>
<script src="newtemple/js/bootstrap.js"></script>
<script language="javascript" type="text/javascript" src="newtemple/js/full-calendar/fullcalendar.min.js"></script>
<script src="newtemple/js/base.js"></script>
<script src="dashboard/js/bootstrap-table.min.js"></script>
<script src="dashboard/js/bootstrap-table-zh-CN.js"></script>
<script src="dashboard/js/jquery.base64.js"></script>
<script src="dashboard/js/bootstrap-table-export.js"></script>
<script src="dashboard/js/tableExport.js"></script>
</body>
</html>


<body>

</body>