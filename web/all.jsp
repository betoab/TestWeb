

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
        <title>Display All Members</title>
    </head>
    <body>
          <jsp:include page="header.jsp" flush="true" />
        <jsp:include page="navbar.html" flush="true" />
        <h1>All Members</h1>       
        <div class="table-separation">
            <table border="1">
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>ScholarShip Type</th>                    
                </tr>
                <c:forEach var="student" items="${students}" >
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.name}</td>
                        <td>${student.type_scholarship}</td>                        
                    </tr>   
                </c:forEach>

            </table>
        </div>

    </body>
</html>
