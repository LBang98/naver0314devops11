<%@ page import="data.dto.GuestDto" %>
<%@ page import="data.dao.GuestDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
    GuestDto dto = new GuestDto();
    dto.setNickname(request.getParameter("nickname"));
    dto.setAvata(request.getParameter("avata"));
    dto.setContent(request.getParameter("content"));

    GuestDao dao = new GuestDao();
    dao.insertGuest(dto);

%>