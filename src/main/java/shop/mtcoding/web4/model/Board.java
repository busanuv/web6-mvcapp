package shop.mtcoding.web4.model;

import lombok.Getter;

@Getter
public class Board {
    private int id;
    private String title;
    private int userId;

    public Board(int id, String title, int userId) {
        this.id = id;
        this.title = title;
        this.userId = userId;
    }
}
