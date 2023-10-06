package shop.mtcoding.web4.model;

import lombok.Getter;


@Getter
public class User {
    private int id;
    private String username;
    private String password;

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
