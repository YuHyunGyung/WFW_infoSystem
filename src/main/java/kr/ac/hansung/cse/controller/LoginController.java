package kr.ac.hansung.cse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String showLogin(@RequestParam(value="error", required = false) String error,
                            @RequestParam(value="logout", required = false) String logout,
                            Model model) {
        if(error != null) {
            model.addAttribute("errorMsg", "Invalid username and password");
        }

        if(logout != null) {
            model.addAttribute("logoutMsg", "You have been logged out successfully");
        }

        return "login";
    }

}
