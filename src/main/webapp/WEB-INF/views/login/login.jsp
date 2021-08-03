<%--
  Created by IntelliJ IDEA.
  User: xyz
  Date: 16.07.2021
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/app/header.jsp" %>
<c:if test="${not empty verify}">
    <div class="alert alert-dismissible alert-success">
        <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        <strong>${verify}</strong>
    </div>
</c:if>
<c:if test="${not empty verifySuccess}">
    <div class="alert alert-dismissible alert-success">
        <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        <strong>${verifySuccess}</strong>
    </div>
</c:if>
<c:if test="${not empty verifyFail}">
    <div class="alert alert-dismissible alert-danger">
        <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        <strong>${verifyFail}</strong>
    </div>
</c:if>
<div class="container">
    <div class="row">
        <div class="col-sm">
            <br><br>
            <div class="card text-white bg-secondary mb-3" style="max-width: 20rem;">
                <div class="card-header"><spring:message code="login.login"/></div>
                <div class="card-body">
                    <form method="post" action="login">
                        <div style="display: flex; justify-content: center"><label><spring:message code="user.name"/>:
                            <br><input type="text" name="username"/>
                        </label></div>
                        <div style="display: flex; justify-content: center"><label><spring:message
                                code="user.password"/>: <br><input type="password" name="password"/>
                        </label></div>
                        <c:if test="${not empty param.error}">
                            <p class=error><spring:message code="login.error"/></p>
                        </c:if>
                        <br>
                        <div style="display: flex; justify-content: center"><input type="submit" class="btn-info" value="<spring:message code="login.signIn"/>"/>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-sm">
            <br><br>
            <div class="card text-white bg-secondary mb-3" style="max-width: 20rem;">
                <div class="card-header"><spring:message code="login.register"/></div>
                <div class="card-body">
                    <c:if test="${not empty alreadyExist}">
                        <div class="alert alert-dismissible alert-danger">
                            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                            <strong>${alreadyExist}</strong>
                        </div>
                    </c:if>
                    <form:form method="post" action="register" modelAttribute="user">
                        <div style="display: flex; justify-content: center"><label><spring:message code="user.name"/>:
                            <br><form:input path="username"/>
                        </label></div>
                        <form:errors path="username" cssClass="error"/>
                        <div style="display: flex; justify-content: center"><label><spring:message code="user.email"/>:
                            <br><form:input path="email"/>
                        </label></div>
                        <form:errors path="email" cssClass="error"/>
                        <div style="display: flex; justify-content: center"><label><spring:message
                                code="user.password"/>: <br><form:password
                                path="password"/> </label></div>
                        <form:errors path="password" cssClass="error"/>
                        <div style="display: flex; justify-content: center"><label><spring:message
                                code="user.passwordRepeat"/>: <br><input
                                type="password" name="passwordConfirm"/> </label></div>
                        <p class=error>${errorPassword}</p>

                        <br>
                        <div style="display: flex; justify-content: center"><input type="submit" class="btn-info"  value="<spring:message code="login.signup"/>"/>
                        </div>

                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>


<%@include file="/WEB-INF/views/app/footer.jsp" %>