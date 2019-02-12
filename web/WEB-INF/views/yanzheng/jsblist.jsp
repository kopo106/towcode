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
                <%--<ul class="nav navbar-nav navbar-right">--%>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%=loginuser.getUsername()%>----<%=loginuser.getBumen()%><span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="<%=basePath%>userinfo.do">密码修改</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="<%=basePath%>toLogin.do">用户注销</a></li>
                        </ul>
                    </li>
                    <%--<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i--%>
                            <%--class="icon-user"></i> 用户名 <b class="caret"></b></a>--%>
                        <%--<ul class="dropdown-menu">--%>
                            <%--<li><a href="javascript:">修改密码</a></li>--%>
                            <%--<li><a href="javascript:">注销登出</a></li>--%>
                        <%--</ul>--%>
                    <%--</li>--%>
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
                <li class="active"><a href="<%=basePath%>jsbewmlist.do"><i class="icon-dashboard"></i><span>二维码报告信息查询</span></a></li>
                <%--<li><a href="<%=basePath%>ewminput.do"><i class="icon-list-alt"></i><span>报告信息录入</span></a></li>--%>
                <%--<li><a href="guidely.html"><i class="icon-facetime-video"></i><span>报告信息修改</span></a></li>--%>
                <li><a href="<%=basePath%>index.do"><i class="icon-bar-chart"></i><span>返回登记系统主页</span></a></li>
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
                            <h3>报告信息查询</h3>
                        </div>
                        <!-- /widget-header -->
                        <div class="widget-content">
                            <div class="widget big-stats-container">
                                <div class="widget-content">
                                    <%--<h6 class="bigstats">评估报告查询</h6>--%>
                                    <div class="span12">
                                        <br>
                                        <form class="form-inline">
                                            <div class="row">
                                                <div class="span4">
                                                    <div class="form-group">

                                                        <label for = select>查询选项</label>
                                                        <select  id="select" class="form-control">
                                                            <option value="all">-------------------------</option>
                                                            <option value="bgnum">报告编号</option>
                                                            <option value="bgname">报告名称/产权坐落</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="span8" >
                                                    <div class="form-group">
                                                        <label for = startdate>选择日期</label>
                                                        <input type="date" class="form-control"  id="startdate"/>
                                                        <input type="date" class="form-control"  id="enddate"/>
                                                    </div>
                                                </div>
                                            </div>

                                        </form>
                                    </div>

                                    <br>
                                    <div class="span12">
                                        <form class="form-inline">
                                            <div class="row">
                                                <div class="span10">
                                                    <div class="form-group">
                                                        <label for = test1>查询内容</label>
                                                        <input type="text" class="form-control"  id="test1"/>
                                                        <button type="button" class="btn btn-primary" id="testselect" >信息查询</button>
                                                        <button type="button" class="btn btn-success" id="edit" >信息编辑</button>
                                                        <button type="button" class="btn btn-warning" id="chexiao" >报告撤销</button>
                                                        <button type="button" class="btn btn-info" id="downloadpdf" >下载报告</button>

                                                    </div>
                                                </div>

                                            </div>

                                        </form>
                                    </div>




                                    <div class="span11">
                                        <br>
                                        <table id="tradeList"></table>
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

<script>

    $(document).ready(function() {
        // 初始化表格
        initTable();
    });


    function initTable(){
        $('#tradeList').bootstrapTable({
            url: "<%=path%>/ewmtablelist.do",  //请求后台的URL（*）
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
            detailView: false,   //是否显示父子表
            showExport: false, //是否显示导出
            exportDataType: "all", //basic', 'all', 'selected'.
            columns: [
                {checkbox: true
                },
//
                 {
                    field: 'bgnum',
                    title: '报告编码'
                },
                 {
                    field: 'bgname',
                    title: '报告名称'
                },
                {
                field: 'pinggujigou',
                title: '评估机构'
                },
                {
                field: 'gujiashi',
                title: '估价师'
                },
                {
                field: 'jianzhumianji',
                title: '建筑面积'
                },{
                field: 'zongjia',
                title: '抵押总价'
                },
                {
                    field: 'chujudate',
                    title: '出具日期'
                },
                {
                    field: 'createdate',
                    title: '创建日期'
                },
//                  {
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
//                {
//                    field: 'jiazhigoutong.username',
//                    title: '价值沟通'
//                }, {
//                    field: 'dingjia.username',
//                    title: '定价人'
//                },
                 {
                    field: 'id',
                    title: 'ID',
                    visible: false
                },
                {
                    field:'status',
                    formatter: displaycolor,
                    title: '报告状态',
//
                }
            ],

            onExpandRow: function (index, row, $detail) {
                InitSubTable(index, row, $detail);
            }
        });

        $('#testselect').click(function () {
            $('#tradeList').bootstrapTable('refresh', {url: "<%=path%>/ewmtablelist.do"});
        });

        $('#edit').click(function () {
            var blgid =getIdSelections()
            if(blgid>0){
                location.href = "edit.do?bglid="+blgid;
            }else {
                alert("请选择要编辑的报告")
            }


        });
        $('#chexiao').click(function () {
            var bgyzid =getIdSelections()
            if(bgyzid>0){
//                alert(blgid)
                location.href = "baogaochexiao.do?bgyzid="+bgyzid;
            }else {
                alert("请选择要撤销的报告信息")
            }


        });

        $('#downloadpdf').click(function () {
            var bgyzid =getIdSelections()
            if(bgyzid>0){
//                alert(blgid)
                location.href = "Downloadpdf.do?bgyzid="+bgyzid;
            }else {
                alert("请选择要下载的报告信息")
            }


        });
        function getIdSelections() {

            return $.map( $('#tradeList') .bootstrapTable('getSelections'), function(row) {
//                alert(row.id)
                return row.id

            });
        }
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
        var parentid = row.id;
        var cur_table = $detail.html('<table></table>').find('table');
        $(cur_table).bootstrapTable({
            url: "<%=path%>/indexchildajax.do",
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

    function displaycolor(value,row,index) {
        var a = "";
        if(value == "1") {
            a = '<span style="color:#00ff00">报告有效</span>';
        }else if(value == "2") {
            a= '<span style="color:#FF0000">报告无效</span>';
        }
        return a;
    }
</script>