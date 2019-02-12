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
    <base href="<%=basePath%>">
    <meta charset="utf-8" />
    <title>Dashboard - Bootstrap Admin</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes" />

    <link href="theme/css/bootstrap.min.css" rel="stylesheet" />
    <link href="theme/css/bootstrap-responsive.min.css" rel="stylesheet" />
    <link href="theme/css/bootstrap-table.css" rel="stylesheet" />

    <link href="theme/css/font-awesome.css" rel="stylesheet" />

    <link href="theme/css/adminia.css" rel="stylesheet" />
    <link href="theme/css/adminia-responsive.css" rel="stylesheet" />

    <link href="theme/css/pages/dashboard.css" rel="stylesheet" />


    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>

<body>

<div class="navbar navbar-fixed-top">

    <div class="navbar-inner">

        <div class="container">

            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>

            <a class="brand" href="../">河南开源房地产估价有限公司技术部</a>

            <div class="nav-collapse">

                <ul class="nav pull-right">
                    <li>
                        <a href="#"><span class="badge badge-warning">7</span></a>
                    </li>

                    <li class="divider-vertical"></li>

                    <li class="dropdown">

                        <a data-toggle="dropdown" class="dropdown-toggle " href="#">
                            个人设置 <b class="caret"></b>
                        </a>

                        <ul class="dropdown-menu">
                            <li>
                                <a href="./account.html"><i class="icon-user"></i>账户设置</a>
                            </li>

                            <li>
                                <a href="./change_password.html"><i class="icon-lock"></i>更改密码</a>
                            </li>

                            <li class="divider"></li>

                            <li>
                                <a href="../"><i class="icon-off"></i> 退出登录</a>
                            </li>
                        </ul>
                    </li>
                </ul>

            </div> <!-- /nav-collapse -->

        </div> <!-- /container -->

    </div> <!-- /navbar-inner -->

</div> <!-- /navbar -->


<!--<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >河南开源房地产估价有限公司技术部</a></div>-->

<div id="content">

    <div class="container">

        <div class="row">

            <div class="span3">

                <div class="account-container">

                    <div class="account-avatar">
                        <img src="theme/img/headshot.png" alt="" class="thumbnail" />
                    </div> <!-- /account-avatar -->

                    <div class="account-details">

                        <span class="account-name">${user.username}</span>

                        <span class="account-role">管理员</span>

                        <span class="account-actions">
							<a href="javascript:;">Profile</a> |

							<a href="javascript:;">Edit Settings</a>
						</span>

                    </div> <!-- /account-details -->

                </div> <!-- /account-container -->

                <hr />

                <ul id="main-nav" class="nav nav-tabs nav-stacked">

                    <li class="active">
                        <a href="../">
                            <i class="icon-home"></i>
                            工作台
                        </a>
                    </li>

                    <li>
                        <a href="./faq.html">
                            <i class="icon-pushpin"></i>
                            FAQ
                        </a>
                    </li>

                    <li>
                        <a href="./plans.html">
                            <i class="icon-th-list"></i>
                            Pricing Plans
                        </a>
                    </li>

                    <li>
                        <a href="./grid.html">
                            <i class="icon-th-large"></i>
                            Grid Layout
                            <span class="label label-warning pull-right">5</span>
                        </a>
                    </li>

                    <li>
                        <a href="./charts.html">
                            <i class="icon-signal"></i>
                            Charts
                        </a>
                    </li>

                    <li>
                        <a href="./account.html">
                            <i class="icon-user"></i>
                            User Account
                        </a>
                    </li>

                    <li>
                        <a href="./login.html">
                            <i class="icon-lock"></i>
                            Login
                        </a>
                    </li>

                </ul>

                <hr />

                <div class="sidebar-extra">
                    <p>初次测试模板外观</p>
                </div> <!-- .sidebar-extra -->

                <br />

            </div> <!-- /span3 -->



            <div class="span9">

                <h1 class="page-title">
                    <i class="icon-home"></i>
                    工作台
                </h1>

                <!--<div class="widget">-->
                <!---->
                <!--<div class="widget-header">-->
                <!--<i class="icon-signal"></i>-->
                <!--<h3>Area Chart</h3>-->
                <!--</div> &lt;!&ndash; /widget-header &ndash;&gt;-->
                <!---->
                <!--<div class="widget-content">					-->
                <!--<div id="bar-chart" class="chart-holder"></div> &lt;!&ndash; /bar-chart &ndash;&gt;				-->
                <!--</div> &lt;!&ndash; /widget-content &ndash;&gt;-->
                <!---->
                <!--</div> &lt;!&ndash; /widget &ndash;&gt;-->



                <div class="row">

                    <div class="span9">

                        <div class="widget">

                            <div class="widget-header">
                                <h3>标题头</h3>
                            </div> <!-- /widget-header -->

                            <div class="widget-content">
                                <table id="table">
                                    <thead>
                                    <tr>
                                        <th data-field="name">Name</th>
                                        <th data-field="stargazers_count">Stars</th>
                                        <th data-field="forks_count">Forks</th>
                                        <!--<th data-field="description">Description</th>-->
                                    </tr>
                                    </thead>
                                </table>
                            </div> <!-- /widget-content -->

                        </div> <!-- /widget -->

                    </div> <!-- /span5 -->


                </div> <!-- /row -->
            </div><!-- /工作台 -->
        </div><!-- /row -->
    </div> <!-- /container -->
</div> <!-- /content -->


<div id="footer">

    <div class="container">
        <hr />
        <p class="text-right">
            &copy; 河南开源房地产估价有限公司技术部</p>
    </div> <!-- /container -->

</div> <!-- /footer -->




<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="theme/js/jquery-3.2.0.js"></script>
<script src="theme/js/excanvas.min.js"></script>
<script src="theme/js/jquery.flot.js"></script>
<script src="theme/js/jquery.flot.pie.js"></script>
<script src="theme/js/jquery.flot.orderBars.js"></script>
<script src="theme/js/jquery.flot.resize.js"></script>


<script src="theme/js/bootstrap.js"></script>
<script src="theme/js/charts/bar.js"></script>
<script src="theme/js/bootstrap-table.js"></script>
<script src="theme/js/bootstrap-table-zh-CN.js"></script>
<script>
    var data = [
        {
            "name": "bootstrap-table",
            "stargazers_count": "526",
            "forks_count": "122",
            "description": "An extended Bootstrap table with radio, checkbox, sort, pagination, and other added features. (supports twitter bootstrap v2 and v3) "
        },
        {
            "name": "multiple-select",
            "stargazers_count": "288",
            "forks_count": "150",
            "description": "A jQuery plugin to select multiple elements with checkboxes :)"
        },
        {
            "name": "bootstrap-show-password",
            "stargazers_count": "32",
            "forks_count": "11",
            "description": "Show/hide password plugin for twitter bootstrap."
        },
        {
            "name": "blog",
            "stargazers_count": "13",
            "forks_count": "4",
            "description": "my blog"
        },
        {
            "name": "scutech-redmine",
            "stargazers_count": "6",
            "forks_count": "3",
            "description": "Redmine notification tools for chrome extension."
        }
    ];
    var data1 = [
        {
            "id": "bootstrap-table",
            "url": "526",
            "P-id": "122",
            "lev": "An extended Bootstrap table with radio, checkbox, sort, pagination, and other added features. (supports twitter bootstrap v2 and v3) "
        }

    ];

    $(function () {
        $('#table').bootstrapTable({
            data: data,
            detailView: true,

            onExpandRow: function ( index, row, $detail) {
                InitSubTable(index, row, $detail);
            }
        });
    });



    InitSubTable = function (index, row, $detail) {
//        var parentid = row.MENU_ID;
        var cur_table = $detail.html('<table></table>').find('table');
        $(cur_table).bootstrapTable({
//
//            url: '/api/MenuApi/GetChildrenMenu',
//            method: 'get',
//            queryParams: { strParentID: parentid },
//            ajaxOptions: { strParentID: parentid },
//            clickToSelect: true,
//            detailView: true,//父子表
//            uniqueId: "MENU_ID",
//            pageSize: 10,
//            pageList: [10, 25],
            data: data1,
            columns: [{
                checkbox: true
            }, {
                field: 'id',
                title: '菜单名称'
            }, {
                field: 'url',
                title: '菜单URL'
            }, {
                field: 'P-id',
                title: '父级菜单'
            }, {
                field: 'lev',
                title: '菜单级别'
            }]
        });
//            //无线循环取子表，直到子表里面没有记录
//            onExpandRow: function (index, row, $Subdetail) {
//                oInit.InitSubTable(index, row, $Subdetail);
//            }
//        });
    };

</script>

</body>
</html>
<%--</c:>--%>
<%}%>