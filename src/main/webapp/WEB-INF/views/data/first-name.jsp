<%--
  Created by IntelliJ IDEA.
  User: xyz
  Date: 03.08.2021
  Time: 21:07
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
                <div class="card-header"><spring:message code="data.newFirstName"/></div>
                <div class="card-body" >
                    <form:form method="post" modelAttribute="newName" style="display: flex; justify-content: space-around">
                        <form:hidden path="id"/>


                                <label><spring:message code="data.firstName"/>:<form:input path="name"/>
                                </label>

                                <label><spring:message code="data.race"/>:<form:select path="race">
                                        <form:option value="0"><spring:message code="form.chooseOne"/></form:option>
                                        <form:options items="${generalRacesList}"/>
                                    </form:select>
                                </label>

                                <label>
                                    <spring:message code="char.sex"/>:
                                    <form:select path="sex">
                                        <form:option value="-" label="Wybierz"/>
                                        <form:option value="M" label="Mężczyzna"/>
                                        <form:option value="F" label="Kobieta"/>
                                    </form:select>
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
                        <th scope="col"><spring:message code="data.firstName"/></th>
                        <th scope="col"><spring:message code="data.race"/></th>
                        <th scope="col"><spring:message code="char.sex"/></th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="name" items="${names}">
                        <tr>
                            <th scope="row">${name.name}</th>
                            <td>${name.race}</td>
                            <td><c:choose><c:when test="${fn:contains(name.sex, 'M')}"><spring:message
                                    code="char.male"/></c:when><c:otherwise><spring:message
                                    code="char.female"/></c:otherwise></c:choose></td>

                            <td>
                                <a href="/admin/data/first-name/${name.id}" class="btn btn-info btn-sm"><spring:message
                                        code="list.edit"/></a>
                                <a href="/admin/data/first-name/delete/${name.id}" class="btn btn-info btn-sm"><spring:message
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