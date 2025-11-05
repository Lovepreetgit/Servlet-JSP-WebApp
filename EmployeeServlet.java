// EmployeeServlet.java
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        String empID = req.getParameter("empID");

        // Replace with your own DB config
        String url = "jdbc:mysql://your-db-host/your-db";
        String user = "dbuser";
        String pass = "dbpass";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            if (empID != null && !empID.isEmpty()) {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM Employee WHERE EmpID=?");
                ps.setString(1, empID);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    out.println("<table border='1'><tr><th>EmpID</th><th>Name</th><th>Salary</th></tr>");
                    out.println("<tr><td>"+rs.getString("EmpID")+"</td><td>"+rs.getString("Name")+"</td><td>"+rs.getString("Salary")+"</td></tr>");
                    out.println("</table>");
                } else {
                    out.println("No employee found!");
                }
                rs.close();
                ps.close();
            } else {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM Employee");
                out.println("<table border='1'><tr><th>EmpID</th><th>Name</th><th>Salary</th></tr>");
                while (rs.next()) {
                    out.println("<tr><td>"+rs.getString("EmpID")+"</td><td>"+rs.getString("Name")+"</td><td>"+rs.getString("Salary")+"</td></tr>");
                }
                out.println("</table>");
                rs.close();
                st.close();
            }
            con.close();
        } catch(Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
