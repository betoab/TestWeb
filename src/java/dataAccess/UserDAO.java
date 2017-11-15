
package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import murach.business.Student;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chuy_
 */
public class UserDAO {

    private PreparedStatement statement;
    private Connection connection;
    private static final Logger logger = Logger.getLogger(UserDAO.class.getName());

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void addUser(Student user) {
        try {
            statement = connection.prepareStatement("INSERT INTO students VALUES(?,?,?,?)");
            synchronized (statement) {
                statement.setString(1, user.getId());
                statement.setString(2, user.getName());
                statement.setString(3, user.getScholarship());
                statement.setString(4, user.getType_scholarship());
                statement.executeUpdate();
            }
            statement.close();
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE, sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
    }

    public List<Student> scholarshipStudents() {
        List<Student> students = new ArrayList<>();
        Student student = null;
        try {
            statement = connection.prepareStatement("select *from students where scholarship = 'y'");
            synchronized (statement) {
                ResultSet results = statement.executeQuery();

                while (results.next()) {
                    student = new Student();
                    student.setId(results.getString("id"));
                    student.setName(results.getString("name"));
                    student.setScholarship(results.getString("scholarship"));
                    student.setType_scholarship(results.getString("type_scholarship"));
                    students.add(student);
                }
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return students;
    }

}
