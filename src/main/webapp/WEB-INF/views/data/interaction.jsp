<%--
  Created by IntelliJ IDEA.
  User: xyz
  Date: 10.08.2021
  Time: 11:27
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

    <div class="col-sm-12">
      <div class="card text-white bg-secondary mb-3">
        <div class="card-header"><spring:message code="data.newInteraction"/></div>
        <div class="card-body" >
          <form:form method="post" modelAttribute="interaction" style="display: flex; justify-content: space-around">
            <form:hidden path="id"/>


            <label><spring:message code="char.interaction"/> <spring:message code="char.male"/>:<form:input path="interactionMale"/>
              <form:errors path="interactionMale" cssClass="error"/>
            </label>

            <label><spring:message code="char.interaction"/> <spring:message code="char.female"/>:<form:input path="interactionFemale"/>
              <form:errors path="interactionFemale" cssClass="error"/>
            </label>

            <label>
              <input type="submit" class="btn-info" value="<spring:message code="form.save"/>"/>
            </label>

          </form:form>
        </div>
      </div>
    </div>
  </div>
  <br><br>
  <div class="row">
    <div class="card text-white bg-secondary mb-3">
      <div class="card-header"><spring:message code="data.interactionList"/></div>
      <div class="card-body">
        <table class="table table-hover" style="width: 100%">
          <colgroup>
            <col span="1" style="width: 33%">
            <col span="1" style="width: 33%">
            <col span="1" style="width: 33%">
          </colgroup>
          <thead>
          <tr>
            <th scope="col"><spring:message code="char.interaction"/> <spring:message code="char.male"/></th>
            <th scope="col"><spring:message code="char.interaction"/> <spring:message code="char.female"/></th>
            <th></th>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="interaction" items="${interactions}">
            <tr>
              <th scope="row">${interaction.interactionMale}</th>
              <td >${interaction.interactionFemale}</td>
              <td>
                <a href="/admin/data/interaction/${interaction.id}" class="btn btn-info btn-sm"><spring:message
                        code="list.edit"/></a>
                <a href="/admin/data/interaction/delete/${interaction.id}" class="btn btn-info btn-sm"><spring:message
                        code="list.delete"/></a>
              </td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>
<br><br>
<%@include file="/WEB-INF/views/app/footer.jsp" %>

