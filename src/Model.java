import java.sql.*;
import java.util.ArrayList;

public class Model {
    Connection conn;

    public Model ()throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/student_db",
            "root",
            ""
        );
    }

    public void addStudent(String name, int age) throws Exception {
        String query = "INSERT INTO students (name, age) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, name);
        stmt.setInt(2, age);
        stmt.executeUpdate();
    }

    public ArrayList<String> getStudents() throws Exception {
        ArrayList<String> list = new ArrayList<>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM students");
        while (rs.next()) {
            list.add(
                rs.getInt("id") + " - " + 
                rs.getString("name") + " (" + 
                rs.getInt("age") + ")"
            );
        }
        return list;
    }

}
