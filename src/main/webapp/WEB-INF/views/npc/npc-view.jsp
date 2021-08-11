<%--
  Created by IntelliJ IDEA.
  User: xyz
  Date: 31.07.2021
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/app/header.jsp" %>
<br><br>
<div class="container">
    <div class="card text-white bg-secondary mb-3">
        <div class="card-header"><spring:message code="char.npc"/></div>
        <div class="card-body">
            <div class="row">
                <div class="col-sm">
                    <div style="display: flex; justify-content: start">
                        <label>
                            <spring:message code="char.name"/>:
                            <br>
                            <p style="color: black">${npc.name}</p>
                        </label>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <div style="display: flex; justify-content: start">
                        <label>
                            <spring:message code="char.alignment"/>:
                            <br>
                            <p style="color: black">${npc.alignment}</p>
                        </label>
                    </div>
                </div>
                <div class="col-sm">
                    <div style="display: flex; justify-content: start">
                        <label>
                            <spring:message code="char.sex"/>:
                            <br>
                            <p style="color: black">
                                ${npc.sex.equals('M') ? 'Mężczyzna' : 'Kobieta'}
                            </p>
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
                            <p style="color: black">${npc.race}</p>
                        </label>
                    </div>
                </div>
                <div class="col-sm">
                    <div style="display: flex; justify-content: start">
                        <label>
                            <spring:message code="char.occupation"/>:
                            <br>
                            <p style="color: black">${npc.occupation}</p>
                        </label>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <spring:message code="char.history"/>:
                    <br>
                    <p style="color: black">${npc.history}</p>
                </div>
                <div class="col-sm">
                    <spring:message code="char.appearance"/>:
                    <br>
                    <p style="color: black">${npc.appearance}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <spring:message code="char.abilities"/>:
                    <br>
                    <p style="color: black">${npc.abilities}</p>
                </div>
                <div class="col-sm">
                    <spring:message code="char.talent"/>:
                    <br>
                    <p style="color: black">${npc.talent}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <spring:message code="char.mannerism"/>:
                    <br>
                    <p style="color: black">${npc.mannerism}</p>
                </div>
                <div class="col-sm">
                    <spring:message code="char.interaction"/>:
                    <br>
                    <p style="color: black">${npc.interaction}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <spring:message code="char.usefulKnowledge"/>:
                    <br>
                    <p style="color: black">${npc.usefulKnowledge}</p>
                </div>
                <div class="col-sm">
                    <spring:message code="char.bond"/>:
                    <br>
                    <p style="color: black">${npc.bond}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <spring:message code="char.ideal"/>:
                    <br>
                    <p style="color: black">${npc.ideal}</p>
                </div>
                <div class="col-sm">
                    <spring:message code="char.flawOrSecret"/>:
                    <br>
                    <p style="color: black">${npc.flawOrSecret}</p>
                </div>
            </div>
            <br>
            <div class="row">

                <a href="/npc/list" class="btn btn-lg btn-info" type="submit"><spring:message
                        code="char.list"/></a>

            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/app/footer.jsp" %>