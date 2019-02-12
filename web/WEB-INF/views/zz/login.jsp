<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>河南开源报告防伪-登录界面</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">

    <link href="newtemple/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="newtemple/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />

    <link href="newtemple/css/font-awesome.css" rel="stylesheet">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600" rel="stylesheet">

    <link href="newtemple/css/style.css" rel="stylesheet" type="text/css">
    <link href="newtemple/css/pages/signin.css" rel="stylesheet" type="text/css">
</head>

<body>

<div class="navbar navbar-fixed-top">

    <div class="navbar-inner">

        <div class="container">

            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>

            <a class="brand" href="">
                河南开源
            </a>

            <!--<div class="nav-collapse">-->
            <!--<ul class="nav pull-right">-->
            <!---->
            <!--<li class="">						-->
            <!--<a href="signup.html" class="">-->
            <!--Don't have an account?-->
            <!--</a>-->
            <!---->
            <!--</li>-->
            <!---->
            <!--<li class="">						-->
            <!--<a href="index.html" class="">-->
            <!--<i class="icon-chevron-left"></i>-->
            <!--Back to Homepage-->
            <!--</a>-->
            <!---->
            <!--</li>-->
            <!--</ul>-->
            <!---->
            <!--</div>&lt;!&ndash;/.nav-collapse &ndash;&gt;	-->

        </div> <!-- /container -->

    </div> <!-- /navbar-inner -->

</div> <!-- /navbar -->



<div class="account-container">

    <div class="content clearfix">

        <form action="<%=basePath%>ewmloginfix.do" method="post">

            <h1>用户登录</h1>

            <div class="login-fields">

                <p>请输入用户名和密码</p>

                <div class="field">
                    <label for="username">用户名</label>
                    <input type="text" id="username" name="loginname" value="" placeholder="用户名" class="login username-field" />
                </div> <!-- /field -->

                <div class="field">
                    <label for="password">密码:</label>
                    <input type="password" id="password" name="password" value="" placeholder="密码" class="login password-field"/>
                </div> <!-- /password -->

            </div> <!-- /login-fields -->

            <div class="login-actions">

				<span class="login-checkbox">
					<input id="Field" name="Field" type="checkbox" class="field login-checkbox" value="First Choice" tabindex="4" />
					<label class="choice" for="Field">Keep me signed in</label>
				</span>

                <button class="button btn btn-success btn-large">登录提交</button>

            </div> <!-- .actions -->



        </form>

    </div> <!-- /content -->

</div> <!-- /account-container -->



<div class="login-extra">

    <a href="#">Reset Password</a>
</div> <!-- /login-extra -->
<h1 >${error}</h1>

<script src="newtemple/js/jquery-1.7.2.min.js"></script>
<script src="newtemple/js/bootstrap.js"></script>

<script src="newtemple/js/signin.js"></script>
</body>
</html>