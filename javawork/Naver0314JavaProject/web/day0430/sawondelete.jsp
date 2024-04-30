<%@ page import="data.dao.SawonDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int num = Integer.parseInt(request.getParameter("num"));
    //dao 선언
    SawonDao dao = new SawonDao();

    dao.deleteSawon(num);

    response.sendRedirect("sawonlist.jsp");
%>