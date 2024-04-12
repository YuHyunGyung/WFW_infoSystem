<%--
  Created by IntelliJ IDEA.
  User: nykim
  Date: 2022/12/13
  Time: 12:55 오전
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Home</title>
  </head>
  <body>

  <c:if test="${pageContext.request.userPrincipal.name == null}">
    <button type="submit" onclick="location.href='${pageContext.request.contextPath}/login'"> Login </button>
  </c:if>

  <c:if test="${pageContext.request.userPrincipal.name != null}">
    <button type="submit"> Logout </button>
  </c:if>
  <form id="logout" action="<c:url value="/logout" />" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
  </form>

  <p><a href="${pageContext.request.contextPath}/courses"> 학년별 이수 학점 조회 </a></p>
  <p><a href="${pageContext.request.contextPath}/createCourse"> 수강 신청하기 </a></p>
  <p><a href="${pageContext.request.contextPath}/courses"> 수강 신청 조회 </a></p>





  </body>
</html>