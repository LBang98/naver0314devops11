<%@ page import="data.dao.StudentDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int num = Integer.parseInt(request.getParameter("num"));

    StudentDao dao = new StudentDao();

    dao.deleteStudent(num);

    response.sendRedirect("./list.jsp");
%>