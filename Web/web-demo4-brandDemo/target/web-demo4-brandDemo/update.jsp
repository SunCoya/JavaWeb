<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPEhtml>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>修改品牌</title>
</head>

<body>
<h3>修改品牌</h3>
<form action="/web_demo4_brandDemo_war/updateServlet" method="post">
    <%--隐藏id--%>
    <input name="id" value="${brand.id}" type="hidden">
    品牌名称：<input name="brandName" value="${brand.brandName}"><br>
    企业名称：<input name="companyName" value="${brand.companyName}"><br>
    排序状况：<input name="ordered" value="${brand.ordered}"><br>
    描述信息：<textarea rows="5" cols="20" name="description">${brand.description}</textarea><br>
    状态信息：
    <input type="radio" name="status" value="0" <c:if test="${brand.status==0}">checked</c:if>>禁用
    <input type="radio" name="status" value="1" <c:if test="${brand.status==1}">checked</c:if>>启用<br>
    <input type="submit" value="提交">
</form>
</body>

</html>