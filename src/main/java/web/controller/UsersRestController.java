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

//    @PostMapping(value = "/admin/editUser")
//    public ResponseEntity<Void> editUser(@RequestBody User user) {
//        user.setRole(roleServiceImpl.findByName(user.getRole().get(0).getName()));
//        userServiceImpl.updateUser(user);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @PostMapping(value = "/admin/deleted")
//    public ResponseEntity<Void> delUser(@RequestBody User user)  {
//        userServiceImpl.deleteUser(user.getId());
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @PostMapping(value = "/admin/findUser")
//    public User findUser(@RequestBody User user)  {
//        return userServiceImpl.findUserById(user.getId());
//    }

}
