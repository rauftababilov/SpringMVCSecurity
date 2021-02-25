package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
@RequestMapping(value = "/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("showUser")
    public String showUserForm(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "user/show_user";
    }

    @GetMapping("usersList")
    public String userList(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "user/users_list";
    }
}
