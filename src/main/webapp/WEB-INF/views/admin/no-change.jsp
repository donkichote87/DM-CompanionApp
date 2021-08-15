<%--
  Created by IntelliJ IDEA.
  User: xyz
  Date: 02.08.2021
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/app/header.jsp" %>
<br><br>
<div class="container" style="display: flex; justify-content: center">
    <div class="card text-white bg-secondary mb-3" style="width: 40rem;">
        <div class="card-header" style="display: flex; justify-content: center"><spring:message code="confirm.attention"/></div>
        <div class="card-body">
            <p style="display: flex; justify-content: center"><spring:message code="admin.impossible"/></p>
            <br>
            <div style="display: flex; justify-content: space-evenly; justify-items: center">
                <a href="/admin/dashboard" class="btn btn-info"><spring:message code="confirm.adminDashboard"/></a>
            </div>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/app/footer.jsp" %>