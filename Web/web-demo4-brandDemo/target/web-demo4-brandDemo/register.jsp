<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>欢迎注册</title>
    <link href="css/register.css" rel="stylesheet">
</head>

<body>
    <div class="form-div">
        <div class="reg-content">
            <h1>欢迎注册</h1>
            <span>已有帐号？</span> <a href="login.jsp">登录</a>
        </div>
        <form id="reg-form" action="/web_demo4_brandDemo_war/registerServlet" method="post">
            <table>
                <tr>
                    <td>用户名</td>
                    <td class="inputs">
                        <input name="username" type="text" id="username"><br>
                        <span id="username_exi" class="err_msg" style="display: none">用户已存在</span><br>
                        <span id="username_err" class="err_msg">${register_msg}</span>
                    </td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td class="inputs">
                        <input name="password" type="password" id="password"><br>
                        <span id="password_err" class="err_msg" style="display: none">密码格式有误</span>
                    </td>
                </tr>
                <tr>
                    <td>验证码</td>
                    <td class="inputs">
                        <input name="checkCode" type="text" id="checkCode">
                        <%--访问图片生成服务请求图片资源--%>
                        <img id="checkImg" src="/web_demo4_brandDemo_war/checkCodeServlet">
                        <a href="" id="changeImg">看不清？</a>
                    </td>
                </tr>
            </table>
            <div class="buttons">
                <input value="注 册" type="submit" id="reg_btn">
            </div>
            <br class="clear">
        </form>
    </div>
</body>
<script>
    //在这里如果不加后面的问号,点击图片不会改变
    changeImg= function () {document.getElementById("checkImg").src = "/web_demo4_brandDemo_war/checkCodeServlet?" + new Date().getMilliseconds();}
    document.getElementById("changeImg").onclick = changeImg
    document.getElementById("checkImg").onclick = changeImg

    document.getElementById("username").onblur=function (){
        //使用this.value获取用户名的值
        var username=this.value;
        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", " http://localhost/web_demo4_brandDemo_war/selectUserServlet?username="+username);
        xhttp.send();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                if(this.responseText==="true") document.getElementById("username_exi").style.display="";
                else document.getElementById("username_exi").style.display="none";
            }
        };
    }
</script>

</html>