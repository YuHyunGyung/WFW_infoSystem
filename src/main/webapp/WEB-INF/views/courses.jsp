<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Courses</title>
</head>
<body>
    <c:forEach var="course" items="${id_courses}" >
        <p> <c:out value="${course}"> </c:out> </p>
    </c:forEach>
</body>
</html>
