package org.ardlema.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.ardlema.model.User;
import org.ardlema.services.LoginService;

public class Login extends ActionSupport {

    private LoginService loginService;
    private String password;
    private String username;

    public String execute() throws Exception {
        User user = new User(getUsername(), getPassword());

        if (!loginService.isValidUser(user)) return INPUT;

        return SUCCESS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

}