package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@MultipartConfig
@WebServlet(name = "SignUp", urlPatterns = {"/SignUp"})
public class SignUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setHeader("Access-Control-Allow-Origin", "*");

        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String gender = request.getParameter("gender");
        String mobile = request.getParameter("mobile");
        String city = request.getParameter("city");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (fname.isEmpty()) {
            response.getWriter().write("Please Enter the First Name.");
        } else if (lname.isEmpty()) {
            response.getWriter().write("Please Enter the Last Name.");
        } else if (gender == null || gender.isEmpty()) {
            response.getWriter().write("Please Select the Gender.");
        } else if (mobile.isEmpty()) {
            response.getWriter().write("Please Enter the Mobile Number.");
        } else if (city.isEmpty()) {
            response.getWriter().write("Please Select the City.");
        } else if (email.isEmpty()) {
            response.getWriter().write("Please Enter the Email Address.");
        } else if (password.isEmpty()) {
            response.getWriter().write("Please Enter the Password.");
        } else {
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/web2_db1?useSSL=false", "root", "Kaush@20036230");

                c.createStatement().executeUpdate("INSERT INTO `user`(`fname`,`lname`,`gender`,`mobile`,`city`,`email`,`password`)"
                        + " VALUES('" + fname + "','" + lname + "','" + gender + "','" + mobile + "','" + city + "','" + email + "','" + password + "')");

                response.getWriter().write("success");

            } catch (Exception e) {
                response.getWriter().write("Database Connection Error.");
            }
        }

    }

}

