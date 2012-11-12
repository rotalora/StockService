<%-- 
    Document   : homePage
    Created on : Nov 7, 2012, 9:12:55 PM
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

                if (document.username_form.username.value == "")
                {
                    alert("Please fill in your username");
                    valid = false;
                }
                if (document.username_form.password.value == "")
                {
                    alert("Please fill in your password");
                    valid = false;
                }

                return valid;
            }

            //-->
        </script>
    </head>
    <body>
        <h1><fmt:message key="heading"/></h1>
        <h2>${model.resultMsg}</h2>
        <%@include file="userLoginFormstd.jsp" %>
    </body>
</html>
