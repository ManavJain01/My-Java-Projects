
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
  <head>
    <title>Login and Registration</title>
    <link rel="stylesheet" href="./registration.css">
  </head>
  <body>
      <input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
      
        <div class="signUp">
            <form method="post" action="/Myprojects/RegistrationForm" class="signup-section">
                <section class="signup-section1">
                  <h1>Sign up</h1>
                  <input type="text" name="name" placeholder="Your Name">
                  <input type="email" name="email" placeholder="Your Email">
                  <input type="password" name="pass" placeholder="Password">
                  <input type="password" name="re-pass" placeholder="Repeat your password">
                  <input type="text" name="contact" placeholder="Contact no">
                </section>
                <section class="signup-section2">
                  <input type="checkbox">
                  <p>I agree all statements in <span>Terms of service</span></p>
                </section>
                <button class="register-btn">Register</button>
            </form>

            <div class="signup-img-section">
                <img src="./Images/signup-icon.png" class="signup-icon">
                <a href="/Myprojects/Allprojects/loginRegistration/Login page/login.jsp"><p>I am already member</p></a>
            </div>
        </div>

    <script src="./app.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <link rel="stylesheet" href="alert/dist/sweetalert.css">
    <script type="text/javascript">
        var status = document.getElementById("status").value;
        if(status === "success"){
            swal("Congrats","Account Created Successfully","Success");
        }
    </script>
  </body>
</html>

