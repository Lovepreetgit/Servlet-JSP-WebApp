// LoginServlet.java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        String user = req.getParameter("username");
        String pass = req.getParameter("password");
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        if ("admin".equals(user) && "password".equals(pass)) {
            out.println("<h1>Welcome, " + user + "!</h1>");
        } else {
            out.println("<h1>Login Failed. Invalid credentials.</h1>");
        }
    }
}
