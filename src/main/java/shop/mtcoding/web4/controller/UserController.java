package shop.mtcoding.web4.controller;

import shop.mtcoding.web4.core.ViewResolver;
import shop.mtcoding.web4.model.UserRepository;

public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String saveForm(){
        System.out.println("saveForm : 요청됨");
        return ViewResolver.resolve("/user/saveForm");
    }

    public String save(String title, String content, int userId){
        System.out.println("save : 요청됨");
        userRepository.save(title, content);
        return "/board/list.do";
    }
}
