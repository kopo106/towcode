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
<%@ include file="../zz/header.jsp" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li><a href="<%=basePath%>fgsindex.do">主页</a></li>
                <li class="active"><a href="<%=basePath%>fgsselect.do"><span class="sr-only">(current)</span>报告查询 </a></li>
            </ul>

        </div>
        <div class="col-md-10 col-md-offset-2 main">
            <h1 class="page-header">报告查询</h1><br>
            <form class="form-inline">
                <div class="row">
                    <div class="col-md-10">
                        <div class="form-group">

                            <select  id="select" class="form-control">
                                <option value="all">-------------------------</option>
                                <option value="bgnum">报告编号</option>
                                <option value="zuoluo">产权坐落</option>
                                <option value="proname">小区名称</option>
                                <option value="chanquanren">产权人</option>
                            </select>

                            <label for = test1>查询内容</label>
                            <input type="text" class="form-control"  id="test1"/>
                            <label for = startdate>选择日期</label>
                            <input type="date" class="form-control"  id="startdate"/>
                            <input type="date" class="form-control"  id="enddate"/>
                            <button type="button" class="btn btn-primary" id="testselect" >查询</button>
                            <input type="hidden" id="login_user_bumen" value="<%=loginuser.getBumen()%>" />

                        </div>
                    </div>

                </div>

            </form><br><br>
            <table id="tradeList"></table>

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
    $(document).ready(function() {
        // 初始化表格
        initTable();
    });


    function initTable(){
        $('#tradeList').bootstrapTable({
            url: "<%=path%>/fgslistajax.do",  //请求后台的URL（*）
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
            detailView: true,   //是否显示父子表
            columns: [
//                {         checkbox: true,                title: '选择主键'},
                {
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
                },
//                {
//                field: 'zuoluo',
//                title: '房屋产权坐落'
//            },
//                {
//                field: 'chanquanren',
//                title: '产权人'
//            },
                {
                field: 'shidian',
                title: '价值时点'
            },
                {
                    field: 'chujudate',
                    title: '出具日期'
                },
//                {
//                    field: 'zhuanxie.username',
//                    title: '撰写人'
//                }, {
//                    field: 'jszhuanxie.username',
//                    title: '技术'
//                }, {
//                    field: 'shenhe.username',
//                    title: '审核人'
//                },
//                {
//                    field: 'kancha.username',
//                    title: '照片勘察'
//                },
//                {
//                    field: 'shidikc.username',
//                    title: '实地勘察'
//                },
                {
                    field: 'gujiashi',
                    title: '估价师'
                },
                {
                    field: 'fuzeren.username',
                    title: '负责人'
                }, {
                    field: 'memo',
                    title: '备注'
                }
                ,  {
                    field: 'id',
                    title: 'ID',
                    visible: false
                }
//            , {
//                formatter: actionFormatter,
//                events: actionEvents,
//                title: '编辑处理',
//                field: 'action',
//            }
            ],

            onExpandRow: function (index, row, $detail) {
                InitSubTable(index, row, $detail);
            }
        });

        $('#testselect').click(function () {
            $('#tradeList').bootstrapTable('refresh', {url: "<%=path%>/fgslistajax.do"});
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
            order: params.sortOrder,
            bumen: $("#login_user_bumen").val()
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
        var parentid = row.id;
        var cur_table = $detail.html('<table></table>').find('table');
        $(cur_table).bootstrapTable({
            url: "<%=path%>/fgslistchildajax.do",
            method: 'get',
            cardView: false,
            queryParams: { bglid: parentid },
            ajaxOptions: { bglid: parentid },
            clickToSelect: true,
            sidePagination: "server",
            pageNumber:1,
//            detailView: true,//父子表
//            uniqueId: "MENU_ID",
            pageSize: 10,
            pageList: [10, 25],
            columns: [
//                {checkbox: true},
                {
                    field: 'chanquanren',
                    title: '产权人'
                }, {
                    field: 'zuoluo',
                    title: '产权坐落'
                },{
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
                },
//                {
//                field: 'gujiashi',
//                title: '签字估价师'
//            },
                {
                    field: 'proname',
                    title: '小区名称'
                },{
                    field: 'shidian',
                    title: '价值时点'
                }
//            , {
//                field: 'tel',
//                title: '联系电话'
//            },{
//                field: 'memo',
//                title: '备注'
//            }
            ]
        })
    };
    //ACTION列的内容设置（跳转页面带本行ID的参数）
    function actionFormatter(value, row, index) {
        return [

            '<a class="edit ml10" href="javascript:void(0)" title="Edit">',
            ' 编辑 |',
            '</a>',
            '<a class="trave" href="javascript:void(0)" title="trave">',
            ' 预评转正评 ',
            '</a>'
//            '<a class="remove ml10" href="javascript:void(0)" title="Remove">',
//            ' 删除',
//            '</a>'

        ].join('');
    }
    //ACTION的事件监听和处理
    window.actionEvents = {
        'click .trave': function (e, value, row, index) {
//            alert('You click like icon, row: ' + JSON.stringify(row));
            location.href = "trave.do?bglid="+row.id;
            console.log(value, row, index);
        },
        'click .edit': function (e, value, row, index) {
//            alert('You click edit icon, row: ' + JSON.stringify(row.description));
            location.href = "edit.do?bglid="+row.id;
            console.log(value, row, index);
        },
        'click .remove': function (e, value, row, index) {
//            alert('You click remove icon, row: ' + JSON.stringify(row));
            location.href = "delete.do?bglid="+row.id;
            console.log(value, row, index);
        }
    };
</script>

<%}%>