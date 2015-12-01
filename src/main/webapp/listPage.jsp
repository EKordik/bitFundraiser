<%-- 
    Document   : listPage
    Created on : Nov 30, 2015, 6:15:08 PM
    Author     : emmakordik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LinkedIn Fundraiser List</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <link href="bit.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Sign Up List</h1>
        <div class="inputBx">
            <table class="table table-striped">
                <tr>
                    <th>Number</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Date</th>
                    <th></th>
                </tr>
                <c:forEach var="s" items="${list}">
                    <tr>
                        <td>${s.idlinkedin}</td>
                        <td>${s.name}</td>
                        <td>${s.email}</td>
                        <td>${s.date}</td>
                        <td><form name="deleteForm" method="POST" action="fundraiser?action=delete">
                                <button name="listId" value="${s.idlinkedin}">
                                    Delete
                                </button>
                            </form></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
