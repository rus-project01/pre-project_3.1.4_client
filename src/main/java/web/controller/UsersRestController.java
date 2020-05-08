package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserServiceTemplate;
import web.service.UserServiceTemplateImpl;

import java.util.List;

@RestController
public class UsersRestController {

    @Autowired
    UserServiceTemplate userServiceTemplate;

    @PostMapping(value = "/admin/addUser")
    public void addUser(@RequestBody User user) {
        userServiceTemplate.addUs(user);
    }

    @GetMapping(value = "/admin/getUsers")
    public List<User> listUsers() {
        return userServiceTemplate.getUser();
    }

    @PostMapping(value = "/admin/editUser")
    public void editUser(@RequestBody User user) {
        userServiceTemplate.updateUser(user);
    }

    @PostMapping(value = "/admin/deleted")
    public void delUser(@RequestBody User user)  {
        userServiceTemplate.deleteUser(user);
    }

    @PostMapping(value = "/admin/findUser")
    public User findUser(@RequestBody User user)  {
        return userServiceTemplate.findUser(user);
    }

}
