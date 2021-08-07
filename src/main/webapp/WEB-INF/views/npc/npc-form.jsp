<%--
  Created by IntelliJ IDEA.
  User: xyz
  Date: 27.07.2021
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/app/header.jsp" %>
<c:set var="url" value="${requestScope['javax.servlet.forward.request_uri']}"/>
<br><br>
<div class="container">
    <div class="card text-white bg-secondary mb-3">
        <div class="card-header"><spring:message code="char.npc"/></div>
        <div class="card-body">
            <form:form method="post" modelAttribute="npc">
                <form:hidden path="id"/>
                <form:hidden path="user"/>
                <div class="row">
                    <div class="col-sm">
                        <div style="display: flex; justify-content: start">
                            <label>
                                <spring:message code="char.name"/>:
                                <br>
                                <form:input path="name"/>
                                <br>
                                <form:errors path="name" cssClass="error"/>
                            </label>
                        </div>
                    </div>
                    <div class="col-sm">
                        <div style="display: flex; justify-content: start">
                            <label>
                                <spring:message code="char.sex"/>:
                                <br>
                                <form:select path="sex">
                                    <form:option value="-"><spring:message code="form.chooseOne"/></form:option>
                                    <form:option value="M"><spring:message code="char.male"/></form:option>
                                    <form:option value="F"><spring:message code="char.female"/></form:option>
                                </form:select>
                                <br>
                                <form:errors path="sex" cssClass="error"/>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm">
                        <div style="display: flex; justify-content: start">
                            <label>
                                <spring:message code="char.race"/>:
                                <br>
                                <form:input path="race"/>
                                <br>
                                <form:errors path="race" cssClass="error"/>
                            </label>
                        </div>
                    </div>
                    <div class="col-sm">
                        <div style="display: flex; justify-content: start">
                            <label>
                                <spring:message code="char.occupation"/>:
                                <br>
                                <form:input path="occupation"/>
                                <br>
                                <form:errors path="occupation" cssClass="error"/>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm">
                        <spring:message code="char.history"/>:
                        <br>
                        <form:textarea path="history" rows="2" cols="50"/>
                    </div>
                    <div class="col-sm">
                        <spring:message code="char.appearance"/>:
                        <br>
                        <form:textarea path="appearance" rows="2" cols="50"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm">
                        <spring:message code="char.abilities"/>:
                        <br>
                        <form:textarea path="abilities" rows="2" cols="50"/>
                    </div>
                    <div class="col-sm">
                        <spring:message code="char.talent"/>:
                        <br>
                        <form:textarea path="talent" rows="2" cols="50"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm">
                        <spring:message code="char.mannerism"/>:
                        <br>
                        <form:textarea path="mannerism" rows="2" cols="50"/>
                    </div>
                    <div class="col-sm">
                        <spring:message code="char.interaction"/>:
                        <br>
                        <form:textarea path="interaction" rows="2" cols="50"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm">
                        <spring:message code="char.usefulKnowledge"/>:
                        <br>
                        <form:textarea path="usefulKnowledge" rows="2" cols="50"/>
                    </div>
                    <div class="col-sm">
                        <spring:message code="char.bond"/>:
                        <br>
                        <form:textarea path="bond" rows="2" cols="50"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm">
                        <spring:message code="char.ideal"/>:
                        <br>
                        <form:textarea path="ideal" rows="2" cols="50"/>
                    </div>
                    <div class="col-sm">
                        <spring:message code="char.flawOrSecret"/>:
                        <br>
                        <form:textarea path="flawOrSecret" rows="2" cols="50"/>
                    </div>
                </div>
                <br>
                    <c:if test="${(fn:contains(url, 'random'))}">
                        <div class="row">
                        <div><a href="/npc/random" class="btn btn-lg btn-info" style="width: 100%"><spring:message
                                code="char.random"/></a></div>
                        </div>
                        <br>
                    </c:if>
                <div class="row">
                    <div><button class="btn btn-lg btn-info" type="submit" style="width: 100%"><spring:message
                            code="form.save"/></button></div>
                </div>
                    <br>
                <div class="row">
                    <div><a href="/npc/list" class="btn btn-lg btn-info" type="button" style="width: 100%"><spring:message
                            code="char.list"/></a></div>
                </div>
            </form:form>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/app/footer.jsp" %>