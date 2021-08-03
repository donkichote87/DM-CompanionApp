<%--
  Created by IntelliJ IDEA.
  User: xyz
  Date: 31.07.2021
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/app/header.jsp" %>
<br><br>
<div class="container">
    <c:if test="${not empty Success}">
        <div class="alert alert-dismissible alert-success">
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
            <strong>${Success}</strong>
        </div>
    </c:if>
    <div class="row">
        <div class="col-sm-6">
            <h2><spring:message code="admin.welcome"/></h2>
        </div>
        <div class="col-sm-6" style="margin-left: auto">
            <div class="card text-white bg-secondary mb-3">
                <div class="card-body">
                    <h4><spring:message code="admin.usersCount"/>: ${users.size()}</h4>
                </div>
            </div>
        </div>
    </div>
    <br><br>
    <div class="row">
        <div class="card text-white bg-secondary mb-3">
            <div class="card-header"><spring:message code="admin.userList"/></div>
            <div class="card-body">
                <table class="table table-hover" style="width: 100%">
                    <colgroup>
                        <col span="1" style="width: 21%;">
                        <col span="1" style="width: 26%;">
                        <col span="1" style="width: 16%;">
                        <col span="1" style="width: 5%;">
                        <col span="1" style="width: 5%;">
                        <col span="1" style="width: 27%;">
                    </colgroup>
                    <thead>
                    <tr>
                        <th scope="col"><spring:message code="user.name"/></th>
                        <th scope="col"><spring:message code="user.email"/></th>
                        <th scope="col"><spring:message code="user.role"/></th>
                        <th scope="col"><spring:message code="dashboard.npc"/></th>
                        <th scope="col"><spring:message code="dashboard.players"/></th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="user" items="${users}">
                        <tr>
                            <th scope="row">${user.username}</th>
                            <td>${user.email}</td>
                            <td>
                                <c:choose><c:when test="${fn:contains(user.role.id, '2')}"><spring:message
                                        code="user.roleAdmin"/></c:when><c:otherwise><spring:message
                                        code="user.roleUser"/></c:otherwise></c:choose>
                            </td>
                            <td>${npcService.findNpcsByUserId(user.id).size()}</td>
                            <td>
                                    <%--                takie samo jak wyżej tylko dla graczy--%>
                            </td>
                            <td>
                                <a href="/admin/role/${user.id}" class="btn btn-info btn-sm"><spring:message
                                        code="admin.roleChange"/></a>
                                <a href="/admin/confirm/${user.id}" class="btn btn-info btn-sm"><spring:message
                                        code="admin.blockUser"/></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/app/footer.jsp" %>