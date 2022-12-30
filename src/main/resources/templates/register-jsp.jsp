<%@ page import="com.example.weekseventask.models.User" %><%--
  Created by IntelliJ IDEA.
  User: Austin
  Date: 30/10/2022
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/account.css">
    <link href="https://fonts.googleapis.com/css?family=Rubik" rel="stylesheet">
    <title>Sign Up</title>
</head>
<body>
<main>
    <section class="container-account">
        <div class="account-col1">
            <h1 class="account-title">Facebook</h1>
            <p>This is where fun is birthed! Make sure you are satisfied!</p>
        </div>
        <div class="account-col2">
            <div class="account-box">
                <input type="hidden" id="statusreg" value="<%=request.getSession().getAttribute("status")%>">
                <input type="hidden" id="errorreg" value="<%=request.getSession().getAttribute("error")%>">
                <form method="post" action="UserRegistrationServlet" class="registration-form">
                    <% session.removeAttribute("status");%>
                    <fieldset>

                        <formgroup class="formgoup">

                            <input type="text" name="firstname" class="input-name" id="firstname" placeholder="First Name" required>

                            <input type="text" name="lastname" class="input-name" id="lastname" placeholder="Last Name" required>

                        </formgroup>

                        <input type="email" name="email" class="input-fields" id="email" placeholder="Email address" required>

                        <formgroup class="formgoup input-fields">
                            <span>
                                <label for="male" class="radio-label" style="text-align: center">Male</label>
                                <input type="radio" name="sex" class="radio" id="male" value="male" placeholder="Male">
                            </span>

                            <span>
                                <label for="female" class="radio-label">Female</label>
                                <input type="radio" name="sex" class="radio" id="female" value="female" placeholder="Female">
                            </span>


                        </formgroup>

                            <label for="dob" class="input-group">Date of Birth</label>

                            <input type="date" name="dob" class="input-fields" id="dob" placeholder="Date of birth">

                            <input type="password" name="password" class="input-fields" id="password" placeholder="Password" required>

                            <input type="password" name="confirmpassword" class="input-fields" id="confirmpassword" placeholder="Confirm password" required>

                            <div class="btn">
                                <button type="submit" class="btn--blue submit" name="submit" value="signup">Sign up</button>
                            </div>

<%--                        <input type="submit" class="btn--blue submit" name="submit" value="Sign up">--%>

                    </fieldset>

                    <div class="btn-hr">
                    </div>

                    <div class="btn">
                        <a href="${pageContext.request.contextPath}/login.jsp" class="btn--green submit" >Login</a>
                    </div>

                </form>

            </div>

        </div>
    </section>
</main>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="alert/dist/sweetalert.css">

<script type="text/javascript">
    let status = document.getElementById("statusreg").value;
    let errorMessage = document.getElementById("errorreg").value;
    console.log(status);
    console.log(errorMessage);
    if (status == "failure") {
        swal(errorMessage);
    }
</script>

</body>
</html>
