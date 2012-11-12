<%-- 
    Document   : report
    Created on : Nov 8, 2012, 4:39:56 AM
    Author     : rotalora
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">

        <title><fmt:message key="title"/></title>
    </head>
    <body>
        <h1><fmt:message key="report"/></h1>

        <ul id="list-nav">
            <li><a href="<c:url value="loginPage.htm"/>">Home</a></li>
            <li><a href="<c:url value="userLogin.htm"/>">Logout</a></li>
        </ul><br><br>

        <h2>Please <c:out value="${model.firstName}"/> <c:out value="${model.lastName}"/></h2>
        <h2>Enter the symbol for a detail report</h2>

        <form method="POST" action="reportPage.htm">
            <table cellpadding="0" cellspacing="0" border="0">
                <tr>
                    <td align="right">Symbol:&nbsp;</td>
                    <td>
                        <select name="symbol">
                            <c:forEach items="${model.userstocks}" var="stock">
                                <option value="<c:out value="${stock.symbol}"/>"><c:out value="${stock.stockName}"/>
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input id="submit" type="submit" value="Submit">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
