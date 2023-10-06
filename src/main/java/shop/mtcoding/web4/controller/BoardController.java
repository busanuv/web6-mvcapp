package shop.mtcoding.web4.controller;


import shop.mtcoding.web4.core.ViewResolver;
import shop.mtcoding.web4.model.Board;
import shop.mtcoding.web4.model.BoardRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class BoardController {
    private BoardRepository boardRepository;

    public BoardController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public String list(HttpServletRequest request){
        System.out.println("list : 요청됨");
        List<Board> boardList = boardRepository.findAll();
        request.setAttribute("boardList", boardList);
        return ViewResolver.resolve("/board/list");
    }

    public String saveForm(){
        System.out.println("saveForm : 요청됨");
        return ViewResolver.resolve("/board/saveForm");
    }

    public String save(String title, String content, int userId){
        System.out.println("save : 요청됨");
        boardRepository.save(title, content, userId);
        return "/board/list.do";
    }
}
