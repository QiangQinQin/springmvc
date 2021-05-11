<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改页面</title>
</head>
    <body>
        <form action="${pageContext.request.contextPath }/student/submit" method="post">
            <table width="60%" border="1"align="center">
                <h1 align="center">修改用户信息</h1>
                <tr>
                    <td  width="30%" align="center">用户ID</td>
                    <td width="30%" align="center">
                        <input type="text" name="SID" value="${student.SID }"  readonly   />
                    </td>
                    <%--用户id不能修改
                        name 和 后端Student类对应属性名 保持一致--%>

                </tr>
                <tr>
                    <td width="30%" align="center">用户名</td>
                    <td width="30%"  align="center">
                        <input id="studentname" type="text" name="Sname" value="${student.sname }" />
                    </td>

                </tr>
                <tr>
                    <td width="30%" align="center">性别</td>
                    <td width="30%" align="center">
                        <input id="sex" type="text" name="Ssex" value="${student.ssex }"  />
                    </td>
                </tr>
                <tr>
                    <td width="30%" align="center">年龄</td>
                    <td width="30%" align="center">
                        <input id="address" type="text" name="Sage" value="${student.sage }"  />
                    </td>
                </tr>

                <tr >
                    <td colspan="2" align="center">
                        <input   type="submit" value="提交" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>