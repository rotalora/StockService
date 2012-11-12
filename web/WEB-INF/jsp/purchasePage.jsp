<%-- 
    Document   : purchasePage
    Created on : Nov 10, 2012, 12:11:12 AM
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
        <script src="accounting.js"></script>
    </head>
    <body>
        <h1><fmt:message key="report"/></h1>

        <ul id="list-nav">
            <li><a href="<c:url value="loginPage.htm"/>">Home</a></li>
            <li><a href="<c:url value="userLogin.htm"/>">Logout</a></li>
        </ul><br><br>

        <h2><c:out value="${model.firstName}"/> <c:out value="${model.lastName}"/></h2>
        <h2>Thank you for your purchase</h2>
        <h2>You just bought the following:</h2>

        <table cellpadding="0" cellspacing="0" border="0">
            <th>Symbol</th>
            <th>Stock</th>
            <th id="stocks">Quantity</th>
            <th id="stocks">Purchase Price</th>
            <th id="stocks">Cost</th>
            <tr>
                <td><c:out value="${model.userstock.symbol}"/></td>
                <td><c:out value="${model.userstock.stockName}"/></td>
                <td id="stocks"><c:out value="${model.userstock.quantity}"/></td>
                <td id="stocks">
                    <script>
                        var price;
                        price = ${model.userstock.purchasePrice};
                        document.write(accounting.formatMoney(price));
                    </script>
                </td>
                <td id="stocks">
                    <script>
                        var value;
                        value = ${model.userstock.value};
                        document.write(accounting.formatMoney(value));
                    </script>
                </td>
            </tr>
        </table>
    </body>
</html>
