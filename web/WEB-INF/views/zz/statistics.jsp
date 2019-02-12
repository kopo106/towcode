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
    <script src="dashboard/js/echarts.common.min.js"></script>
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
                <li><a href="<%=basePath%>index.do">主页</a></li>
                <li><a href="<%=basePath%>statisticsa.do">报告录入</a></li>
            </ul>

        </div>

        <div class="col-md-10 col-md-offset-2 main">
                                    <br>
                        <div id="maina" style="width: 600px;height:400px;"></div>
                        <br>
                        <div id="tables">
                            <table id="tradeList"></table>
                        </div>
                    </div>
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
<script>
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('maina'));

    function fetchData(cb) {
        // 通过 setTimeout 模拟异步加载
        setTimeout(function () {
            cb({
                categories: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"],
                data: [5, 20, 36, 10, 10, 20]
            });
        }, 1000);
    }

    // 初始 option
    optiona = {
        title: {
            text: '预评撰写统计'
        },
        tooltip: {},
        legend: {
            data:['报告数']
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [{
            name: '撰写',
            type: 'bar',
            data: []
        }]
    };

    fetchData(function (data) {
        myChart.setOption({
            xAxis: {
                data: data.categories
            },
            series: [{
                // 根据名字对应到相应的系列
                name: '撰写',
                data: data.data
            }]
        });
    });
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(optiona);
</script>

<script>
    $(document).ready(function() {
        // 初始化表格
        initTable();
    });


    function initTable(){
        $('#tradeList').bootstrapTable({
            url: "<%=path%>/statisticsajxa.do",  //请求后台的URL（*）
            method: 'get',   //请求方式（*）
//                toolbar: '#toolbar',  //工具按钮用哪个容器
            striped: true,   //是否显示行间隔色
            cache: false,   //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,   //是否显示分页（*）
            sortable: true,   //是否启用排序
//            sortOrder: "asc",   //排序方式
            queryParams: queryParams,//传递参数（*）
            sidePagination: "server",  //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,   //初始化加载第一页，默认第一页
            pageSize: 10,   //每页的记录行数（*）
            pageList: [10, 25, 50, 100], //可供选择的每页的行数（*）
            strictSearch: true,
            clickToSelect: true,  //是否启用点击选中行
//            height: 460,   //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "id",   //每一行的唯一标识，一般为主键列
            cardView: false,   //是否显示详细视图
//            detailView: true,   //是否显示父子表
            columns: [
//                {         checkbox: true,                title: '选择主键'},
//                {
//                    field: 'userid',
//                    title: '员工ID',
//                    visible: false
//                },
                {
                    field: 'user.bumen',
                    title: '部门'
                },{
                    field: 'user.username',
                    title: '员工姓名'
                },{
                    field: 'baogaotype',
                    title: '报告类型'
                },{
                    field: 'zhuanxie',
                    title: '撰写总数',
                    formatter:testlink
                },{
                    field: 'shenhe',
                    title: '审核总数'
                },{
                    field: 'kancha',
                    title: '照片勘察总数'
                },{
                    field: 'jiazhigoutong',
                    title: '价值沟通总数'
                },{
                    field: 'dingjia',
                    title: '定价总数'
                },{
                    field: 'jszhuanxie',
                    title: '技术报告总数'
                },{
                    field: 'shidikc',
                    title: '实地勘察总数'
                },{
                    field: 'fgs',
                    title: '分公司报告审核总数'
                },{
                    field: 'month',
                    title: '统计月份'
                }]
//            onExpandRow: function (index, row, $detail) {
//                InitSubTable(index, row, $detail);
//            }
        });

        <%--$('#testselect').click(function () {--%>
            <%--$('#tradeList').bootstrapTable('refresh', {url: "<%=path%>/statisticsajxa.do"});--%>
        <%--});--%>
    };
    function testlink(value,row,index) {
        var a='撰写';
        var b='错误';
        if(index=3){
            return a ;
        }else{
            return b;
        }

    }

    //得到查询的参数
    queryParams = function (params) {
        var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit, //页面大小
            offset: params.offset, //页码
//            bumen: $("#bumen").val(),
//            year: $("#year").val(),
//            month: $("#month").val(),
//            baogaotype: $("#baogaotype").val(),
            order: params.sortOrder
//            CardNumber: $("#CardNumber").val(),
//            maxrows: params.limit,
//            pageindex:params.pageNumber,
//            portid: $("#portid").val(),
//            CardNumber: $("#CardNumber").val(),
//            tradetype:$('input:radio[name="tradetype"]:checked').val(),
//            success:$('input:radio[name="success"]:checked').val(),
        };
        return temp;
    };


</script>
<%}%>