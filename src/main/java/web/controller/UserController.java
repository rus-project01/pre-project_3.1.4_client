package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(HttpServletRequest httpServletRequest, ModelMap model) {
        return "hello";
    }
}
