package org.ardlema.services;

import org.ardlema.model.User;

public class LoginServiceImpl
  implements LoginService {

    public boolean isValidUser(User user) {
        boolean valid = false;
        if (user.getUserName().equals("alberto")
                && user.getPassword().equals("12345")){
            valid = true;
        }
        return valid;
    }

}
