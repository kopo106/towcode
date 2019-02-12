<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <script src="js/jquery-3.2.0.js"></script>
    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-table.min.css">
    <script src="js/bootstrap.min.js" type=""></script>
    <script src="js/bootstrap-table.min.js"></script>
    <script src="js/bootstrap-table-zh-CN.min.js"></script>
</head>
<body>
    <div class="container">
        <table data-toggle="table"
               data-url="<%=path%>/table/ajaxTable.do"
               dataType="json"
               data-pagination="true"
               data-side-pagination="server"
               data-page-list="[5, 10, 20, 50, 100, 200]"
               data-search="true">
               <%--data-height="300">--%>
            <thead>
            <tr>

                <th data-field="id" data-align="right" data-sortable="true">ID</th>
                <th data-field="ip" data-align="center" data-sortable="true">IP地址：</th>
                <th data-field="date" data-sortable="true">添加日期</th>
            </tr>
            </thead>
        </table>
    </div>

</body>
</html>
