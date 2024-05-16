<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="data.dto.Project1Dto" %>
<%@ page import="data.dao.Project1Dao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int uploadSize = 1024 * 1024 * 5;
    ServletContext context = config.getServletContext();
    String folder = context.getRealPath("/save");
    System.out.println("realFolder="+ folder);//실제 업로드되는 save 폴더의 경로

    MultipartRequest multi = null;

    try {

        multi = new MultipartRequest(request, folder, uploadSize, "utf-8", new DefaultFileRenamePolicy());

        String title=multi.getParameter("title");
        String content=multi.getParameter("content");
        String upload=multi.getFilesystemName("upload");
        String rating = multi.getParameter("rating");

        Project1Dto dto = new Project1Dto();

        dto.setTitle(title);
        dto.setContent(content);
        dto.setUploadPhoto(upload);
        dto.setRating(Integer.parseInt(rating));


        Project1Dao dao = new Project1Dao();
        dao.insertMemo(dto);
        response.sendRedirect("review.jsp");
    }catch (Exception e){%>
        <script>
            alert("업로드 오류 : " + e.getMessage());
        </script>
    <%}
%>