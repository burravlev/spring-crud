package org.buravlev.web.controller;

import org.buravlev.web.model.User;
import org.buravlev.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired()
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String users(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        System.out.println(userService.getAllUsers());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/save")
    public String saveUser(User user, Model model) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("title", "Update " + user.getName());
        model.addAttribute("user", user);
        return "update";
    }

    @PatchMapping("/update")
    public String update(User user) {
        userService.update(user);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }
}