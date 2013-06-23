package org.ardlema.services;

import org.ardlema.dao.UserDao;
import org.ardlema.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LoginServiceImpl
  implements LoginService {

    private UserDao userDao;

    /*public boolean isValidUser(User user) {
        boolean valid = false;
        if (user.getUserName().equals("alberto")
                && user.getPassword().equals("12345")){
            valid = true;
        }
        return valid;
    }*/

    public boolean isValidUser(User user) {
        List users = userDao.findAll();
        return users.size()>0;
    }


    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }




}
