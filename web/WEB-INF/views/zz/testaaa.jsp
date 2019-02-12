<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
        <div class="col-md-2  sidebar">
            <ul class="nav nav-sidebar">
                <li><a href="<%=basePath%>index.do">报告查询 </a></li>
                <li class="active" ><a href="<%=basePath%>input.do"><span class="sr-only">(current)</span>报告录入</a></li>

            </ul>

        </div>
        <div class="col-md-9 col-md-offset-2 main">
            <br/>
            <h1 class="page-header">报告录入</h1>
            <br/>
            <form class="form-inline" action="<%=basePath%>testfix.do" method="post">
                <div id ="biaodiwu">
                    <c:forEach var="b" items="${bgs}" varStatus="status">
                        <div id="bdw${status.index+1}">
                            <div class="col-md-3">
                                <div class="form-group">
                                    <label for="chanquanren">产权人</label>
                                    <input type="text" name="chanquanren${status.index+1}" class="form-control" id="chanquanren" placeholder="产权人姓名" value="${b.chanquanren}">
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="form-group">
                                    <label for="zuoluo">房屋坐落</label>
                                    <input type="text" name="zuoluo${status.index+1}" class="form-control" id="zuoluo" placeholder="正式/预评报告编号" value="${b.zuoluo}">
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="form-group">
                                    <label for="mianji">建筑面积</label>
                                    <input type="text" name="mianji${status.index+1}" class="form-control" id="mianji" placeholder="建筑面积"  value="${b.mianji}">
                                </div>
                            </div>
                            <br><br><br>
                            <div class="col-md-3">
                                <div class="form-group">
                                    <label for="niandai">建筑年代</label>
                                    <input type="text" name="niandai${status.index+1}" class="form-control" id="niandai" placeholder="竣工年代"  value="${b.niandai}">
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="form-group">
                                    <label for="suo">所在层数</label>
                                    <input type="text" name="suo${status.index+1}" class="form-control" id="suo" placeholder="所在层"  value="${b.suo}">
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="form-group">
                                    <label for="zong">总层数</label>
                                    <input type="text" name="zong${status.index+1}" class="form-control" id="zong" placeholder="总层数"  value="${b.zong}">
                                </div>
                            </div>
                            <br><br><br>
                            <div class="col-md-3">
                                <div class="form-group">
                                    <label for="yongtu">规划用途</label>
                                    <input type="text" name="yongtu${status.index+1}" class="form-control" id="yongtu" placeholder="规划用途"  value="${b.yongtu}">
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="form-group">
                                    <label for="dan">单价（元/㎡）</label>
                                    <input type="text" name="danjia${status.index+1}" class="form-control" id="dan" placeholder="评估单价"  value="${b.danjia}">
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="form-group">
                                    <label for="proname">小区名称</label>
                                    <input type="text" name="proname${status.index+1}" class="form-control" id="proname" placeholder="小区名称"  value="${b.proname}">
                                </div>
                            </div>
                            <br/><br/><br>
                            <div class="col-md-5">
                                <div class="form-group">
                                    <label for="zongjia">总价（万元）</label>
                                    <input type="text" name="zongjia${status.index+1}" class="form-control" id="zongjia" placeholder="标的物总价"  value="${b.zongjia}">
                                    <select class="form-control" id="point" name="point${status.index+1}" >
                                        <option>${b.point}</option>
                                        <option>保留二位</option>
                                        <option>保留一位</option>
                                        <option>不保留</option>
                                    </select>
                                </div>
                            </div>
                            <input type="button" class="form-control del" id="${status.index+1}" value="移除该标的物" />
                            <br/><br/><br>
                        </div>
                    </c:forEach>
                </div>
                    <h3>添加标的物</h3>
                    <hr>
                    <div class="col-md-3">
                        <div class="form-group">
                            <input type="button"  name="add" class="form-control" id="add" value="添加标的物">
                        </div>
                    </div>
                    <br><br><br>
                    <div class="col-md-10">
                        <input type="hidden" name="bdwct" id="bdwct" />
                        <p class="text-center">
                            <input class="btn btn-default" type="submit" value="提交报告">
                            <input class="btn btn-default" type="reset" value="重新填写">
                        </p>

                    </div>
                </div>


            </form>


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
<script src="dashboard/js/bootstrap3-typeahead.js"></script>
</body>
</html>
<script>
    $("#biaoti").css({color:"#F4FBFF",
        fontSize:30,fontType:"楷体"});
</script>
<script>
    $("#zhuanxie").typeahead({
        source: function (query, process) {
            var parameter = {query: query};
            $.post('testa.do', parameter, function (data) {
                process(data);
            });
        },
        items: 8,//最多显示个数
        updater: function (item) {
            return item;//这里一定要return，否则选中不显示，外加调用display的时候null reference错误。
        },
        displayText: function (item) {
            return item;//返回字符串
        },
        afterSelect: function (item) {
            //选择项之后的事件 ，item是当前选中的。
        },
        delay: 500//延迟时间
    });

    $("#shenhe").typeahead({
        source: function (query, process) {
            var parameter = {query: query};
            $.post('testa.do', parameter, function (data) {
                process(data);
            });
        },
        items: 8,//最多显示个数
        updater: function (item) {
            return item;//这里一定要return，否则选中不显示，外加调用display的时候null reference错误。
        },
        displayText: function (item) {
            return item;//返回字符串
        },
        afterSelect: function (item) {
            //选择项之后的事件 ，item是当前选中的。
        },
        delay: 500//延迟时间
    });

    $("#kancha").typeahead({
        source: function (query, process) {
            var parameter = {query: query};
            $.post('testa.do', parameter, function (data) {
                process(data);
            });
        },
        items: 8,//最多显示个数
        updater: function (item) {
            return item;//这里一定要return，否则选中不显示，外加调用display的时候null reference错误。
        },
        displayText: function (item) {
            return item;//返回字符串
        },
        afterSelect: function (item) {
            //选择项之后的事件 ，item是当前选中的。
        },
        delay: 500//延迟时间
    });

    $("#jiazhigoutong").typeahead({
        source: function (query, process) {
            var parameter = {query: query};
            $.post('testa.do', parameter, function (data) {
                process(data);
            });
        },
        items: 8,//最多显示个数
        updater: function (item) {
            return item;//这里一定要return，否则选中不显示，外加调用display的时候null reference错误。
        },
        displayText: function (item) {
            return item;//返回字符串
        },
        afterSelect: function (item) {
            //选择项之后的事件 ，item是当前选中的。
        },
        delay: 500//延迟时间
    });
    $("#dingjia").typeahead({
        source: function (query, process) {
            var parameter = {query: query};
            $.post('testa.do', parameter, function (data) {
                process(data);
            });
        },
        items: 8,//最多显示个数
        updater: function (item) {
            return item;//这里一定要return，否则选中不显示，外加调用display的时候null reference错误。
        },
        displayText: function (item) {
            return item;//返回字符串
        },
        afterSelect: function (item) {
            //选择项之后的事件 ，item是当前选中的。
        },
        delay: 500//延迟时间
    });
    $("#shidikc").typeahead({
        source: function (query, process) {
            var parameter = {query: query};
            $.post('testa.do', parameter, function (data) {
                process(data);
            });
        },
        items: 8,//最多显示个数
        updater: function (item) {
            return item;//这里一定要return，否则选中不显示，外加调用display的时候null reference错误。
        },
        displayText: function (item) {
            return item;//返回字符串
        },
        afterSelect: function (item) {
            //选择项之后的事件 ，item是当前选中的。
        },
        delay: 500//延迟时间
    });

    $("#jszhuanxie").typeahead({
        source: function (query, process) {
            var parameter = {query: query};
            $.post('testa.do', parameter, function (data) {
                process(data);
            });
        },
        items: 8,//最多显示个数
        updater: function (item) {
            return item;//这里一定要return，否则选中不显示，外加调用display的时候null reference错误。
        },
        displayText: function (item) {
            return item;//返回字符串
        },
        afterSelect: function (item) {
            //选择项之后的事件 ，item是当前选中的。
        },
        delay: 500//延迟时间
    });
</script>

<script type="text/javascript" charset="utf-8">
    $(function() {
        var fieldCount = 0;
        $("#add").click(function() {
            fieldCount++;
            if(fieldCount <= 5)
            {
                var fieldID = fieldCount;
                var inputbdw ='\
                <div>\
                \<input type="button" class="form-control del" id=del"'+fieldID+'" value="移除该标的物" />\
                    <div class="col-md-3">\
                    <div class="form-group">\
                        <label for="chanquanren">产权人</label>\
                        <input type="text" name="chanquanren'+fieldID+'" class="form-control" id="chanquanren" placeholder="产权人姓名">\
                    </div>\
                    </div>\
                    <div class="col-md-3">\
                        <div class="form-group">\
                            <label for="zuoluo">房屋坐落</label>\
                            <input type="text" name="zuoluo'+fieldID+'" class="form-control" id="zuoluo" placeholder="正式/预评报告编号">\
                        </div>\
                    </div>\
                    <div class="col-md-3">\
                        <div class="form-group">\
                            <label for="mianji">建筑面积</label>\
                            <input type="text" name="mianji'+fieldID+'" class="form-control" id="mianji" placeholder="建筑面积">\
                        </div>\
                    </div>\
                    <br><br><br>\
                    <div class="col-md-3">\
                        <div class="form-group">\
                            <label for="niandai">建筑年代</label>\
                            <input type="text" name="niandai'+fieldID+'" class="form-control" id="niandai" placeholder="竣工年代">\
                        </div>\
                    </div>\
                    <div class="col-md-3">\
                        <div class="form-group">\
                            <label for="suo">所在层数</label>\
                            <input type="text" name="suo'+fieldID+'" class="form-control" id="suo" placeholder="所在层">\
                        </div>\
                    </div>\
                    <div class="col-md-3">\
                        <div class="form-group">\
                            <label for="zong">总层数</label>\
                            <input type="text" name="zong'+fieldID+'" class="form-control" id="zong" placeholder="总层数">\
                        </div>\
                    </div>\
                    <br><br><br>\
                    <div class="col-md-3">\
                        <div class="form-group">\
                            <label for="yongtu">规划用途</label>\
                            <input type="text" name="yongtu'+fieldID+'" class="form-control" id="yongtu" placeholder="规划用途">\
                        </div>\
                    </div>\
                    <div class="col-md-3">\
                        <div class="form-group">\
                            <label for="proname">小区名称</label>\
                            <input type="text" name="proname'+fieldID+'" class="form-control" id="proname" placeholder="小区名称">\
                        </div>\
                    </div>\
                    <br/><br/><br>\
                    <div class="col-md-3">\
                        <div class="form-group">\
                            <label for="danjia">单价（元/㎡）</label>\
                            <input type="text" name="danjia'+fieldID+'" class="form-control" id="danjia" placeholder="评估单价">\
                        </div>\
                    </div>\
                    <div class="col-md-6">\
                        <div class="form-group">\
                            <label for="zongjia">总价（万元）</label>\
                            <input type="text" name="zongjia'+fieldID+'" class="form-control" id="zongjia" placeholder="标的物总价">\
                            <select class="form-control" id="point" name="point'+fieldID+'">\
                               <option>保留二位</option>\
                                <option>保留一位</option>\
                                <option>不保留</option>\
                            </select>\
                        </div>\
                    </div>\
                    <br/><br/><br><hr/>\
                <input type="hidden" class="bdwnow" value="'+fieldID+'" />\
                </div>';
                $("#biaodiwu").append(inputbdw);
                $("#bdwct").val(fieldID-1);

            }
            else
            {
                alert("过多标的物超出5个范围了");
            }
        });
        $(document).on("click",".del",function() {
            $(this).parent('div').remove();
            fieldCount = fieldCount -1;
            $("#bdwct").val(fieldCount);
            alert($("#bdwct").val());
        });
    });

</script>
