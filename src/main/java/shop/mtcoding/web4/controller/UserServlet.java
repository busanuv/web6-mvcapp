package shop.mtcoding.web4.controller;

import shop.mtcoding.web4.model.FakeDAO;
import shop.mtcoding.web4.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User u1 = new FakeDAO().userData();

        String html = "<html>\n" +
                "<head>\n" +
                "    <title>Model 1</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>유저</h1>\n" +
                "<hr/>\n" +
                "<h3>번호 : "+u1.getId()+"</h3>\n" +
                "<h3>유저명 : "+u1.getUsername()+"</h3>\n" +
                "<h3>비밀번호 : "+u1.getPassword()+"</h3>\n" +
                "</body>\n" +
                "</html>";

        resp.setStatus(200);
        resp.setContentType("text/html; charset=utf-8"); // content-type 설정
        resp.getWriter().println(html);  // 응답 버퍼에 쓰기
    }
}
