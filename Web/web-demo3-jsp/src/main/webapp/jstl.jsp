<%--
    案例：获取servlet传过来的集合对象中的数据
    EL表达式：主要功能为获取在请求转发/cookie/session中存储的键为XXX的数据
    JSTL：用标签替换JSP上面的java代码，如判断与循环
    1.使用EL表达式开启需要
        声明：<%@page isELIgnored="false" %>
        jsp文件中使用el表达式获取数据：${xxx}
    2.使用jstl标签需要
        1.pom文件导包
        2.引入taglib标签：<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        3.常见的jstl标签：c:if与c:forEach
    3.c：if标签
        指定判断条件：test属性
    4.c：foreach标签指定
        1.遍历的数据：items属性
        2.遍历数据中单个元素的名字：var属性（var.xxx会调用该对象的类中对应的getXxx方法）
        3.遍历过程中的序号名：varStatus属性
            varStatus的属性：index从0开始计数|count从1开始计数
        4.指定遍历时设置var的开始，结束，步长：begin，end，step
--%>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Title</title></head>
<body>
<c:if test="true"><h3>true</h3></c:if>
<c:if test="${status==1}"><h3>${status}</h3></c:if>
<table border="1" cellspacing="0" width="800">
    <c:forEach items="${brands}" var="brand" varStatus="status">
        <tr align="center">
            <td>${status.count}</td>
            <td>${brand.brandName}></td>
            <td>${brand.companyName}></td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>
            <td>
                <c:if test="${brand.status==1}"><%="启用"%></c:if>
                <c:if test="${brand.status==0}"><%="禁用"%></c:if>
            </td>
            <td>
                <a href="">修改 </a>
                <a href="">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<hr>
<c:forEach begin="1" end="10" step="1" var="i">
    <a href="">${i}</a>
</c:forEach>
</body>
</html>
