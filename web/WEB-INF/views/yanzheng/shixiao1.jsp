<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>河南开源技术部</title>

    <!-- Bootstrap core CSS -->
    <link href="dashboard/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <%--<link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">--%>

    <!-- Custom styles for this template -->
    <link href="dashboard/css/blog.css" rel="stylesheet">


</head>

<body>



<div class="container">
    <img src="dashboard/test.png" class="img-responsive" alt="Responsive image">
    <hr>
    <%--<div class="jumbotron">--%>
    <%--<h2>评估报告防伪验证</h2>--%>
    <%----%>
    <%--</div>--%>
    <div class="row">
        <div class="col-xs-12 blog-main">

            <div>
                <br>
                <h3><p class="text-center">报告已收回，二维码无效！</p></h3>
            </div>
            <br><br><br><br><br><br><br><br>

        </div>
    </div>
    <%--<div class="row">--%>
    <%--<div class="col-sx-12 blog-main">--%>
    <%--&lt;%&ndash;<div class="page-header">&ndash;%&gt;--%>

    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--<div class="table-responsive">--%>
    <%--<table class="table">--%>
    <%--<tr >--%>
    <%--<td class="col-sx-12"><h4><p>报告编号：${bgyz.bgnum}</p></h4></td>--%>
    <%--&lt;%&ndash;<td class="col-sx-6 "><h4><p class="text-center"></p></h4></td>&ndash;%&gt;--%>
    <%--</tr>--%>

    <%--<tr >--%>
    <%--<td class="col-sx-12"><h4><p >报告名称：${bgyz.bgname}</p></h4></td>--%>
    <%--&lt;%&ndash;<td class="col-sx-6 "><h4><p>报告名称：</p></h4></td>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<td class="col-sx-6 "><h4><p class="text-center">${bgyz.bgname}</p></h4></td>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>

    <%--<tr >--%>
    <%--<td class="col-sx-12"><h4><p>估价师：${bgyz.gujiashi}</p></h4></td>--%>
    <%--&lt;%&ndash;<td class="col-sx-6 "><h4><p>估价师：</p></h4></td>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<td class="col-sx-6 "><h4><p class="text-center">${bgyz.gujiashi}</p></h4></td>&ndash;%&gt;--%>
    <%--</tr>--%>

    <%--<tr >--%>
    <%--<td class="col-sx-12"><h4><p>评估机构：${bgyz.pinggujigou}</p></h4></td>--%>
    <%--&lt;%&ndash;<td class="col-sx-6 "><h4><p>评估机构：</p></h4></td>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<td class="col-sx-6 "><h4><p class="text-left">${bgyz.pinggujigou}</p></h4></td>&ndash;%&gt;--%>
    <%--</tr>--%>

    <%--<tr >--%>
    <%--<td class="col-sx-12"><h4><p>建筑面积：${bgyz.jianzhumianji}</p></h4></td>--%>
    <%--&lt;%&ndash;<td class="col-sx-6 "><h4><p>建筑面积：</p></h4></td>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<td class="col-sx-6 "><h4><p class="text-left">${bgyz.jianzhumianji}</p></h4></td>&ndash;%&gt;--%>
    <%--</tr>--%>

    <%--<tr >--%>
    <%--<td class="col-sx-12"><h4><p >抵押总价：${bgyz.zongjia}</p></h4></td>--%>
    <%--&lt;%&ndash;<td class="col-sx-6 "><h4><p>抵押总价：</p></h4></td>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<td class="col-sx-6 "><h4><p class="text-left">${bgyz.zongjia}</p></h4></td>&ndash;%&gt;--%>
    <%--</tr>--%>

    <%--<tr >--%>
    <%--<td class="col-sx-12"><h4><p>出具日期：${bgyz.chujudate}</p></h4></td>--%>
    <%--&lt;%&ndash;<td class="col-sx-6 "><h4><p>出具日期：</p></h4></td>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<td class="col-sx-6 "><h4><p class="text-left">${bgyz.chujudate}</p></h4></td>&ndash;%&gt;--%>
    <%--</tr>--%>

    <%--&lt;%&ndash;<tr >&ndash;%&gt;--%>
    <%--&lt;%&ndash;<td class="col-sm-2 col-sm-offset-2"><h4><p class="text-right">报告有效性：</p></h4></td>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<td class="col-sm-2  "><h4><p class="text-left"></p></h4></td>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>

    <%--<!--<tr>-->--%>
    <%--<!--<td class="col-sm-4">报告编号：</td>-->--%>
    <%--<!--<td class="col-sm-8">看看效果怎么样啊</td>-->--%>
    <%--<!--</tr>-->--%>
    <%--</table>--%>
    <%--</div>--%>


    <%--&lt;%&ndash;<form class="form-horizontal">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<div class="form-group">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<label for="inputEmail3" class="col-sm-4 control-label">报告编码</label>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<div class="col-sm-8">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<input type="text" class="form-control" id="inputEmail3" placeholder="Email">&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<div class="form-group">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<label for="inputPassword3" class="col-sm-4 control-label">报告名称</label>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<div class="col-sm-8">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<input type="text" class="form-control" id="inputPassword3" placeholder="Password">&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>

    <%--&lt;%&ndash;</form>&ndash;%&gt;--%>



    <%--</div><!-- /.blog-main -->--%>



</div><!-- /.row -->

</div><!-- /.container -->

<footer class="blog-footer">
    <p>报告验证系统 @河南开源技术部</p>

</footer>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="dashboard/js/jquery-3.2.0.min.js"></script>
<%--<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>--%>
<script src="dashboard/js/bootstrap.min.js"></script>
</body>
</html>