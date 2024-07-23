package org.example.controller;


import org.example.entity.User;
import org.example.service.UserService;
import org.example.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequestMapping("/")
@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
@GetMapping("/")
    public String getUsers(Model model){
        List<User> usersList = userService.getUsers();
        model.addAttribute("users", usersList);
        return "index";
    }
    @GetMapping("/add")
    public String createUserForm(@ModelAttribute("user") User user) {
        return "add";
    }
    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }
    @GetMapping("/edit")
    public String getEditUserForm(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }
    @GetMapping("/deleteUser")
    public String removeUser(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }
}
