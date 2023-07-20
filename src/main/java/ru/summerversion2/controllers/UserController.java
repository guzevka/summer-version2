package ru.summerversion2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.summerversion2.models.User;
import ru.summerversion2.services.ParticipantService;
import ru.summerversion2.services.TeamService;
import ru.summerversion2.services.UserService;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final ParticipantService participantService;
    private final TeamService teamService;
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
        user.setIdentifier(userService.generateIdentifier());
        userService.createUser(user);
        return "redirect:/login";
    }
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    @GetMapping("/user/find")
    public String findById(Model model){
        return "teams/create";
    }
    @GetMapping("/profile")
    // 1. только авторизованный пользователь может зайти на свой профиль
    // 2. доступ разрешен только известным пользователям, которые зашли в систему
    @Secured({"IS_AUTHENTICATED_FULLY", "IS_AUTHENTICATED_REMEMBERED"})
    public String profile(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByEmail(auth.getName());
        model.addAttribute("user", user);
        if(!(teamService.findByUserId(user.getId()) == null)){
            model.addAttribute("teams", teamService.findByUserId(user.getId()));
            return "users/profile";
        }
        return "users/profile";
    }
    @GetMapping("/other/about")
    public String about(){
        return "other/about";
    }
    @GetMapping("/other/disciplines")
    public String disciplines(){
        return "other/disciplines";
    }
}
