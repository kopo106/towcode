<%@page pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <%--<div class="navbar-header">--%>


        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <%--<ul class="nav navbar-nav">--%>
            <%--<li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>--%>
            <%--<li><a href="#">Link</a></li>--%>
            <%--<li class="dropdown">--%>
            <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>--%>
            <%--<ul class="dropdown-menu">--%>
            <%--<li><a href="#">Action</a></li>--%>
            <%--<li><a href="#">Another action</a></li>--%>
            <%--<li><a href="#">Something else here</a></li>--%>
            <%--<li role="separator" class="divider"></li>--%>
            <%--<li><a href="#">Separated link</a></li>--%>
            <%--<li role="separator" class="divider"></li>--%>
            <%--<li><a href="#">One more separated link</a></li>--%>
            <%--</ul>--%>
            <%--</li>--%>
            <%--</ul>--%>
            <ul class="nav navbar-nav navbar-left">
                <p id="biaoti" class="text-left">河南开源技术部</p>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <%--<li><a href="#">Link</a></li>--%>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%=loginuser.getUsername()%>----<%=loginuser.getBumen()%><span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="<%=basePath%>userinfo.do">密码修改</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="<%=basePath%>toLogin.do">用户注销</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->

        <%--</div>--%>
    </div>
</nav>