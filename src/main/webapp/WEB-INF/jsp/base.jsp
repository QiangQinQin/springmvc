<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
            "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>数据提交</title>
</head>
    <body>
        <%--测试参数绑定的基本数据类型
            指定提交到的URL，不需要写IP 端口   Post是用来向服务器上传递数据--%>
        <form action="/student/test" method="post">
            <input  name="num"     value="10"  type="text"/> <%--这里把值给死了，仅测试用--%>
            <button type="submit" > 提交</button>
        </form>

    </body>
</html>