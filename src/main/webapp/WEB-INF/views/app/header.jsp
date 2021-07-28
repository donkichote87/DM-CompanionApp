<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: xyz
  Date: 20.07.2021
  Time: 00:21
  To change this template use File | Settings | File Templates.
--%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>DM-CompanionApp</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-secondary">

        <div class="container-fluid">
            <a href="/" class="navbar-brand">
                <img src="/images/kostki.png" style="width:60px;">
                DM <span>Companion App</span>
            </a>

            <div class="collapse navbar-collapse" id="navbarColor01">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button"
                           aria-haspopup="true" aria-expanded="false"><spring:message code="navbar.profile"/></a>
                        <div class="dropdown-menu">
                            <sec:authorize access="!isAuthenticated()">
                            <a class="dropdown-item" href="/login"><spring:message code="login.login"/>/<spring:message
                                    code="login.register"/></a>
                            <a class="dropdown-item" href="#">
                                </sec:authorize>
                                    <sec:authorize access="isAuthenticated()">
                                    <a class="dropdown-item" href="/login"><spring:message code="navbar.dashboard"/></a>
                                        </sec:authorize>
                                            <sec:authorize access="isAuthenticated()">
                                            <a class="dropdown-item" href="/user/edit"><spring:message code="navbar.edit"/></a>
                                                </sec:authorize>
                                    <sec:authorize access="isAuthenticated()">
                                    <div class="dropdown-divider"></div>
                                    </sec:authorize>
                                                <sec:authorize access="isAuthenticated()">
                                    <form class="dropdown-item" action="<c:url value="/logout"/>" method="post">
                                        <input class="link-button justify-content-start" type="submit" value="Wyloguj">
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    </form>
                                </sec:authorize></a>
                        </div>
                    </li>
                    <sec:authorize access="isAuthenticated()">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button"
                               aria-haspopup="true" aria-expanded="false"><spring:message code="navbar.npc"/></a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="/npc/create"><spring:message code="navbar.new"/></a>
                                <a class="dropdown-item" href="#"><spring:message code="navbar.random"/></a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="/npc/list"><spring:message code="navbar.list"/></a>
                            </div>
                        </li>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button"
                               aria-haspopup="true" aria-expanded="false"><spring:message code="navbar.player"/></a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="#"><spring:message code="navbar.new"/></a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#"><spring:message code="navbar.list"/></a>
                            </div>
                        </li>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button"
                               aria-haspopup="true" aria-expanded="false"><spring:message code="navbar.event"/></a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="#"><spring:message code="navbar.random"/></a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#"><spring:message code="navbar.list"/></a>
                            </div>
                        </li>
                    </sec:authorize>
                    <li class="nav-item">
                        <a class="nav-link" href="/dice"><spring:message code="navbar.diceRoll"/></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/about"><spring:message code="navbar.about"/></a>
                    </li>
                </ul>

            </div>
        </div>
    </nav>
</header>