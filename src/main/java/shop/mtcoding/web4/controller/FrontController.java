package shop.mtcoding.web4.controller;

import shop.mtcoding.web4.model.Board;
import shop.mtcoding.web4.model.FakeDAO;
import shop.mtcoding.web4.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("*.do")
public class FrontController extends HttpServlet {

    // 1. 비지니스 로직 가져와서 request에 저장해서 sendRedirect 해보고 RequestDispatcher로 변경해보기 (302 안됨)
    // 2. WEB-INF/views로 경로 이동 시켜서 - 직접 요청해보기 (요청불가)
    // 3. RequestDispatcher로 요청해보기 (요청가능) - request도 유지가능
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String httpMethod = req.getMethod();
        if(httpMethod.equals("POST")){
            resp.setContentType("text/html; charset=utf-8");
            PrintWriter pw = resp.getWriter();
            pw.println("잘못된 요청입니다");
            return;
        }

        String action = req.getRequestURI();
        System.out.println("uri : "+action);

        if(action.equals("/board.do")){
            Board b1 = new FakeDAO().boardData();
            req.setAttribute("b1", b1);
            RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/views/board.jsp");
            dispatcher.forward(req, resp);
        }else if(action.equals("/user.do")){
            User u1 = new FakeDAO().userData();
            req.setAttribute("u1", u1);
            RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/views/user.jsp");
            dispatcher.forward(req, resp);
        }else{
            resp.setContentType("text/html; charset=utf-8");
            PrintWriter pw = resp.getWriter();
            pw.println("잘못된 요청입니다");
        }
    }
}
