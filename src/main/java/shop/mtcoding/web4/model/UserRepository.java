package shop.mtcoding.web4.model;


import shop.mtcoding.web4.core.DB;

import java.util.List;

public class UserRepository {

    public void save(String username, String password){
        DB.userInsert(username, password);
    }

}
