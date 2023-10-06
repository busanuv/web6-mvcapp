package shop.mtcoding.web4.core;


import shop.mtcoding.web4.model.Board;
import shop.mtcoding.web4.model.User;

import java.util.ArrayList;
import java.util.List;


public class DB {
    private static List<Board> boardList = new ArrayList<>();
    private static List<User> userList = new ArrayList<>();

    static {
        boardList.add(new Board(1, "제목 ", "내용", 1));
        boardList.add(new Board(2, "제목 ", "내용", 1));
        boardList.add(new Board(3, "제목 ", "내용", 1));
        boardList.add(new Board(4, "제목 ", "내용", 2));
    }

    public static List<Board> boardSelectAll(){
        return boardList;
    }

    public static void boardInsert(String title, String content, int userId){
        int id = boardList.size()+1;
        boardList.add(new Board(id, title, content, userId));
    }

    public static void userInsert(String username, String password){
        int id = userList.size()+1;
        userList.add(new User(id, username, password));
    }
}
