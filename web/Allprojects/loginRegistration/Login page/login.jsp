<%-- 
    Document   : login
    Created on : 25-Feb-2024, 7:34:15 pm
    Author     : rocke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Login and Registration</title>
    <link rel="stylesheet" href="./login.css">
  </head>
  <body>
    <input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
    
    <div class="signUp">
      <div class="signup-img-section">
        <img src="./Images/signup-icon.png" class="signup-icon">
        <a href="/Myprojects/Allprojects/loginRegistration/Registration page/registration.jsp"><p>Create an account</p></a>
      </div>
      <form method="post" action="/Myprojects/login" class="signup-section">
        <section class="signup-section1">
          <h1>Sign in</h1>
          <input type="text" name="username" placeholder="Your Name">
          <input type="text" name="password" placeholder="Password">
        </section>

        <section class="signup-section2">
          <input type="checkbox">
          <p>Remember me</p>
        </section>

        <button class="login-btn">Log in</button>

        <section class="other-login-methods">
          <p>Or login with</p>
          <img src="./Images/facebook.png">
          <img src="./Images/twitter.png">
          <img src="./Images/google.png">
        </section>
      </form>
    </div>

    <script src="./app.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <link rel="stylesheet" href="alert/dist/sweetalert.css">
    <script type="text/javascript">
        var status = document.getElementById("status").value;
        if(status === "failed"){
            swal("Sorry","Wrong Username or Password","error");
        }
    </script>
  </body>
</html>
