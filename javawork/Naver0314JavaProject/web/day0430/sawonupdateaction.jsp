<%@ page import="data.dto.SawonDto" %>
<%@ page import="data.dao.SawonDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");

    int age = Integer.parseInt(request.getParameter("age"));
    int num = Integer.parseInt(request.getParameter("num"));
    String name = request.getParameter("name");
    String addr = request.getParameter("addr");
    String buseo = request.getParameter("buseo");
    String gender = request.getParameter("gender");
    String photo = request.getParameter("photo");
    String birthday = request.getParameter("birthday");

    //dto
    SawonDto dto = new SawonDto();

    dto.setAge(age);
    dto.setNum(num);
    dto.setName(name);
    dto.setAddr(addr);
    dto.setBuseo(buseo);
    dto.setGender(gender);
    dto.setPhoto(photo);
    dto.setBirthday(birthday);

    //dao
    SawonDao dao = new SawonDao();
    dao.updateSawon(dto);

    response.sendRedirect("sawonlist.jsp");

%>
