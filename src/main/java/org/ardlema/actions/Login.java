package org.ardlema.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.ardlema.model.User;

public class Login extends ActionSupport {

    public String execute() throws Exception {
        User user = new User(getUsername(), getPassword());

        if (isUserInvalid(user)) return INPUT;

        return SUCCESS;
    }

    private boolean isUserInvalid(User user) {
        boolean invalid = false;
        if (!user.getUserName().equals("alberto")
              || !user.getPassword().equals("12345")){
            invalid = true;
        }
        return invalid;
    }

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}