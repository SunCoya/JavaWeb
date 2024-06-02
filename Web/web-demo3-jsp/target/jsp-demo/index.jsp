<%--
    1.JSP（JavaServerPages）：既可以写html，又能写java代码
        会把jsp文件转换为java文件并编译执行，本质为Servlet服务资源
    2.使用在jsp中引用别的类：需要导包
    3.在jsp文件中写java代码：<%xxx%>
    4.插入数据到前端代码上：<%=xxx%>
--%>
<%@ page import="org.example.pojo.Brand" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%
    List<Brand> brands = new ArrayList<>();
    System.out.println("HelloJSP!");
    String str="JSP!";
%>
<%="你好，"+str%><br>
</body>
</html>
