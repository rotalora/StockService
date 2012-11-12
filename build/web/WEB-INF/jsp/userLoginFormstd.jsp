<%-- 
    Document   : loginform
    Created on : Nov 5, 2012, 6:59:30 PM
    Author     : rotalora
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<form name="username_form" method="POST" action="loginPage.htm"
      onsubmit="return validate_form();">
    <table cellpadding="0" cellspacing="0" border="0">
        <tr>
            <td align="right">Username:&nbsp;</td>
            <td>
                <input name="username" type="text"/>
            </td>
        </tr>
        <tr>
            <td align="right">Password:&nbsp;</td>
            <td>
                <input name="password" type="password"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input id="submit" type="submit" value="Login">
            </td>
        </tr>
    </table>
</form>
