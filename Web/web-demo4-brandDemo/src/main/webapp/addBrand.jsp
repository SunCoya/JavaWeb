<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>添加品牌</title>
</head>

<body>
<h3>添加品牌</h3>
<form action="/web_demo4_brandDemo_war/addServlet" method="post">
    品牌名称：<input name="brandName" value="淘宝"><br>
    企业名称：<input name="companyName" value="阿里巴巴"><br>
    排序状况：<input name="ordered" value="10"><br>
    描述信息：<textarea rows="5" cols="20" name="description">阿里巴巴</textarea><br>
    状态信息：
    <input type="radio" name="status" value="0" checked>禁用
    <input type="radio" name="status" value="1">启用<br>
    <input type="submit" value="提交">
</form>
</body>
</html>