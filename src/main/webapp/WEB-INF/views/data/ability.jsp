<%--
  Created by IntelliJ IDEA.
  User: xyz
  Date: 10.08.2021
  Time: 23:33
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
        <div class="card-header"><spring:message code="data.newAbility"/></div>
        <div class="card-body" >
          <form:form method="post" modelAttribute="ability" style="display: flex; justify-content: space-around">
            <form:hidden path="id"/>


            <label><spring:message code="data.ability"/> <spring:message code="char.male"/>:<form:input path="descriptionMale"/>
              <form:errors path="descriptionMale" cssClass="error"/>
            </label>

            <label><spring:message code="data.ability"/> <spring:message code="char.female"/>:<form:input path="descriptionFemale"/>
              <form:errors path="descriptionFemale" cssClass="error"/>
            </label>

            <label><spring:message code="data.quality"/>:<form:select path="quality">
              <form:option value="${null}"><spring:message code="form.chooseOne"/></form:option>
              <form:options items="${qualities}"/>
            </form:select>
              <form:errors path="quality" cssClass="error"/>
            </label>

            <label>
              <spring:message code="data.attribute"/>:
              <form:select path="trait">
                <form:option value="${null}"><spring:message code="form.chooseOne"/></form:option>
                <form:options items="${attributes}"/>
              </form:select>
              <form:errors path="trait" cssClass="error"/>
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
      <div class="card-header"><spring:message code="data.firstNameList"/></div>
      <div class="card-body">
        <table class="table table-hover" style="width: 100%">
          <colgroup>
            <col span="1" style="width: 25%">
            <col span="1" style="width: 25%">
            <col span="1" style="width: 25%">
            <col span="1" style="width: 25%">
          </colgroup>
          <thead>
          <tr>
            <th scope="col"><spring:message code="data.ability"/> <spring:message code="char.male"/>/<spring:message code="char.female"/></th>
            <th scope="col"><spring:message code="data.quality"/></th>
            <th scope="col"><spring:message code="data.attribute"/></th>
            <th></th>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="ability" items="${abilities}">
            <tr>
              <th scope="row">${ability.descriptionMale}/${ability.descriptionFemale}</th>
              <td>${ability.quality}</td>
              <td>${ability.trait}</td>
              <td>
                <a href="/admin/data/ability/${ability.id}" class="btn btn-info btn-sm"><spring:message
                        code="list.edit"/></a>
                <a href="/admin/data/ability/delete/${ability.id}" class="btn btn-info btn-sm"><spring:message
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
