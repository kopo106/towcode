<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%--<c: if test="${user.userid!=null}">--%>
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


    <!-- Custom styles for this template -->
    <link href="dashboard/css/dashboard.css" rel="stylesheet">


</head>

<body>

<form action="<%=basePath%>uploadfile.do" method="post" enctype="multipart/form-data">
    <h2>预评报告上传</h2>
    文件:<input type="file" name="uploadFile"/><br/><br/>
    <input type="submit" value="上传"/>
</form>
<br><br>
<form action="<%=basePath%>uploadzsfile.do" method="post" enctype="multipart/form-data">
    <h2>正式报告上传</h2>
    文件:<input type="file" name="uploadFile"/><br/><br/>
    <input type="submit" value="上传"/>
</form>
<br><br>
<form action="<%=basePath%>uploadfgsfile.do" method="post" enctype="multipart/form-data">
    <h2>分公司审核上传</h2>
    文件:<input type="file" name="uploadFile"/><br/><br/>
    <input type="submit" value="上传"/>
</form>
<br><br>
<form action="<%=basePath%>uploadypzfile.do" method="post" enctype="multipart/form-data">
    <h2>转正评的预评报告上传</h2>
    文件:<input type="file" name="uploadFile"/><br/><br/>
    <input type="submit" value="上传"/>
</form>
<br><br>
<form action="<%=basePath%>uploadzpzfile.do" method="post" enctype="multipart/form-data">
    <h2>转正评的正评报告上传</h2>
    文件:<input type="file" name="uploadFile"/><br/><br/>
    <input type="submit" value="上传"/>
</form>
</body>
</html>
