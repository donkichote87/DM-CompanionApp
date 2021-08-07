<%--
  Created by IntelliJ IDEA.
  User: xyz
  Date: 06.08.2021
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/views/app/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="url" value="${requestScope['javax.servlet.forward.request_uri']}"/>
<br><br>
<div class="container">
    <div class="card text-white bg-secondary mb-3">
        <div class="card-header"><spring:message code="player.player"/></div>
        <div class="card-body">
            <form:form method="post" modelAttribute="player">
                <form:hidden path="id"/>
                <form:hidden path="user"/>
                <div class="row">
                    <div class="col-sm">
                        <div style="display: flex; justify-content: start">
                            <label>
                                <spring:message code="char.name"/>:
                                <br>
                                <p style="color: black">${player.name}</p>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm">
                        <div style="display: flex; justify-content: start">
                            <label>
                                <spring:message code="char.sex"/>:
                                <br>
                                <p style="color: black">
                                        ${player.sex.equals('M') ? 'Mężczyzna' : 'Kobieta'}
                                </p>
                            </label>
                        </div>
                    </div>
                    <div class="col-sm">
                        <div style="display: flex; justify-content: start">
                            <label>
                                <spring:message code="char.race"/>:
                                <br>
                                <p style="color: black">${player.race.subRace}</p>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm">
                        <div style="display: flex; justify-content: start">
                            <label>
                                <spring:message code="player.class"/>:
                                <br>
                                <p style="color: black">${player.characterClass.name}</p>
                            </label>
                        </div>
                    </div>
                    <div class="col-sm">
                        <div style="display: flex; justify-content: start">
                            <label>
                                <spring:message code="player.background"/>:
                                <br>
                                <p style="color: black">${player.background.name}</p>
                            </label>
                        </div>
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-sm">
                        <spring:message code="player.strength"/>:
                        <br>
                        <p style="color: black">${player.strengthAbility}</p>
                    </div>
                    <div class="col-sm">
                        <spring:message code="player.condition"/>:
                        <br>
                        <p style="color: black">${player.conditionAbility}</p>
                    </div>
                    <div class="col-sm">
                        <spring:message code="player.wisdom"/>:
                        <br>
                        <p style="color: black">${player.wisdomAbility}</p>
                    </div>
                    <div class="col-sm">
                        <spring:message code="player.hp"/>:
                        <br>
                        <p style="color: black">${player.hp}</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm">
                        <spring:message code="player.dexterity"/>:
                        <br>
                        <p style="color: black">${player.dexterityAbility}</p>
                    </div>
                    <div class="col-sm">
                        <spring:message code="player.intelligence"/>:
                        <br>
                        <p style="color: black">${player.intelligenceAbility}</p>
                    </div>
                    <div class="col-sm">
                        <spring:message code="player.charisma"/>:
                        <br>
                        <p style="color: black">${player.charismaAbility}</p>
                    </div>
                    <div class="col-sm">
                        <spring:message code="player.hpDice"/>:
                        <br>
                        <p style="color: black">${player.hpDice}</p>
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-sm">
                        <spring:message code="player.skills"/>:
                        <br>
                        <p style="color: black">${player.skills}</p>
                    </div>
                    <div class="col-sm">
                        <spring:message code="player.proficienciesAndLanguages"/>:
                        <br>
                        <p style="color: black">${player.proficienciesAndLanguages}</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm">
                        <spring:message code="player.equipment"/>:
                        <br>
                        <p style="color: black">${player.equipment}</p>
                    </div>
                    <div class="col-sm">
                        <spring:message code="player.featuresAndTraits"/>:
                        <br>
                        <p style="color: black">${player.featuresAndTraits}</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm">
                        <spring:message code="player.ideals"/>:
                        <br>
                        <p style="color: black">${player.ideal}</p>
                    </div>
                    <div class="col-sm">
                        <spring:message code="player.flaws"/>:
                        <br>
                        <p style="color: black">${player.flaw}</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm">
                        <spring:message code="player.bonds"/>:
                        <br>
                        <p style="color: black">${player.bond}</p>
                    </div>
                    <div class="col-sm">
                        <spring:message code="player.personalityTraits"/>:
                        <br>
                        <p style="color: black">${player.personalityTraits}</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm">
                        <spring:message code="char.history"/>:
                        <br>
                        <p style="color: black">${player.history}</p>
                    </div>
                </div>

                <br>
                <div class="row">
                    <div><a href="/player/list" class="btn btn-lg btn-info" type="button"
                            style="width: 100%"><spring:message
                            code="char.list"/></a></div>
                </div>
            </form:form>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/app/footer.jsp" %>