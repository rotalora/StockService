<%-- 
    Document   : purchase
    Created on : Nov 9, 2012, 11:55:04 PM
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
        <script type="text/javascript">
            <!--

            function validate_form()
            {
                value = true;

                if (document.purchase_form.symbol.value == "")
                {
                    alert("Please fill in the symbol to purchase");
                    valid = false;
                }
                if (document.purchase_form.quantity.value == "")
                {
                    alert("Please fill in the amount to purchase");
                    valid = false;
                }
                var numberRegExp=/^[1-9][0-9]*$/;
                if (numberRegExp.test(document.purchase_form.quantity.value))
                {
                    valid = true;
                }
                else
                {
                    alert("Please enter a valid number to purchase");
                    valid = false;
                }

                return valid;
            }

            //-->
        </script>
    </head>
    <body>
        <h1><fmt:message key="report"/></h1>

        <ul id="list-nav">
            <li><a href="<c:url value="loginPage.htm"/>">Home</a></li>
            <li><a href="<c:url value="userLogin.htm"/>">Logout</a></li>
        </ul><br><br>

        <h2>Please <c:out value="${model.firstName}"/> <c:out value="${model.lastName}"/></h2>
        <h2>Enter the symbol to purchase</h2>

        <form name="purchase_form" method="POST" action="purchasePage.htm"
            onsubmit="return validate_form();">
            <table cellpadding="0" cellspacing="0" border="0">
                <tr>
                    <td align="right">Symbol:&nbsp;</td>
                    <td>
                        <input name="symbol" type="text"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">Quantity:&nbsp;</td>
                    <td>
                        <input name="quantity" type="text"/>
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
