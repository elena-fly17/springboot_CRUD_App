package com.elenamukhina.springboot.springboot_CRUD_App.controller;

import com.elenamukhina.springboot.springboot_CRUD_App.entity.User;
import com.elenamukhina.springboot.springboot_CRUD_App.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "list_of_users";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model model) {
        model.addAttribute("user", new User());
        return "form_for_user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/user/list";
    }

    @GetMapping("/updateForm/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "form_for_user";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable (value = "id") int id) {
        userService.deleteUser(id);
        return "redirect:/user/list";
    }
}
