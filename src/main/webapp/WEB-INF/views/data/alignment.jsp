<%--
  Created by IntelliJ IDEA.
  User: xyz
  Date: 11.08.2021
  Time: 10:17
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
                <div class="card-header"><spring:message code="data.newAlignment"/></div>
                <div class="card-body" >
                    <form:form method="post" modelAttribute="alignment" style="display: flex; justify-content: space-around">
                        <form:hidden path="id"/>


                        <label><spring:message code="char.alignment"/>:<form:input cssStyle="width: 500px" path="nature"/>
                            <form:errors path="nature" cssClass="error"/>
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
            <div class="card-header"><spring:message code="data.alignmentList"/></div>
            <div class="card-body">
                <table class="table table-hover" style="width: 100%">
                    <colgroup>
                        <col span="1" style="width: 70%">
                        <col span="1" style="width: 30%">
                    </colgroup>
                    <thead>
                    <tr>
                        <th scope="col"><spring:message code="char.alignment"/></th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="alignment" items="${alignments}">
                        <tr>
                            <th scope="row">${alignment.nature}</th>
                            <td>
                                <a href="/admin/data/alignment/${alignment.id}" class="btn btn-info btn-sm"><spring:message
                                        code="list.edit"/></a>
                                <a href="/admin/data/alignment/delete/${alignment.id}" class="btn btn-info btn-sm"><spring:message
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