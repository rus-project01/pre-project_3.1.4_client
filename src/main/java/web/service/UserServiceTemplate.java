package web.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import web.model.Role;
import web.model.User;

import java.util.List;

public interface UserServiceTemplate {
    List<User> getUser();
    User findUserk(String s);
    void addUs(User user);
    Role findRole(String s);
    void deleteUser(User user);
    void updateUser(User user);
}
