package org.ardlema.unit;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.config.entities.ActionConfig;
import org.ardlema.actions.Login;

import java.util.Map;

public class LoginTest extends ConfigTest {

    public void testLoginOKSubmit() throws Exception {
        Login login = new Login();
        login.setUsername("alberto");
        login.setPassword("12345");
        String result = login.execute();
        assertSuccess(result);
    }

    public void testLoginUserNameNOKSubmit() throws Exception {
        Login login = new Login();
        login.setUsername("paquito");
        login.setPassword("12345");
        String result = login.execute();
        assertInput(result);
    }

    public void testPasswordNOKSubmit() throws Exception {
        Login login = new Login();
        login.setUsername("alberto");
        login.setPassword("45678");
        String result = login.execute();
        assertInput(result);
    }

    // Needs access to an envinronment that includes validators
    public void FIXME_testLoginSubmitInput() throws Exception {
        Login login = new Login();
        String result = login.execute();
        assertInput(result);
        Map errors = assertFieldErrors(login);
        assertFieldError(errors,"username","Username is required.");
        assertFieldError(errors,"password","Password is required.");
    }

}
