package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
@WebServlet(name = "SignIn", urlPatterns = {"/SignIn"})
public class SignIn extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

         response.addHeader("Access-Control-Allow-Origin", "*");
         
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email.isEmpty()) {
            response.getWriter().write("Please Enter the Email Address.");
        } else if (password.isEmpty()) {
            response.getWriter().write("Please Enter the Password.");
        } else {
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/web2_db1?useSSL=false", "root", "Kaush@20036230");

                ResultSet rs = c.createStatement().executeQuery("SELECT * FROM `user` WHERE `email`='" + email + "' AND `password`='" + password + "'");

                if (rs.next()) {
                    response.getWriter().write("success");                   
                } else {
                    response.getWriter().write("Invalid Login Credentials !");
                }

            } catch (Exception e) {
                response.getWriter().write("Database Connection Error.");
            }
        }
    }

}
