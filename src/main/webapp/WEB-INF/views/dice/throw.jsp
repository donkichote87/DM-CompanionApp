<%--
  Created by IntelliJ IDEA.
  User: xyz
  Date: 25.07.2021
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/app/header.jsp" %>
<br><br>
<div class="container">
    <div class="row">
        <div class="col-sm-2">
    <div class="card text-white bg-secondary mb-3" style="max-width: 8rem;">
        <div class="card-header"><spring:message code="dice.cardName"/></div>
        <div class="card-body">
            <form:form method="post" modelAttribute="diceRoll">
                <div><label><spring:message code="dice.k4"/><br><form:select path="k4"><form:options items="${range}"/></form:select></label></div>
                <div><label><spring:message code="dice.k6"/><br><form:select path="k6"><form:options items="${range}"/></form:select></label></div>
                <div><label><spring:message code="dice.k8"/><br><form:select path="k8"><form:options items="${range}"/></form:select></label></div>
                <div><label><spring:message code="dice.k10"/><br><form:select path="k10"><form:options items="${range}"/></form:select></label></div>
                <div><label><spring:message code="dice.k12"/><br><form:select path="k12"><form:options items="${range}"/></form:select></label></div>
                <div><label><spring:message code="dice.k20"/><br><form:select path="k20"><form:options items="${range}"/></form:select></label></div>
                <br>
                <input type="submit" class="btn-info" value="<spring:message code="dice.throw"/>">
            </form:form>
        </div>
    </div>
        </div>
    <div class="col-sm-10">
    <c:if test="${not empty k4 || not empty k6 || not empty k8 || not empty k10 || not empty k12 || not empty k20}">
    <div class="card text-white bg-secondary mb-3" style="max-width: 36rem;">
        <div class="card-header"><spring:message code="dice.results"/></div>
        <div class="card-body">
            <spring:message code="dice.k4"/>:
            <br>
            <c:forEach var="die" items="${k4}">
                <img src="/images/k4/k4_${die}.png" alt="${die} " width="50px"/>
            </c:forEach>
            <br>
            <spring:message code="dice.k6"/>:
            <br>
            <c:forEach var="die" items="${k6}">
                <img src="/images/k6/k6_${die}.png" alt="${die} " width="50px"/>
            </c:forEach>
            <br>
            <spring:message code="dice.k8"/>:
            <br>
            <c:forEach var="die" items="${k8}">
                <img src="/images/k8/k8_${die}.png" alt="${die} " width="50px"/>
            </c:forEach>
            <br>
            <spring:message code="dice.k10"/>:
            <br>
            <c:forEach var="die" items="${k10}">
                <img src="/images/k10/k10_${die}.png" alt="${die} " width="50px"/>
            </c:forEach>
            <br>
            <spring:message code="dice.k12"/>:
            <br>
            <c:forEach var="die" items="${k12}">
                <img src="/images/k12/k12_${die}.png" alt="${die} " width="50px"/>
            </c:forEach>
            <br>
            <spring:message code="dice.k20"/>:
            <br>
            <c:forEach var="die" items="${k20}">
                <img src="/images/k20/k20_${die}.png" alt="${die} " width="50px"/>
            </c:forEach>
        </div>
    </div>
    </c:if>
</div>
</div>

<%@include file="/WEB-INF/views/app/footer.jsp" %>