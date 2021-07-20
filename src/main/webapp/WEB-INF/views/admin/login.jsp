<%--
  Created by IntelliJ IDEA.
  User: xyz
  Date: 16.07.2021
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/app/header.jsp"%>
<div class="container">
    <div class="row">
        <div class="col-sm">
            <br><br>
            <div class="card border-secondary mb-3" style="max-width: 20rem;">
                <div class="card-header">Logowanie</div>
                <div class="card-body">
                    <form method="post">
                        <div style="display: flex; justify-content: center"><label> Login: <br><input type="text" name="username"/> </label></div>
                        <div style="display: flex; justify-content: center"><label> Hasło: <br><input type="password" name="password"/> </label></div>
                        <br>
                        <div style="display: flex; justify-content: center"><input type="submit" value="Zaloguj"/></div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-sm">
            <br><br>
            <div class="card border-secondary mb-3" style="max-width: 20rem;">
                <div class="card-header">Rejestracja</div>
                <div class="card-body">
                    <form method="post">
                        <div style="display: flex; justify-content: center"><label> Login: <br><input type="text" name="username"/> </label></div>
                        <div style="display: flex; justify-content: center"><label> Email: <br><input type="email" name="email"/> </label></div>
                        <div style="display: flex; justify-content: center"><label> Hasło: <br><input type="password" name="password"/> </label></div>
                        <div style="display: flex; justify-content: center"><label> Powtórz Hasło: <br><input type="password" name="password"/> </label></div>
                        <br>
                        <div style="display: flex; justify-content: center"><input type="submit" value="Zaloguj"/></div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>



<%@include file="/WEB-INF/views/app/footer.jsp"%>