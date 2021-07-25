<%--
  Created by IntelliJ IDEA.
  User: xyz
  Date: 24.07.2021
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/app/header.jsp" %>
<br><br>

<div class="container">
    <h1 style="color: white"><img src="/images/kostki.png"><spring:message code="page.name"/></h1>
    <br><br>
    <h2><spring:message code="navbar.about"/>:</h2>
    <p style="text-align: justify"><spring:message code="page.aboutText"/></p>
    <br><br>
    <h2><spring:message code="page.author"/>:</h2>
    <p style="text-align: justify"><spring:message code="page.authorText"/></p>
</div>

<%@include file="/WEB-INF/views/app/footer.jsp" %>
