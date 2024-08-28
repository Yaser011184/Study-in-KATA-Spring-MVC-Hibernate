package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/")
    public String showAll(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }


    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";

    }

    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "updateUser";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") int id) {
        this.userService.deleteUserById(id);
        return "redirect:/";
    }


}
