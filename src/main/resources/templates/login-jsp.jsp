<%--
  Created by IntelliJ IDEA.
  User: Austin
  Date: 30/10/2022
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/account.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
    <link href="https://fonts.googleapis.com/css?family=Rubik" rel="stylesheet">
    <title>Sign In</title>
</head>
<body>
    <main>
        <input type="hidden" id="status" value="<%=request.getSession().getAttribute("status")%>">
<%--        <input type="hidden" id="status" value="<%=request.getSession().getAttribute("status")%>">--%>

        <section class="container-account">
            <div class="account-col1">
                <% session.removeAttribute("status");%>
                <h1 class="account-title">Facebook</h1>
                <p>Welcome back to our amazing community!</p>
            </div>
            <div class="account-col2">
                <div class="account-box">
                    <form method="post" action="LoginServlet" class="registration-form">

                        <fieldset>

                            <input type="email" name="email" class="input-fields" id="email" placeholder="Email address" required>


                            <input type="password" name="password" class="input-fields" id="password" placeholder="Password" required>

                            <div class="btn">
                                <input type="submit" class="btn--blue submit " name="submit" value="Sign in">
                            </div>

                            <div style="text-align: center">
                                <a href="" style="text-decoration: none"><p>forgot your password?</p></a>
                            </div>

                            <div class="btn-hr">
                            </div>

                            <div class="btn">
                                <a href="${pageContext.request.contextPath}/register.jsp" class="btn--green submit" >Create Account</a>
                            </div>

                            <%--                        <input type="submit" class="btn--blue submit" name="submit" value="Sign up">--%>

                        </fieldset>

                    </form>
                </div>

            </div>
        </section>
    </main>

    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <link rel="stylesheet" href="alert/dist/sweetalert.css">

    <script type="text/javascript">
        let status = document.getElementById("status").value;

        if (status == "failure") {
            swal("Failed to login! Please check your details or create an account if you don't have one");
        }
    </script>
</body>
</html>
