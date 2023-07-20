package ru.summerversion2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.summerversion2.models.Role;
import ru.summerversion2.models.User;
import ru.summerversion2.services.UserService;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
public class AdminController {
    private final UserService userService;
    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("users", userService.list());
        return "admin/index";
    }
    @PostMapping("/admin/user/ban/{id}")
    public String userBan(@PathVariable("id") Long id){
        userService.banUser(id);
        return "redirect:/admin";
    }
    @GetMapping("/user/{user}")
    public String userInfo(@PathVariable("user") User user, Model model){
        model.addAttribute("user", user);
        return "admin/info-about-users";
    }
}
