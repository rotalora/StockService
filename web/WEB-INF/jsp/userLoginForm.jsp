<%-- 
    Document   : loginform
    Created on : Nov 5, 2012, 6:59:30 PM
    Author     : rotalora
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<form:form method="POST" commandName="user">
    <table cellpadding="0" cellspacing="0" border="0">
        <tr>
            <td align="right">Username:&nbsp;</td>
            <td>
                <form:input path="userName"/>
            </td>
        </tr>
        <tr>
            <td align="right">Password:&nbsp;</td>
            <td>
                <form:input path="userPassword"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Login">
            </td>
        </tr>
    </table>
</form:form>
