package web.service;

import web.model.User;
import java.util.List;

public interface UserService {
    void save(User user);

    User findUserById(int id);

    void update(User user);

    void deleteUserById(int id);

    List<User> getUsers();
}
