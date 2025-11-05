// AttendanceServlet.java
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/AttendanceServlet")
public class AttendanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        String studentID = req.getParameter("studentID");
        String date = req.getParameter("date");
        String status = req.getParameter("status");
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");

        String url = "jdbc:mysql://your-db-host/your-db";
        String user = "dbuser";
        String pass = "dbpass";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = con.prepareStatement("INSERT INTO Attendance(StudentID, Date, Status) VALUES (?, ?, ?)");
            ps.setString(1, studentID);
            ps.setString(2, date);
            ps.setString(3, status);
            int result = ps.executeUpdate();
            if (result > 0) {
                out.println("<h2>Attendance saved successfully!</h2>");
            } else {
                out.println("<h2>Error saving attendance!</h2>");
            }
            ps.close();
            con.close();
        } catch(Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
