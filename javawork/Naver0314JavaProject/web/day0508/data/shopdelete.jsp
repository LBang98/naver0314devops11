<%@ page import="data.dao.ShopDao" %>
<%@ page contentType="text/html; charset=UTF-8" language="java"  pageEncoding="utf-8" %>
<%
    //shopidx 읽기
    int shopidx = Integer.parseInt(request.getParameter("shopidx"));

    //dao
    ShopDao dao = new ShopDao();

    //delete 메서드 호출
    dao.deleteShop(shopidx);

%>