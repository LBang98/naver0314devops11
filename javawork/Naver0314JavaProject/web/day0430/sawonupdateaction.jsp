<%@ page import="data.dto.SawonDto" %>
<%@ page import="data.dao.SawonDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="dto" class="data.dto.SawonDto"/>
<jsp:useBean id="dao" class="data.dao.SawonDao"/>

<jsp:setProperty name="dto" property="*"/>
<%
    dao.updateSawon(dto);

    response.sendRedirect("sawonlist.jsp");
%>