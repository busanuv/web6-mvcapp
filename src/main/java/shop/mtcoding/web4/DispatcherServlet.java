package shop.mtcoding.web4;


import shop.mtcoding.web4.controller.BoardController;
import shop.mtcoding.web4.controller.UserController;
import shop.mtcoding.web4.model.BoardRepository;
import shop.mtcoding.web4.model.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// GET -> http://localhost:8080/board/list.do
// GET -> http://localhost:8080/board/saveForm.do
// POST -> http://localhost:8080/board/save.do

// GET -> http://localhost:8080/user/saveForm.do
// POST -> http://localhost:8080/user/save.do

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        /**
         * http://localhost:8080/board/list.do
         * path = board
         * action = list
         */
        String path = getPath(req);
        String action = getAction(req);

        BoardRepository boardRepository = new BoardRepository();
        BoardController boardController = new BoardController(boardRepository);

        UserRepository userRepository = new UserRepository();
        UserController userController = new UserController(userRepository);

        if (path.equals("board")) {
            switch (action) {
                case "saveForm":
                    String saveFormView = boardController.saveForm();
                    req.getRequestDispatcher(saveFormView).forward(req, resp);
                    break;
                case "save":
                    String method = req.getMethod();
                    if(!method.equals("POST")){
                        resp.setContentType("text/html; charset=utf-8");
                        resp.getWriter().println("POST로 요청해야 합니다");
                        break;
                    }
                    String title = req.getParameter("title");
                    String content = req.getParameter("content");
                    int userId = Integer.parseInt(req.getParameter("userId"));
                    String saveRedirect = boardController.save(title, content, userId);
                    resp.sendRedirect(saveRedirect);
                    break;
                case "list":
                    String listView = boardController.list(req);
                    req.getRequestDispatcher(listView).forward(req, resp);
                    break;
                default:
                    resp.sendRedirect("/board/list.do");
            }
        }else if(path.equals("user")) {
            switch (action) {
                case "saveForm":
                    String saveFormView = userController.saveForm();
                    req.getRequestDispatcher(saveFormView).forward(req, resp);
                    break;
                default:
                    resp.sendRedirect("/board/list.do");
            }
        }
    }

    private String getPath(HttpServletRequest req) {
        String path = getUri(req).split("/")[0];
        System.out.println("path : " + path);
        return path;
    }

    private String getAction(HttpServletRequest req) {
        String action = getUri(req).split("/")[1];
        action = action.replace(".do", "");
        System.out.println("action : "+action);
        return action;
    }

    private String getUri(HttpServletRequest req) {
        String uri = req.getRequestURI();
        System.out.println("getUri : "+uri);
        uri = uri.substring(1);
        System.out.println("uri : "+uri);
        return uri;
    }
}
