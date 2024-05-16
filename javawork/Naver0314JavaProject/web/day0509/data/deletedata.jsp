<%@ page import="data.dao.GuestDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int num = Integer.parseInt(request.getParameter("num"));
    GuestDao dao = new GuestDao();
    dao.deleteGuest(num);
%>