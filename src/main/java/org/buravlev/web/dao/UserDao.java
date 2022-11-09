package org.buravlev.web.dao;

import org.buravlev.web.model.User;
import java.util.List;

public interface UserDao {
    List<User>getAllUsers ();
    User getUserById(int id);
    void save(User user);
    void delete(int id);
    void update(User user);
}