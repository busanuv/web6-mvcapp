package shop.mtcoding.web4.model;


import shop.mtcoding.web4.core.DB;

import java.util.List;

public class BoardRepository {

    public List<Board> findAll(){
        return DB.boardSelectAll();
    }

    public void save(String title, String content, int userId){
        DB.boardInsert(title, content, userId);
    }

}
