package service;

import dao.UserDao;
import dbo.User;

public class UserService {

    private UserDao dao = new UserDao();

    public User getUser(int id) {
        return dao.findById(id);
    }

    public void saveUser(User user) {
        dao.save(user);
    }
}
