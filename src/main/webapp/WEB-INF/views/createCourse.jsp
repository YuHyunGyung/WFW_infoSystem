<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Course Form</title>
<%--    <script type="text/javascript" src="/WEB-INF/js/createCourse.js" />--%>
</head>

<body>
    <sf:form method="post" action="${pageContext.request.contextPath}/doCreate" modelAttribute="course">
        <table class="formtable">
            <tr>
                <td class="label"> 교과코드: </td>
                <td><sf:input class="control" type="text" path="courseId"/><br/>
                    <sf:errors class="error" path="courseId" />
                </td>
            </tr>

            <tr>
                <td class="label"> 교과목명: </td>
                <td><sf:input class="control" type="text" path="courseName"/><br/>
                    <sf:errors class="error" path="courseName" />
                </td>
            </tr>

            <tr>
                <td class="label"> 교과목명: </td>
                <td><sf:input class="control" type="text" path="courseDiv"/><br/>
                    <sf:errors class="error" path="courseDiv" />
                </td>
            </tr>

            <tr>
                <td class="label"> 담당교수: </td>
                <td><sf:input class="control" type="text" path="prof"/><br/>
                    <sf:errors class="error" path="prof" />
                </td>
            </tr>

            <tr>
                <td class="label"> 학점: </td>
                <td><sf:input class="control" type="text" path="credit"/><br/>
                    <sf:errors class="error" path="credit" />
                </td>
            </tr>

            <tr>
                <td></td>
                <td><input type="submit" value="수강신청" /></td>
            </tr>
        </table>
    </sf:form>
</body>
</html>
