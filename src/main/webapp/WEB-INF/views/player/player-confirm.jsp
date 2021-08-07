<%--
  Created by IntelliJ IDEA.
  User: xyz
  Date: 06.08.2021
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/app/header.jsp" %>
<br><br>
<div class="container" style="display: flex; justify-content: center">
  <div class="card text-white bg-secondary mb-3" style="width: 40rem;">
    <div class="card-header" style="display: flex; justify-content: center"><spring:message code="confirm.confirm"/></div>
    <div class="card-body">
      <p style="display: flex; justify-content: center"><spring:message code="player.delete"/> ${player.name}?</p>
      <br>
      <div style="display: flex; justify-content: space-evenly; justify-items: center">
        <a href="/player/delete/${player.id}" class="btn btn-info"><spring:message code="confirm.yes"/></a>
        <a href="/player/list" class="btn btn-info"><spring:message code="confirm.no"/></a>
      </div>
    </div>
  </div>
</div>

<%@include file="/WEB-INF/views/app/footer.jsp" %>
