/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.loginRegistration;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@WebServlet("/login")
public class login extends HttpServlet {
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String uemail = request.getParameter("username");
        String upwd = request.getParameter("password");
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;
        
        String url = "jdbc:mysql://localhost:3306/signup?useSSL=false";
        String name = "root";
        String pass = "Mjgwindia@69";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,name,pass);
            PreparedStatement st = con.prepareStatement("select * from users where uemail = ? and upwd = ?");
            st.setString(1, uemail);
            st.setString(2, upwd);
            
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                //session.setAttribute("name", rs.getString("uname"));
                dispatcher = request.getRequestDispatcher("/Allprojects/loginRegistration/Landing page/index.jsp");
            }else{
                request.setAttribute("status", "failed");
                dispatcher = request.getRequestDispatcher("/Allprojects/loginRegistration/Login page/login.jsp");
            }
            dispatcher.forward(request,response);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
