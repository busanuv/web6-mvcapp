package shop.mtcoding.web4.model;

import lombok.Getter;

@Getter
public class Board {
    private int id;
    private String title;
    private String content;
    private int userId;

    public Board(int id, String title, String content, int userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }
}
