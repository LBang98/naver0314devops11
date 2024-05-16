package board.servlet;

import data.dao.SimpleBoardDao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/updatechu")
public class UpdateChuServlet extends HttpServlet {
    SimpleBoardDao dao = new SimpleBoardDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //num을 읽기
        int num = Integer.parseInt(request.getParameter("num"));

        //dao의 chu update
        dao.updateChu(num);

        //update된 chu값 얻기
        int chu = dao.getData(num).getChu();

        //json 형식으로 문자열을 만든다
        String s = "{\"num\":" + chu + "}";

        //request에 담기
        request.setAttribute("s", s);

        //jsonchu.jsp 로 포워드
        RequestDispatcher rd = request.getRequestDispatcher("../day0514/jsonchu.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

}