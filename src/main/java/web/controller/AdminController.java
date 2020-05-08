package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller // /api/user/{id}
@RequestMapping("/admin")
public class AdminController {

    @GetMapping(value = "/")
    public String printUsers(HttpServletRequest httpServletRequest, ModelMap model) {
        return "users";
    }
}
