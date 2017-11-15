
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scholarship</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
         <jsp:include page="header.jsp" flush="true" />
        <jsp:include page="navbar.html" flush="true" />
        <h1>You have scholarship</h1>
        <div>           
            <h3>Id: </h3>
            <span>${student.id}</span> <br>
            <h3>Name:  </h3>
            <span>${student.name}</span> <br>
            <h3>Scholarship Type </h3>
            <span>${student.type_scholarship}</span> <br>
        </div>
    </body>
</html>
