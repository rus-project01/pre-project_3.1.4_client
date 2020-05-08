package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import web.model.Role;
import web.model.User;

import java.lang.reflect.Array;
import java.util.*;

@Service
public class UserServiceTemplateImpl implements UserServiceTemplate {

    RestTemplate restTemplate;

    public UserServiceTemplateImpl(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.basicAuthentication("ADMIN", "ADMIN").build();
    }

    @Override
    public List<User> getUser() {
        return restTemplate.getForObject("http://localhost:8081/admin/getListUsers", List.class);
    }

    @Override
    public User findUserByName(String s) {
        ResponseEntity<User> obj = restTemplate.getForEntity("http://localhost:8081/admin/userFindByName/" + s, User.class);
        return obj.getBody();
    }

    @Override
    public Role findRole(String s) {
        ResponseEntity<Role> obj = restTemplate.getForEntity("http://localhost:8081/admin/roleFindByName/" + s, Role.class);
        return obj.getBody();
    }

    @Override
    public void addUs(User user) {
        restTemplate.postForObject("http://localhost:8081/admin/add", user, User.class);
    }

    @Override
    public void deleteUser(User user) {
        restTemplate.getForObject("http://localhost:8081/admin/userDelete/" + user.getId(), User.class);
    }

    @Override
    public void updateUser(User user) {
        restTemplate.postForObject("http://localhost:8081/admin/editInUsers", user, User.class);
    }

    @Override
    public User findUser(User user) {
        ResponseEntity<User> obj = restTemplate.postForEntity("http://localhost:8081/admin/userFindToUs/", user, User.class);
        return obj.getBody();
    }

}
