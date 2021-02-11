package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.UserService;


@Controller
@RequestMapping(value = "/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/show_users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "show_users";
    }
}
