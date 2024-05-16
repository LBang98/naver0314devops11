<%@ page import="data.dto.Project1Dto" %>
<%@ page import="data.dao.Project1Dao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");

    String itemName = request.getParameter("itemName");
    int itemPrice = Integer.parseInt(request.getParameter("itemPrice"));

    Project1Dto dto = new Project1Dto();
    dto.setItemName(itemName);
    dto.setItemPrice(itemPrice);

    Project1Dao dao = new Project1Dao();
    dao.addCart(dto);

    response.sendRedirect("allmenu.jsp");

%>