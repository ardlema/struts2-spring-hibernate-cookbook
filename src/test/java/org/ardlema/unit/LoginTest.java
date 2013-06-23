package org.ardlema.unit;

import org.ardlema.actions.Login;
import org.ardlema.model.User;
import org.ardlema.services.LoginService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Map;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginTest extends ConfigTest {

    Login login = new Login();

    @Mock
    LoginService mockLoginService;

    @Before
    public void setup() {
        login.setLoginService(mockLoginService);
    }

    @Test
    public void testLoginOKSubmit() throws Exception {
        login.setUsername("alberto");
        login.setPassword("12345");
        when(mockLoginService.isValidUser(any(User.class))).thenReturn(true);
        String result = login.execute();
        assertSuccess(result);
    }

    @Test
    public void testLoginUserNameNOKSubmit() throws Exception {
        login.setUsername("paquito");
        login.setPassword("12345");
        when(mockLoginService.isValidUser(any(User.class))).thenReturn(false);
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
