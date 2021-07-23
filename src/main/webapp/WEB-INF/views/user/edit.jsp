<%--
  Created by IntelliJ IDEA.
  User: xyz
  Date: 16.07.2021
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/app/header.jsp" %>
<c:if test="${not empty editSuccess}">
    <div class="alert alert-dismissible alert-success">
        <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        <strong>${editSuccess}</strong>
    </div>
</c:if>
<div class="container">
    <br><br>


    <div class="accordion" id="accordionExample">
        <div class="accordion-item">
            <h2 class="accordion-header" id="headingOne" >
                <button class="accordion-button bg-secondary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                    <spring:message code="user.passwordChange"/>
                </button>
            </h2>
            <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample" style="">
                <div class="accordion-body">
                    <form:form method="post" modelAttribute="userDto">
                        <div style="display: flex; justify-content: center">
                            <label><spring:message code="user.passwordNew"/>: <br>
                                <form:password path="password"/> </label></div>
                        <form:errors path="password" cssClass="error"/>
                        <div style="display: flex; justify-content: center"><label>
                            <spring:message
                                code="user.passwordRepeat"/>: <br><input
                                type="password" name="passwordConfirm"/> </label></div>
                        <p class=error>${errorPassword}</p>
                        <br>
                        <div style="display: flex; justify-content: center">
                            <input type="submit" value="<spring:message code="user.passwordSave"/>"/>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
        <div class="accordion-item">
            <h2 class="accordion-header" id="headingTwo">
                <button class="accordion-button collapsed bg-secondary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                    <spring:message code="user.delete"/>
                </button>
            </h2>
            <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample" style="">
                <div class="accordion-body">
                    <div style="display: flex; justify-content: center"><spring:message code="delete.message"/></div>
                    <br>
                    <div class="d-grid gap-2">
                        <a href="/user/delete" class="btn btn-lg btn-danger"><spring:message code="user.deleteButton"/></a>
                    </div>
                </div>
            </div>
        </div>

    </div>


</div>


<%@include file="/WEB-INF/views/app/footer.jsp" %>