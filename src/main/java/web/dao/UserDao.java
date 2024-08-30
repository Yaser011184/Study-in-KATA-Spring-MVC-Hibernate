package web.dao;

import web.model.User;
import java.util.List;

public interface UserDao {

     List<User> getUsers();

     User findUserById(Integer id);

     void save(User user);

     void update(User user);

    void deleteUserById(Integer id);
}


