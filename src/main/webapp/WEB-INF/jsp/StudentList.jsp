<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>学生信息展示</title>
</head>
<body>
<table align="center" border="1">
    <thead>
    <tr>
        <td>学生ID</td>
        <td>用户名</td>
        <td>性别</td>
        <td>年龄</td>
        <td>编辑</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.SID}</td>
            <td>${student.sname}</td>
            <td>${student.ssex}</td>
            <td>${student.sage}</td>
            <td><a href="${pageContext.request.contextPath}/student/${student.SID}"/>修改</td>
            <%--${pageContext.request.contextPath}就是获取localhost:8080这种信息，写死的话通用性会变差
                然后根据URL到controller层找对应方法--%>

             <%--<td>${student.Sname}</td>--%>
            <%--<td>${student.Ssex}</td>--%>
            <%--<td>${student.Sage}</td>--%>
        </tr>
    </c:forEach>
    </tbody>
</table>
</form>
</body>
</html>