<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Students</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript">
            $(function () {
                $("#scholarship").hide();

                $("#sch").change(function () {
                    if ($("#sch").val() == "y")
                        $("#scholarship").show();
                    else if ($("#sch").val() == "y")
                        $("#scholarship").hide();
                })
                $.ajax({
                    type: "GET",
                    url: "resources/types.txt",
                    dataType: "text",
                    success: function (msg) {
                        console.log(true);
                        $("#description").html(msg);
                    }
                });
            });
        </script>
    </head>
    <body>
        <jsp:include page="header.jsp" flush="true" />
        <jsp:include page="navbar.html" flush="true" />
        
        <h1>Add students</h1>
        <form action="emailList" method="post">
            <input type="hidden" name="action" value="add">
            <label>Id:</label>
            <input type="text" name="id" required><br>
            <label>Name:</label>
            <input type="text" name="name" required><br>
            <div id="description">

            </div>              
            <label>Scholarship:</label>
            <input type="radio" name="scholarship" id="sch" value="y"> Yes
            <input type="radio" name="scholarship" id="sch" value="n" required>No<br><br>
            <label>Type of scholarship</label>
            <select id="scholarship" name="scholarship_type">
                <option selected disabled hidden style='display: none' value=''></option>
                <option value = "Excellence">Excellence</option>
                <option value = "Academic">Academic</option>
                <option value = "Sports">Credit</option>
                <option value = "Lider">Lider del Mañana</option>
            </select>
            <br>
            <input type="submit" value="Join Now" id="submit">

        </form>
    </body>
</html>