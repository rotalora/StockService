<%-- 
    Document   : reportPage
    Created on : Nov 9, 2012, 11:59:58 PM
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

        <h2><c:out value="${model.firstName}"/> <c:out value="${model.lastName}"/> detail report</h2>
        <h2>For stock <c:out value="${model.stockname}"/></h2>

        <table width="900" cellpadding="0" cellspacing="0" border="0">
        <th>Symbol  </th>
        <th id="stocks">Quantity</th>
        <th>Purchase Date</th>
        <th id="stocks">Purchase Price</th>
        <th id="stocks">Cost</th>
        <th id="stocks">Current Price</th>
        <th id="stocks">Value</th>
        <c:forEach items="${model.holdings}" var="stock">
            <tr>
                <td><c:out value="${stock.symbol}"/></td>
                <td id="stocks"><c:out value="${stock.quantity}"/></td>
                <td><c:out value="${stock.purchaseDate}"/></td>
                <td id="stocks">
                    <script>
                        var price;
                        price=${stock.purchasePrice};
                        document.write(accounting.formatMoney(price));
                    </script>
                </td>
                <td id="stocks">
                    <script>
                        var cost;
                        cost=${stock.purchasePrice}*${stock.quantity}
                        document.write(accounting.formatMoney(cost));
                    </script>
                </td>
                <td id="stocks">
                    <script>
                        var price;
                        price=${stock.currentPrice};
                        document.write(accounting.formatMoney(price));
                    </script>
                </td>
                <td id="stocks">
                    <script>
                        var value;
                        value=${stock.value};
                        document.write(accounting.formatMoney(value));
                    </script>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td>Total value</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td id="stocks">
                <script>
                    var value;
                    value=${model.value};
                    document.write(accounting.formatMoney(value));
                </script>
            </td>
        </tr>
        </table>
    </body>
</html>
