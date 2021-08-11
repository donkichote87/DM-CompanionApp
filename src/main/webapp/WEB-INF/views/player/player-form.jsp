<%--
  Created by IntelliJ IDEA.
  User: xyz
  Date: 06.08.2021
  Time: 18:46
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
                                <form:input path="name"/>
                                <br>
                                <form:errors path="name" cssClass="error"/>
                            </label>
                        </div>
                    </div>
                    <div class="col-sm">
                        <div style="display: flex; justify-content: start">
                            <label>
                                <spring:message code="char.alignment"/>:
                                <br>
                                <form:select path="alignment">
                                    <form:option value="${null}"><spring:message code="form.chooseOne"/></form:option>
                                    <form:options items="${alignments}" itemLabel="nature" itemValue="nature"/>
                                </form:select>
                                <br>
                                <form:errors path="alignment" cssClass="error"/>
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
                                <form:select path="sex">
                                    <form:option value="0"><spring:message code="form.chooseOne"/></form:option>
                                    <form:option value="M"><spring:message code="char.male"/></form:option>
                                    <form:option value="F"><spring:message code="char.female"/></form:option>
                                </form:select>
                                <br>
                                <form:errors path="sex" cssClass="error"/>
                            </label>
                        </div>
                    </div>
                    <div class="col-sm">
                        <div style="display: flex; justify-content: start">
                            <label>
                                <spring:message code="char.race"/>:
                                <br>
                                <form:select path="race">
                                    <form:option value="${null}"><spring:message code="form.chooseOne"/></form:option>
                                    <form:options items="${races}" itemLabel="subRace" itemValue="id"/>
                                </form:select>
                                <br>
                                <form:errors path="race" cssClass="error"/>
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
                                <form:select path="characterClass">
                                    <form:option value="${null}"><spring:message code="form.chooseOne"/></form:option>
                                    <form:options items="${characterClasses}" itemLabel="name" itemValue="id"/>
                                </form:select>
                                <br>
                                <form:errors path="characterClass" cssClass="error"/>
                            </label>
                        </div>
                    </div>
                    <div class="col-sm">
                        <div style="display: flex; justify-content: start">
                            <label>
                                <spring:message code="player.background"/>:
                                <br>
                                <form:select path="background">
                                    <form:option value="${null}"><spring:message code="form.chooseOne"/></form:option>
                                    <form:options items="${backgrounds}" itemLabel="name" itemValue="id"/>
                                </form:select>
                                <br>
                                <form:errors path="background" cssClass="error"/>
                            </label>
                        </div>
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-sm">
                        <spring:message code="player.strength"/>:
                        <br>
                        <form:input path="strengthAbility"></form:input>
                        <br>
                        <form:errors path="strengthAbility" cssClass="error"/>
                    </div>
                    <div class="col-sm">
                        <spring:message code="player.condition"/>:
                        <br>
                        <form:input path="conditionAbility"></form:input>
                        <br>
                        <form:errors path="conditionAbility" cssClass="error"/>
                    </div>
                    <div class="col-sm">
                        <spring:message code="player.wisdom"/>:
                        <br>
                        <form:input path="wisdomAbility"></form:input>
                        <br>
                        <form:errors path="wisdomAbility" cssClass="error"/>
                    </div>
                    <div class="col-sm">
                        <spring:message code="player.hp"/>:
                        <br>
                        <form:input path="hp"></form:input>
                        <br>
                        <form:errors path="hp" cssClass="error"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm">
                        <spring:message code="player.dexterity"/>:
                        <br>
                        <form:input path="dexterityAbility"></form:input>
                        <br>
                        <form:errors path="dexterityAbility" cssClass="error"/>
                    </div>
                    <div class="col-sm">
                        <spring:message code="player.intelligence"/>:
                        <br>
                        <form:input path="intelligenceAbility"></form:input>
                        <br>
                        <form:errors path="intelligenceAbility" cssClass="error"/>
                    </div>
                    <div class="col-sm">
                        <spring:message code="player.charisma"/>:
                        <br>
                        <form:input path="charismaAbility"></form:input>
                        <br>
                        <form:errors path="charismaAbility" cssClass="error"/>
                    </div>
                    <div class="col-sm">
                        <spring:message code="player.hpDice"/>:
                        <br>
                        <form:input path="hpDice"></form:input>
                        <br>
                        <form:errors path="hpDice" cssClass="error"/>
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-sm">
                        <spring:message code="player.skills"/>:
                        <br>
                        <form:textarea path="skills" rows="2" cols="50"/>
                    </div>
                    <div class="col-sm">
                        <spring:message code="player.proficienciesAndLanguages"/>:
                        <br>
                        <form:textarea path="proficienciesAndLanguages" rows="2" cols="50"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm">
                        <spring:message code="player.equipment"/>:
                        <br>
                        <form:textarea path="equipment" rows="2" cols="50"/>
                    </div>
                    <div class="col-sm">
                        <spring:message code="player.featuresAndTraits"/>:
                        <br>
                        <form:textarea path="featuresAndTraits" rows="2" cols="50"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm">
                        <spring:message code="player.ideals"/>:
                        <br>
                        <form:textarea path="ideal" rows="2" cols="50"/>
                    </div>
                    <div class="col-sm">
                        <spring:message code="player.flaws"/>:
                        <br>
                        <form:textarea path="flaw" rows="2" cols="50"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm">
                        <spring:message code="player.bonds"/>:
                        <br>
                        <form:textarea path="bond" rows="2" cols="50"/>
                    </div>
                    <div class="col-sm">
                        <spring:message code="player.personalityTraits"/>:
                        <br>
                        <form:textarea path="personalityTraits" rows="2" cols="50"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm">
                        <spring:message code="char.history"/>:
                        <br>
                        <form:textarea path="history" rows="2" cols="50"/>
                    </div>
                </div>

                <br>
                <div class="row">
                    <div>
                        <button class="btn btn-lg btn-info" type="submit" style="width: 100%"><spring:message
                                code="form.save"/></button>
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