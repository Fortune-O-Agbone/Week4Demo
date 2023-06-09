<%-- 
    Document   : helloWorldForm
    Created on : 4-Sep-2020, 10:04:59 AM
    Author     : awarsyle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--
    adding the core java taglib to the file after adding 
    the JSTL 1.2.1 library to the Libraries folder.

    This is to ensure that all content (messages and errors)
    are only part of the JSP (the view) and not coming from
    the servlet.

--> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello World</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form method="post" action="hello">
            First name: <input type="text" name="firstname" value="${firstname}"><br>
            Last name: <input type="text" name="lastname" value="${lastname}"><br>
            <input type="submit" value="Submit">
        </form>
            <c:if test="${invalid == true}">
            <p>Invalid entry. Please enter both your first and last names.</p>
            </c:if>
    </body>
</html>
