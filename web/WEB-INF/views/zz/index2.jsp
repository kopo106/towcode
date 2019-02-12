<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <!--<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">-->
            <!--<span class="sr-only">Toggle navigation</span>-->
            <!--<span class="icon-bar"></span>-->
            <!--<span class="icon-bar"></span>-->
            <!--<span class="icon-bar"></span>-->
            <!--</button>-->
            <p id="biaoti">河南开源技术部</p>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="<%=basePath%>index.do">报告查询 <span class="sr-only">(current)</span></a></li>
                <li><a href="<%=basePath%>input.do">报告录入</a></li>
                <li><a href="#">Analytics</a></li>
                <li><a href="#">Export</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="">Nav item</a></li>
                <li><a href="">Nav item again</a></li>
                <li><a href="">One more nav</a></li>
                <li><a href="">Another nav item</a></li>
                <li><a href="">More navigation</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">报告查询</h1><br>




                <form class="form-inline">
                    <div class="row">
                        <div class="col-lg-3">
                            <div class="form-group">
                                <label for="select">选择查询字段</label>
                                <select  id="select" class="form-control">
                                    <option value="all">-------------------------</option>
                                    <option value="bgnum">报告编号</option>
                                    <option value="zuoluo">产权坐落</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-lg-5">
                            <div class="form-group">
                                <label for="startdate">
                                    选取时间
                                </label>
                                <input type="date" class="form-control" id="startdate"/>--<input type="date" class="form-control" id="enddate" />
                            </div>

                        </div>

                        <div class="col-lg-3">
                            <div class="form-group">
                                <label for="test1">
                                    搜索内容
                                </label>
                                <input type="text" class="form-control"  id="test1"/>&nbsp &nbsp &nbsp &nbsp &nbsp
                                <button type="button" class="btn btn-primary" id="testselect" >查询</button>
                            </div>

                        </div>

                        <%--<div class="col-md-3">--%>
                            <%--<div class="form-group">--%>
                                <%--<label for="enddate">--%>
                                    <%--截止时间--%>
                                <%--</label>--%>
                                <%----%>
                            <%--</div>--%>

                        <%--</div>--%>
                    </div>
                    <%--<br><br><br>--%>
                    <%--<div class="col-lg-3">--%>


                    <%--</div>--%>
                </form><br><br>
                <table id="tradeList"></table>

        </div>

            <h2 class="sub-header">Section title</h2>

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
    $(document).ready(function() {
        // 初始化表格
        initTable();
    });


    function initTable(){
        $('#tradeList').bootstrapTable({
            url: "<%=path%>/indexajax.do",  //请求后台的URL（*）
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
            pageSize: 20,   //每页的记录行数（*）
            pageList: [10, 25, 50, 100], //可供选择的每页的行数（*）
            strictSearch: true,
            clickToSelect: true,  //是否启用点击选中行
            height: 460,   //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "id",   //每一行的唯一标识，一般为主键列
            cardView: false,   //是否显示详细视图
            detailView: true,   //是否显示父子表
            columns: [{
                checkbox: true,
                title: '选择主键',
                field:'id'
            },{
                field: 'bumen',
                title: '所属部门'
            },{
                field: 'baogaotype',
                title: '报告类型'
            }, {
                field: 'bgnum',
                title: '报告编码'
            }, {
                field: 'laiyuan',
                title: '报告来源'
            }, {
                field: 'zuoluo',
                title: '房屋产权坐落'
            }, {
                field: 'chanquanren',
                title: '产权人'
            }, {
                field: 'shidian',
                title: '价值时点'
            }, {
                field: 'chujudate',
                title: '出具日期'
            }, {
                field: 'zhuanxie.username',
                title: '撰写人'
            }, {
                field: 'shenhe.username',
                title: '审核人'
            }, {
                field: 'kancha.username',
                title: '勘察人员'
            }, {
                field: 'jiazhigoutong.username',
                title: '价值沟通'
            }],

            onExpandRow: function (index, row, $detail) {
                InitSubTable(index, row, $detail);
            }
        });

        $('#testselect').click(function () {
            $('#tradeList').bootstrapTable('refresh', {url: "<%=path%>/indexajax.do"});
        });
    };


    //得到查询的参数
    queryParams = function (params) {
        var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit, //页面大小
            offset: params.offset, //页码
            text: $("#test1").val(),
            startdate: $("#startdate").val(),
            enddate: $("#enddate").val(),
            select: $("#select").val(),
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

    InitSubTable = function (index, row, $detail) {
        var parentid = row.bgnum;
        var cur_table = $detail.html('<table></table>').find('table');
        $(cur_table).bootstrapTable({
            url: "<%=path%>/indexchildajax.do",
            method: 'get',
            cardView: false,
            queryParams: { bgnum: parentid },
            ajaxOptions: { bgnum: parentid },
            clickToSelect: true,
//            detailView: true,//父子表
//            uniqueId: "MENU_ID",
//            pageSize: 10,
//            pageList: [10, 25],
            columns: [{
                checkbox: true
            }, {
                field: 'chanquanren',
                title: '产权人'
            }, {
                field: 'mianji',
                title: '建筑面积'
            }, {
                field: 'danjia',
                title: '单价（元/㎡）'
            }, {
                field: 'zongjia',
                title: '总价（万）'
            }, {
                field: 'niandai',
                title: '建筑年代'
            },{
                field: 'suo',
                title: '所在楼层'
            },{
                field: 'zong',
                title: '总楼层'
            }, {
                field: 'yongtu',
                title: '规划用途'
            },{
                field: 'gujiashi',
                title: '签字估价师'
            },{
                field: 'proname',
                title: '小区名称'
            },{
                field: 'tel',
                title: '联系电话'
            },{
                field: 'memo',
                title: '备注'
            }]
        })
    };
</script>

<%}%>