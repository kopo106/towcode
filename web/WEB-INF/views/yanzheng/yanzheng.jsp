<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.hnkypg.pojo.User" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->



<!DOCTYPE html>
<html lang="zh-CN">

<!-- Head -->
<head>

    <title>河南开源报告验证</title>

    <!-- Meta-Tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <%--<meta name="keywords" content="Opulent a Responsive Web Template, Bootstrap Web Templates, Flat Web Templates, Android Compatible Web Template, Smartphone Compatible Web Template, Free Webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design">--%>
    <%--<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>--%>
    <!-- //Meta-Tags -->

    <!-- Custom-Stylesheet-Links -->
    <!-- Bootstrap-CSS --> 	<link rel="stylesheet" href="yidongyem/css/bootstrap.min.css"		type="text/css" media="all">
    <!-- Index-Page-CSS --> <link rel="stylesheet" href="yidongyem/css/style.css" 			type="text/css" media="all">
    <%--<!-- FontAwesome-CSS --><link rel="stylesheet" href="yidongyem/css/font-awesome.min.css"	type="text/css" media="all">--%>
    <%--<!-- PopUp-Box-CSS -->	<link rel="stylesheet" href="yidongyem/css/chocolat.css"			type="text/css" media="all">--%>
    <%--<!-- OwlCarousel-CSS --><link rel="stylesheet" href="yidongyem/css/owl.carousel.css"		type="text/css" media="all">--%>
    <!-- //Custom-Stylesheet-Links -->

    <!-- Fonts -->
    <link rel="stylesheet" href="//fonts.googleapis.com/css?family=Montserrat:400,700" 				type="text/css" media="all">
    <link rel="stylesheet" href="//fonts.googleapis.com/css?family=Roboto:100,300,400,500,700,900"	type="text/css" media="all">
    <!-- //Fonts -->

</head>
<!-- //Head -->



<!-- Body -->
<body>

<!-- About -->
<div class="container" >
    <div class="agileabout-grids">
        <img src="yidongyem/images/test11.png">
        <div class="col-md-4 agileabout-grid agileabout-grid-3">
            <br>
            <h3>报告信息</h3>


            <ul>
            <li><div class="li1">报告编号</div><div class="li2">:</div><div class="li3">${bgyz.bgnum}</div><div class="clearfix"></div></li>
            <li><div class="li1">产权坐落</div><div class="li2">:</div><div class="li3">${bgyz.bgname}</div><div class="clearfix"></div></li>
            <li><div class="li1">估价师</div><div class="li2">:</div><div class="li3">${bgyz.gujiashi}</div><div class="clearfix"></div></li>
            <li><div class="li1">评估机构</div><div class="li2">:</div><div class="li3">${bgyz.pinggujigou}</div><div class="clearfix"></div></li>
            <li><div class="li1">建筑面积</div><div class="li2">:</div><div class="li3">${bgyz.jianzhumianji}（m²）</div><div class="clearfix"></div></li>
            <li><div class="li1">评估总价</div><div class="li2">:</div><div class="li3">${bgyz.zongjia}（万元）</div><div class="clearfix"></div></li>
            <li><div class="li1">出具日期</div><div class="li2">:</div><div class="li3">${bgyz.chujudate}</div><div class="clearfix"></div></li>
            <li><div class="li1">备注</div><div class="li2">:</div><div class="li3">${bgyz.memo}</div>
            </ul>
        </div>
    </div>

</div>
<!-- //About -->




<%--<!-- About -->--%>
<%--<div class="agileabout" id="agileabout">--%>
    <%--<div class="container-fluid">--%>

        <%--<!--<h2>ABOUT ME</h2>-->--%>

        <%--<div class="agileabout-grids">--%>

            <%--<img src="yidongyem/images/test8.png" alt="Opulent">--%>
            <%--<div class="col-md-4 agileabout-grid agileabout-grid-3">--%>
                <%--<br>--%>
                <%--<h3>报告信息</h3>--%>
                <%--<ul>--%>
                    <%--<li><div class="li1">报告编号</div><div class="li2">:</div><div class="li3">${bgyz.bgnum}</div><div class="clearfix"></div></li>--%>
                    <%--<li><div class="li1">产权坐落</div><div class="li2">:</div><div class="li3">${bgyz.bgname}</div><div class="clearfix"></div></li>--%>
                    <%--<li><div class="li1">估价师</div><div class="li2">:</div><div class="li3">${bgyz.gujiashi}</div><div class="clearfix"></div></li>--%>
                    <%--<li><div class="li1">评估机构</div><div class="li2">:</div><div class="li3">${bgyz.pinggujigou}</div><div class="clearfix"></div></li>--%>
                    <%--<li><div class="li1">建筑面积</div><div class="li2">:</div><div class="li3">${bgyz.jianzhumianji}（m²）</div><div class="clearfix"></div></li>--%>
                    <%--<li><div class="li1">评估总价</div><div class="li2">:</div><div class="li3">${bgyz.zongjia}（万元）</div><div class="clearfix"></div></li>--%>
                    <%--<li><div class="li1">出具日期</div><div class="li2">:</div><div class="li3">${bgyz.chujudate}</div><div class="clearfix"></div></li>--%>
                    <%--<li><div class="li1">备注</div><div class="li2">:</div><div class="li3">--</div>--%>
                <%--</ul>--%>
            <%--</div>--%>
        <%--</div>--%>

    <%--</div>--%>
<%--</div>--%>
<!-- //About -->






<!-- Footer -->
<div class="footer">
<%--<div>--%>
<%--<div>--%>
        <div class="copyright">
            &copy; 河南开源房地产估价有限公司
        </div>

</div>
<!-- //Footer -->



<!-- Custom-JavaScript-File-Links -->

<!-- Default-JavaScript --> <script type="text/javascript" src="yidongyem/js/jquery-2.1.4.min.js"></script>
<%--<script type="text/javascript" src="dashboard/js/jquery-3.2.0.min.js"></script>--%>
<!-- Bootstrap-JavaScript --> <script type="text/javascript" src="yidongyem/js/bootstrap.min.js"></script>
<%--<!-- Bootstrap-JavaScript --> <script type="text/javascript" src="dashboard/js/bootstrap.min.js"></script>--%>

<!-- Horizontal-Tabs-JavaScript -->
<%--<script src="yidongyem/js/easyResponsiveTabs.js" type="text/javascript"></script>--%>
<%--<script type="text/javascript">--%>
    <%--$(document).ready(function () {--%>
        <%--$('#horizontalTab').easyResponsiveTabs({--%>
            <%--type: 'default',--%>
            <%--width: 'auto',--%>
            <%--fit: true,--%>
        <%--});--%>
    <%--});--%>
<%--</script>--%>
<%--<!-- Horizontal-Tabs-JavaScript -->--%>

<%--<!-- Stats-Number-Scroller-Animation-JavaScript -->--%>
<%--<script src="js/waypoints.min.js"></script>--%>
<%--<script src="js/counterup.min.js"></script>--%>
<%--<script>--%>
    <%--jQuery(document).ready(function( $ ) {--%>
        <%--$('.counter').counterUp({--%>
            <%--delay: 10,--%>
            <%--time: 1000,--%>
        <%--});--%>
    <%--});--%>
<%--</script>--%>
<%--<!-- //Stats-Number-Scroller-Animation-JavaScript -->--%>

<%--<!-- Progressive-Bars-JavaScript -->--%>
<%--<script src="yidongyem/js/bars.js"></script>--%>
<%--<!-- //Progressive-Bars-JavaScript -->--%>

<%--<!-- Show-More-JavaScript -->--%>
<%--<script>--%>
    <%--$(document).ready(function () {--%>
        <%--size_li = $("#myList li").size();--%>
        <%--x=1;--%>
        <%--$('#myList li:lt('+x+')').show();--%>
        <%--$('#loadMore').click(function () {--%>
            <%--x= (x+1 <= size_li) ? x+1 : size_li;--%>
            <%--$('#myList li:lt('+x+')').show();--%>
        <%--});--%>
        <%--$('#showLess').click(function () {--%>
            <%--x=(x-1<0) ? 1 : x-1;--%>
            <%--$('#myList li').not(':lt('+x+')').hide();--%>
        <%--});--%>
    <%--});--%>
<%--</script>--%>
<%--<!-- Show-More-JavaScript -->--%>

<%--<!-- Tabs-JavaScript -->--%>
<%--<script src="yidongyem/js/jquery.filterizr.js"></script>--%>
<%--<script src="yidongyem/js/controls.js"></script>--%>
<%--<script type="text/javascript">--%>
    <%--$(function() {--%>
        <%--$('.filtr-container').filterizr();--%>
    <%--});--%>
<%--</script>--%>
<%--<!-- //Tabs-JavaScript -->--%>

<%--<!-- PopUp-Box-JavaScript -->--%>
<%--<script src="yidongyem/js/jquery.chocolat.js"></script>--%>
<%--<script type="text/javascript">--%>
    <%--$(function() {--%>
        <%--$('.filtr-item a').Chocolat();--%>
    <%--});--%>
<%--</script>--%>
<%--<!-- //PopUp-Box-JavaScript -->--%>

<%--<!-- Owl-Carousel-JavaScript -->--%>
<%--<script src="yidongyem/js/owl.carousel.js"></script>--%>
<%--<script>--%>
    <%--$(document).ready(function() {--%>
        <%--$("#owl-demo").owlCarousel ({--%>
            <%--items : 8,--%>
            <%--lazyLoad : true,--%>
            <%--autoPlay : true,--%>
            <%--speed: 900,--%>
            <%--pagination : false,--%>
        <%--});--%>
    <%--});--%>
<%--</script>--%>
<%--<!-- //Owl-Carousel-JavaScript -->--%>

<%--<!-- Slide-To-Top JavaScript -->--%>
<%--<script type="text/javascript">--%>
    <%--$(document).ready(function() {--%>
        <%--var defaults = {--%>
            <%--containerID: 'toTop',--%>
            <%--containerHoverID: 'toTopHover',--%>
            <%--scrollSpeed: 100,--%>
            <%--easingType: 'linear',--%>
        <%--};--%>
        <%--$().UItoTop({ easingType: 'easeOutQuart' });--%>
    <%--});--%>
<%--</script>--%>
<%--<a href="#" id="toTop" class="stuoyal3w stieliga" style="display: block;"> <span id="toTopHover" style="opacity: 0;"> </span></a>--%>
<%--<!-- //Slide-To-Top JavaScript -->--%>

<%--<!-- Smooth-Scrolling-JavaScript -->--%>
<%--<script type="text/javascript" src="yidongyem/js/move-top.js"></script>--%>
<%--<script type="text/javascript" src="yidongyem/js/easing.js"></script>--%>
<%--<script type="text/javascript">--%>
    <%--jQuery(document).ready(function($) {--%>
        <%--$(".scroll").click(function(event){--%>
            <%--event.preventDefault();--%>
            <%--$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);--%>
        <%--});--%>
    <%--});--%>
<%--</script>--%>
<!-- //Smooth-Scrolling-JavaScript -->

<!-- //Custom-JavaScript-File-Links -->



</body>
<!-- //Body -->



</html>

