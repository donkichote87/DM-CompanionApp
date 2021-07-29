<%--
  Created by IntelliJ IDEA.
  User: xyz
  Date: 28.07.2021
  Time: 22:21
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
    <div class="card text-white bg-secondary mb-3">
        <div class="card-header"><spring:message code="char.listNpc"/></div>
        <div class="card-body">
            <table class="table table-hover" style="width: 100%">
                <colgroup>
                    <col span="1" style="width: 21%;">
                    <col span="1" style="width: 21%;">
                    <col span="1" style="width: 21%;">
                    <col span="1" style="width: 21%;">
                    <col span="1" style="width: 16%;">
                </colgroup>
                <thead>
                <tr>
                    <th scope="col"><spring:message code="char.name"/></th>
                    <th scope="col"><spring:message code="char.sex"/></th>
                    <th scope="col"><spring:message code="char.race"/></th>
                    <th scope="col"><spring:message code="char.occupation"/></th>
                    <th><a href="/npc/create" class="btn btn-danger btn-sm"><spring:message code="char.add"/></a></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="npc" items="${npcs}">
                    <tr>
                        <th scope="row">${npc.name}</th>
                        <td><c:choose><c:when test="${fn:contains(npc.sex, 'M')}"><spring:message
                                code="char.male"/></c:when><c:otherwise><spring:message
                                code="char.female"/></c:otherwise></c:choose></td>
                        <td>${npc.race}</td>
                        <td>${npc.occupation}</td>
                        <td>
                            <a href="/npc/view/${npc.id}" class="btn btn-success btn-sm"><spring:message code="list.view"/></a>
                            <a href="/npc/edit/${npc.id}" class="btn btn-info btn-sm"><spring:message code="list.edit"/></a>
                            <a href="/npc/confirm/${npc.id}" class="btn btn-warning btn-sm"><spring:message code="list.delete"/></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/app/footer.jsp" %>