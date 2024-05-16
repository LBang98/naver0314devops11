<%@ page import="data.dao.Project1Dao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");

    int num = Integer.parseInt(request.getParameter("num"));

    Project1Dao dao = new Project1Dao();
    dao.delCart(num);

    // 장바구니 페이지로 리다이렉트
    response.sendRedirect("cart.jsp");
%>
