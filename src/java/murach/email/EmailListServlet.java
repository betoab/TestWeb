package murach.email;

import dataAccess.ConnectionDB;
import dataAccess.UserDAO;
import java.io.*;
import java.sql.Connection;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import murach.business.Student;
//import murach.data.UserDB;

@WebServlet(urlPatterns = {"/emailList"})
public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.html";
// get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join"; // default action
        }
// perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/index.html"; // the "join" page
        } else if (action.equals("add")) {
// get parameters from the request
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String scholarship = request.getParameter("scholarship");
            String scholarship_type = request.getParameter("scholarship_type");
// store data in User object and save User object in database
            Student student = new Student(id, name, scholarship, scholarship_type);

            ConnectionDB connectionDB = new ConnectionDB();
            Connection connection = connectionDB.getConnection();

            UserDAO userDao = new UserDAO(connection);
            userDao.addUser(student);
// set User object in request object and set URL
            request.setAttribute("student", student);
            if (student.getScholarship().equals("y")) {
                url = "/scholaStudent.jsp";
            } else {
                url = "/noScholaStudent.jsp"; // the "thanks" page
            }

            request.setAttribute("student", student);
        }
// forward request and response objects to specified URL
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.getConnection();

        UserDAO userDao = new UserDAO(connection);
        String url = "";
        if (action.equals("scholarships")) {
            request.setAttribute("students", userDao.scholarshipStudents());
            url = "/all.jsp";
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);

    }
}
