<%-- 
    Document   : resultPage
    Created on : Nov 7, 2012, 9:32:45 PM
    Author     : rotalora
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <title><fmt:message key="welcome"/></title>
        <script src="accounting.js"></script>
    </head>
    <body>
        <h1><fmt:message key="welcome"/></h1>

            <ul id="list-nav">
                <li><a href="<c:url value="purchasePrompt.htm"/>">Purchase</a></li>
                <li><a href="<c:url value="reportPrompt.htm"/>">Report</a></li>
                <li><a href="<c:url value="userLogin.htm"/>">Logout</a></li>
            </ul><br><br>

        <h2><fmt:message key="greeting"/> ${model.resultMsg}.</h2>
        <h2><c:out value="${model.firstName}"/> <c:out value="${model.lastName}"/></h2><br>
        <h2>Summary of Account</h2>

        <h3>Your holdings</h3><br />

        <table id="stocks" cellpadding="0" cellspacing="0" border="0">
            <th>Symbol</th>
            <th>Stock</th>
            <th id="stocks">Quantity</th>
            <th id="stocks">Div. Yield</th>
            <th id="stocks">Current Price</th>
            <th id="stocks">Value</th>
            <c:forEach items="${model.holdings}" var="stock">
                <tr>
                    <td><c:out value="${stock.symbol}"/></td>
                    <td><c:out value="${stock.stockName}"/></td>
                    <td id="stocks"><c:out value="${stock.quantity}"/></td>
                    <td id="stocks">
                        <script>
                            var value;
                            value=${stock.dividendYield};
                            document.write(value.toFixed(4));
                            document.write("%");

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
