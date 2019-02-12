<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<iframe src="<c:url value="/pdf/web/viewer.html" />?file=/towcode/displayPDF.do"--%>
        <%--width="100%" height="800"></iframe>--%>



<div align="center"><font size="4" color="ff0000">iWebPDF在线管理中间件（阅读版）示例程序</font></div>
<br>
<table width="100%"><tr><td height="22"><script src="iWebPDF/iWebPDF.js"></script></td></tr></table>
<hr size=1>
</body>
</html>
