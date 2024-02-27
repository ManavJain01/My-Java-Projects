package com.loginRegistration;


import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationForm")
public class RegistrationForm extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String url = "jdbc:mysql://localhost:3306/signup";
        String uname = "root";
        String pass = "Mjgwindia@69";
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Retrieve form data
            try (Connection con = DriverManager.getConnection(url, uname, pass)) {
                // Retrieve form data
                String username = request.getParameter("name");
                String email = request.getParameter("email");
                String password = request.getParameter("pass");
                String contact = request.getParameter("contact");
                try ( 
                    // Prepare the SQL statement
                    PreparedStatement st = con.prepareStatement("INSERT INTO users (uname, upwd, uemail, umobile) VALUES (?, ?, ?, ?)")) {
                    st.setString(1, username);
                    st.setString(2, password);
                    st.setString(3, email);
                    st.setString(4, contact);
                    // Execute the SQL statement
                    int rowCount = st.executeUpdate();
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/Allprojects/loginRegistration/Registration page/registration.jsp");
                    
                    if(rowCount > 0){
                        request.setAttribute("status", "success");          
                    }else{
                        request.setAttribute("status", "failed"); 
                    }
                    
                    // Close PreparedStatement
                    st.close();
                    con.close();
                    
                    dispatcher.forward(request, response);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {}
    }
}
