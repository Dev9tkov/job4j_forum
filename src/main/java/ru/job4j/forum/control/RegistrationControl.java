package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;


@Controller
public class RegistrationControl {
    private final UserService userService;

    public RegistrationControl(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/reg")
    public String reg(@RequestParam(required = false) String error,
                      Model model) {
        if (error != null) {
            model.addAttribute("error", "Create User error");
        }
        return "reg";
    }

    @PostMapping("/reg")
    public String reg(@RequestParam String name,
                      @RequestParam String password) {
        String redirect = "redirect:/reg?error=true";
        User user = new User(name, password);
        if (userService.isLoginFree(user.getName())) {
            userService.add(user);
            redirect = "redirect:/login";
        }
        return redirect;
    }
}
