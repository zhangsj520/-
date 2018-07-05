<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>持名法州后台管理中心</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <link rel="icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" type="text/css"></link>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css"></link>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/common.js"></script>
    <%--添加easy-ui 的组件--%>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/themes/ui-cupertino/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/themes/icon.css">
    <%--<script type="text/javascript"
            src="${pageContext.request.contextPath }/js/jquery.min.js"></script>--%>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/js/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">

        $(function () {
            $("#captchaImage").click(function () {
                $("#captchaImage").attr("src", "${pageContext.request.contextPath}/man/vCode?id=" + Math.random());
            });
            $("#manName").textbox({
                iconCls: 'icon-man',
                iconAlign: "right",
                prompt: "请输入昵称",
                required: true,
            });
            $("#manPassword").passwordbox({
                prompt: "请输入密码",
                showEye: true,
                required: true,

            });
            $("#code").validatebox({
                required: true,
                message: "验证码不能为空"
            });
            $("#loginForm").form({

                url: "${pageContext.request.contextPath}/man/login",
                onSubmit: function () {
                    var isValid = $(this).form("validate");
                    return isValid;
                },
                success: function (data) {
                    if($.trim(data) == "success"){
                         window.location.href="${pageContext.request.contextPath}/success.jsp";
                    }else{
                        window.location.href="${pageContext.request.contextPath}/error.jsp";
                    }
                }
            });

            $("#isRememberUsername").click(function(){
                    $("#isRememberUsername").attr("value","xuanzhong");
            });

        });
    </script>
</head>
<body>

<div class="login">

    <form id="loginForm" method="post">

        <table>
            <tbody>
            <tr>
                <td width="190" rowspan="2" align="center" valign="bottom">
                    <img src="${pageContext.request.contextPath}/img/header_logo.gif"/>
                </td>
                <th>
                    用户名:
                </th>
                <td>
                    <input type="text" id="manName" name="mName" class="text" value="${requestScope.mName}" maxlength="20"/>
                </td>
            </tr>
            <tr>
                <th>
                    密&nbsp;&nbsp;&nbsp;码:
                </th>
                <td>
                    <input type="text" id="manPassword" name="mPassword" class="text" value="" maxlength="20"/>
                </td>

            </tr>

            <tr>
                <td>&nbsp;</td>
                <th>验证码:</th>
                <td>
                    <input id="code" type="text" id="enCode" name="code" class="text captcha" maxlength="5"
                           autocomplete="off"/>
                    <img id="captchaImage" class="captchaImage" src="${pageContext.request.contextPath}/man/vCode"
                         title="点击更换验证码"/>
                </td>

            </tr>
            <tr>
                <td>
                    &nbsp;
                </td>
                <th>
                    &nbsp;
                </th>
                <td>
                    <label>
                        <input type="checkbox" name="check" id="isRememberUsername" value=""/> 记住用户名
                    </label>
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <th>&nbsp;</th>
                <td>
                    <input type="button" class="homeButton" value="" onclick="location.href='/'"><input type="submit"
                                                                                                        class="loginButton"
                                                                                                        value="登录">
                </td>
            </tr>
            </tbody>
        </table>
        <div class="powered">COPYRIGHT © 2008-2017.</div>
        <div class="link">
            <a href="http://www.chimingfowang.com/">持名佛网首页</a> |
            <a href="http://www.chimingbbs.com/">交流论坛</a> |
            <a href="">关于我们</a> |
            <a href="">联系我们</a> |
            <a href="">授权查询</a>
        </div>
    </form>
</div>
</body>
</html>