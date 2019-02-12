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
            <!--模态窗口 -->
            <a  class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" id="myModal">
                点击出现模态窗口
            </a>
            <!--窗口内容-->
            <div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">×</span>
                            </button>
                            <h4 class="modal-title" id="myModalLabel">模态窗口</h4>
                        </div>
                        <div class="modal-body modal-li">
                            <form>
                                <ul>
                                    <li>
                                        <label for="name">姓名</label>
                                        <input type="text" class="form-control text-input" id="name" placeholder="请输入姓名">
                                    </li>
                                    <li>
                                        <label for="name">编号</label>
                                        <input type="text" class="form-control text-input" id="number" placeholder="请输入编号">
                                    </li>
                                    <li>
                                        <label for="name">性别</label>
                                        <input type="radio" name="sex" id="man" value="男" style="margin-left:10px;"/>男
                                        <input type="radio" name="sex" id="women" value="女" style="margin-left:10px;"/>女
                                    </li>
                                </ul>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="button" class="btn btn-primary"  onclick="modalsave()">保存</button>
                        </div>
                    </div>
                </div>
            </div>
            <!--end-模态窗口 -->


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
    $(function(){
        $("#myModal").click(function(){
            //使用getJSON方法读取json数据,xxx.json可以是不同类型文件，只要其中的数据为json类型即可
            $.getJSON('dashboard/data1.json',function(data){
                var html = '';
                $.each(data,function(i,item){
                    var name = item['name'];
                    var number = item['number'];
                    var sex = item['sex'];

                    $('#name').val(name);
                    $('#number').val(number);
                    if (sex == '女') {
                        document.getElementById('women').checked = true;
                    } else {
                        document.getElementById('man').checked = true;
                    }
                });
            });

            $('#modal').modal('show');
        });


    });
    function modalsave(){
        $("#modal").on("hidden.bs.modal", function() {
            $(this).removeData("bs.modal");
        });
    }

    $("#modal").on("hidden.bs.modal", function() {
        $(this).removeData("bs.modal");
    });
</script>
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
                var inputbdw ='<div class="col-md-3">\
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
                        <label for="dan">单价（元/㎡）</label>\
                        <input type="text" name="danjia'+fieldID+'" class="form-control" id="dan" placeholder="评估单价">\
                    </div>\
                </div>\
                <div class="col-md-3">\
                    <div class="form-group">\
                        <label for="zongjia">总价（万元）</label>\
                        <input type="text" name="zongjia'+fieldID+'" class="form-control" id="zongjia" placeholder="标的物总价">\
                    </div>\
                </div>\
                <br/><br/><br>\
                <div class="col-md-3">\
                    <div class="form-group">\
                        <label for="gujiashi">签字估价师</label>\
                        <input type="text"  name="gujiashi'+fieldID+'" class="form-control" id="gujiashi" placeholder="估价师">\
                    </div>\
                </div>\
                <div class="col-md-3">\
                    <div class="form-group">\
                        <label for="proname">小区名称</label>\
                        <input type="text" name="proname'+fieldID+'" class="form-control" id="proname" placeholder="小区名称">\
                    </div>\
                </div>\
                <br/><br/><br><hr/>';
                $("#biaodiwu").append(inputbdw);
                $("#bdwct").val(fieldID);

            }
            else
            {
                alert("Maximum email fields reached.");
            }
            alert($("#bdwct").val());
        });
    });

</script>
