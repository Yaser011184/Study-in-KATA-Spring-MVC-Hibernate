package web.service;

import web.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    void save(User user);

    User findUserById(Integer id);

    void update(User user);

    void deleteUserById(Integer id);

    List<User> getUsers();
}
