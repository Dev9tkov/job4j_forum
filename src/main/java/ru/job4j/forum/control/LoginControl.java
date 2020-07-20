package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class LoginControl {

    private UserService userService;

    public LoginControl(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout,
                            Model model) {
        String errorMessge = null;
        if(error != null) {
            errorMessge = "Username or Password is incorrect !!";
        }
        if(logout != null) {
            errorMessge = "You have been successfully logged out !!";
        }
        model.addAttribute("errorMessge", errorMessge);
        return "login";
    }

    @PostMapping("/login")
    public String checkUser(@RequestParam String username,
                            @RequestParam String password,
                            HttpServletRequest request) {
        String redirect = "redirect:/login?error=true";
        User user = new User(username, password);
        if (userService.isExist(user)) {
            request.getSession().setAttribute("user", userService.findByName(username));
            redirect = "redirect:/index";
        }
        return redirect;
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login?logout=true";
    }
}
