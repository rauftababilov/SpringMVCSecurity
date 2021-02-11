package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/users")
    public String allUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "/users";
    }

    @GetMapping(value = "/add")
    public String addUser(Model model) {
        model.addAttribute("allRoles", userService.getAllRoles());
        User user = new User();
        model.addAttribute("user", user);
        return "add_user";
    }

    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/edit/{id}")
    public String editUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("allRoles", userService.getAllRoles());
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit_user";
    }

    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String deleteUserById(@RequestParam("id") Long id) {
        userService.removeUser(id);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "/show";
    }
}
