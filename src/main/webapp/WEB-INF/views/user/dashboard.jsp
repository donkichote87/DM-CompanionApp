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

    <h2><spring:message code="dashboard.welcome"/> ${username}</h2>
    <div class="row">
        <div class="col-sm-3">
            <div class="card text-white bg-secondary mb-3">
                <div class="card-body">
                    <div><a href="/npc/create" style="width: 100%" type="button"
                            class="btn btn-info btn-lg"><spring:message code="dashboard.newNpc"/></a></div>
                    <br>
                    <div><a href="/player/create" style="width: 100%" type="button"
                            class="btn btn-info btn-lg"><spring:message code="dashboard.newPlayer"/></a></div>
                </div>
            </div>
        </div>

        <div class="col-sm-6" style="margin-left: auto">
            <div class="card text-white bg-secondary mb-3">
                <div class="card-body">
                    <h4><spring:message code="dashboard.npcCount"/>: ${npcCount}</h4>
                </div>
            </div>
            <div class="card text-white bg-secondary mb-3">
                <div class="card-body">
                    <h4><spring:message code="dashboard.playerCount"/>: ${playerCount}</h4>
                </div>
            </div>
        </div>
    </div>
    <br><br>
    <div class="row">
        <div class="card text-white bg-secondary mb-3">
            <div class="card-header"><spring:message code="dashboard.lastNpc"/></div>
            <div class="card-body">
                <table class="table table-hover" style="width: 100%">
                    <colgroup>
                        <col span="1" style="width: 20%;">
                        <col span="1" style="width: 20%;">
                        <col span="1" style="width: 20%;">
                        <col span="1" style="width: 20%;">
                        <col span="1" style="width: 20%;">
                    </colgroup>
                    <thead>
                    <tr>
                        <th scope="col"><spring:message code="char.name"/></th>
                        <th scope="col"><spring:message code="char.sex"/></th>
                        <th scope="col"><spring:message code="char.race"/></th>
                        <th scope="col"><spring:message code="char.occupation"/></th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty lastNpc}">
                        <tr>
                            <th scope="row">${lastNpc.name}</th>
                            <td><c:choose><c:when test="${fn:contains(lastNpc.sex, 'M')}"><spring:message
                                    code="char.male"/></c:when><c:otherwise><spring:message
                                    code="char.female"/></c:otherwise></c:choose></td>
                            <td>${lastNpc.race}</td>
                            <td>${lastNpc.occupation}</td>
                            <td>
                                <a href="/npc/view/${lastNpc.id}" class="btn btn-info btn-sm"><spring:message
                                        code="list.view"/></a>
                            </td>
                        </tr>
                    </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="card text-white bg-secondary mb-3">
            <div class="card-header"><spring:message code="dashboard.lastPlayer"/></div>
            <div class="card-body">
                <table class="table table-hover" style="width: 100%">
                    <colgroup>
                        <col span="1" style="width: 20%;">
                        <col span="1" style="width: 20%;">
                        <col span="1" style="width: 20%;">
                        <col span="1" style="width: 20%;">
                        <col span="1" style="width: 20%;">
                    </colgroup>
                    <thead>
                    <tr>
                        <th scope="col"><spring:message code="char.name"/></th>
                        <th scope="col"><spring:message code="char.sex"/></th>
                        <th scope="col"><spring:message code="char.race"/></th>
                        <th scope="col"><spring:message code="player.class"/></th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty lastPlayer}">
                        <tr>
                            <th scope="row">${lastPlayer.name}</th>
                            <td><c:choose><c:when test="${fn:contains(lastPlayer.sex, 'M')}"><spring:message
                                    code="char.male"/></c:when><c:otherwise><spring:message
                                    code="char.female"/></c:otherwise></c:choose></td>
                            <td>${lastPlayer.race.subRace}</td>
                            <td>${lastPlayer.characterClass.name}</td>
                            <td>
                                <a href="/player/view/${lastPlayer.id}" class="btn btn-info btn-sm"><spring:message
                                        code="list.view"/></a>
                            </td>
                        </tr>
                    </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<br><br>
<%@include file="/WEB-INF/views/app/footer.jsp" %>