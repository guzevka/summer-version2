package ru.summerversion2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.summerversion2.models.User;
import ru.summerversion2.services.UserService;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public String index(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByEmail(auth.getName());
        model.addAttribute("user", user);
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "security/login";
    }

    @PostMapping("/login")
    public String ok(){
        return "redirect:/";
    }

    @GetMapping("/registration")
    public String registration(){
        return "security/registration";
    }

    @PostMapping("/registration")
    public String createUser(User user){
        userService.createUser(user);
        return "redirect:/login";
    }

    @GetMapping("/profile")
    // 1. только авторизованный пользователь может зайти на свой профиль
    // 2. доступ разрешен только известным пользователям, которые зашли в систему
    @Secured({"IS_AUTHENTICATED_FULLY", "IS_AUTHENTICATED_REMEMBERED"})
    public String profile(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByEmail(auth.getName());
        model.addAttribute("user", user);
        return "users/profile";
    }

//    @GetMapping("/user/{user}")
//    public String userInfo(@PathVariable("user") User user, Model model){
//        model.addAttribute("user", user);
//        return "user-info";
//    }

}
