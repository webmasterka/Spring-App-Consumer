package com.springappconsumer;


import com.springappconsumer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    //@Qualifier("javaClientUserService")
    @Qualifier("webClientUserService")
    private UserService userService;

    @GetMapping
    public String showHome(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "home";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") Long id, Model model) {
        try {
            User user = userService.showUser(id);
            model.addAttribute("selectedUser", user);
        } catch (ResponseStatusException ex) {}
        model.addAttribute("users", userService.getUsers());
        return "home";
    }

    @PostMapping
    public String addUser(User user, Model model) {
        userService.addUser(user);
        model.addAttribute("users", userService.getUsers());
        return "home";
    }

    @GetMapping("/delete/{userId}")
    public String removeUser(@PathVariable("userId") Long id, Model model){
        userService.removeUser(id);
        model.addAttribute("users", userService.getUsers());
        return "home";
    }
}

