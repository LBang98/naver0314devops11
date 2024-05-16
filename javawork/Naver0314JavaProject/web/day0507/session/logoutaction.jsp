<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //loginok 세션 제거
    session.removeAttribute("loginok");
    //메인으로 이동
    response.sendRedirect("sessionmain.jsp");
%>