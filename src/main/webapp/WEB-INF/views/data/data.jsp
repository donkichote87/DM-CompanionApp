<%--
  Created by IntelliJ IDEA.
  User: xyz
  Date: 04.08.2021
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/app/header.jsp" %>
<br><br>
<div class="container">
    <div class="card text-white bg-secondary mb-3">
        <div class="card-header"><spring:message code="data.data"/></div>
        <div class="card-body">
            <table class="table" style="width: 100%">
                <colgroup>
                    <col span="1" style="width: 33%">
                    <col span="1" style="width: 33%">
                    <col span="1" style="width: 33%">
                </colgroup>
                <thead>
                <tr>
                    <th scope="col"><spring:message code="data.dataKind"/></th>
                    <th><spring:message code="data.dataCount"/></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row"><spring:message code="data.firstName"/></th>
                        <th scope="row">${firstNamesCount}</th>
                        <td>
                            <a href="/admin/data/first-name" class="btn btn-info btn-sm"><spring:message
                                    code="list.details"/></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row"><spring:message code="data.lastName"/></th>
                        <th scope="row">${lastNamesCount}</th>
                        <td>
                            <a href="/admin/data/last-name" class="btn btn-info btn-sm"><spring:message
                                    code="list.details"/></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row"><spring:message code="data.race"/></th>
                        <th scope="row">${racesCount}</th>
                        <td>
                            <a href="/admin/data/race" class="btn btn-info btn-sm"><spring:message
                                    code="list.details"/></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row"><spring:message code="player.class"/></th>
                        <th scope="row">${classesCount}</th>
                        <td>
                            <a href="/admin/data/class" class="btn btn-info btn-sm"><spring:message
                                    code="list.details"/></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row"><spring:message code="player.background"/></th>
                        <th scope="row">${backgroundsCount}</th>
                        <td>
                            <a href="/admin/data/background" class="btn btn-info btn-sm"><spring:message
                                    code="list.details"/></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row"><spring:message code="char.occupation"/></th>
                        <th scope="row">${occupationsCount}</th>
                        <td>
                            <a href="/admin/data/occupation" class="btn btn-info btn-sm"><spring:message
                                    code="list.details"/></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row"><spring:message code="char.appearance"/></th>
                        <th scope="row">${appearancesCount}</th>
                        <td>
                            <a href="/admin/data/appearance" class="btn btn-info btn-sm"><spring:message
                                    code="list.details"/></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row"><spring:message code="char.talent"/></th>
                        <th scope="row">${talentsCount}</th>
                        <td>
                            <a href="/admin/data/talent" class="btn btn-info btn-sm"><spring:message
                                    code="list.details"/></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row"><spring:message code="char.mannerism"/></th>
                        <th scope="row">${mannerismsCount}</th>
                        <td>
                            <a href="/admin/data/mannerism" class="btn btn-info btn-sm"><spring:message
                                    code="list.details"/></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row"><spring:message code="char.interaction"/></th>
                        <th scope="row">${interactionsCount}</th>
                        <td>
                            <a href="/admin/data/interaction" class="btn btn-info btn-sm"><spring:message
                                    code="list.details"/></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row"><spring:message code="char.bond"/></th>
                        <th scope="row">${bondsCount}</th>
                        <td>
                            <a href="/admin/data/bond" class="btn btn-info btn-sm"><spring:message
                                    code="list.details"/></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row"><spring:message code="char.flawOrSecret"/></th>
                        <th scope="row">${flawsOrSecretsCount}</th>
                        <td>
                            <a href="/admin/data/flaw-or-secret" class="btn btn-info btn-sm"><spring:message
                                    code="list.details"/></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row"><spring:message code="char.abilities"/></th>
                        <th scope="row">${abilitiesCount}</th>
                        <td>
                            <a href="/admin/data/ability" class="btn btn-info btn-sm"><spring:message
                                    code="list.details"/></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row"><spring:message code="char.alignment"/></th>
                        <th scope="row">${alignmentsCount}</th>
                        <td>
                            <a href="/admin/data/alignment" class="btn btn-info btn-sm"><spring:message
                                    code="list.details"/></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row"><spring:message code="char.ideal"/></th>
                        <th scope="row">${idealsCount}</th>
                        <td>
                            <a href="/admin/data/ideal" class="btn btn-info btn-sm"><spring:message
                                    code="list.details"/></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row"><spring:message code="char.usefulKnowledge"/></th>
                        <th scope="row">${usefulKnowledgeCount}</th>
                        <td>
                            <a href="/admin/data/useful-knowledge" class="btn btn-info btn-sm"><spring:message
                                    code="list.details"/></a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<br><br>
<%@include file="/WEB-INF/views/app/footer.jsp" %>