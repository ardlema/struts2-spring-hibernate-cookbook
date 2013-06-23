package org.ardlema.functional;

import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;


public class LoginTestIT
        extends TestCase
{
    private String baseUrl;
    private WebDriver driver;

    public void setUp() throws Exception
    {
        super.setUp();
        String port = System.getProperty("servlet.port");
        this.baseUrl = "http://localhost:" + port + "/cookbook-struts2/cookbook/Login.jsp";
        this.driver = new HtmlUnitDriver();
    }

    public void testLoginOK() throws Exception
    {
        driver.get(this.baseUrl);
        WebElement userNameInputText = getInputText("username");
        userNameInputText.sendKeys("alberto");
        WebElement passwordInputText = getInputText("password");
        passwordInputText.sendKeys("12345");
        clickElement("login");
        assertThat(driver.getTitle(), is(equalTo("Welcome")));

    }

    public void testLoginNOK() throws Exception
    {
        driver.get(this.baseUrl);
        WebElement userNameInputText = getInputText("username");
        userNameInputText.sendKeys("paco");
        WebElement passwordInputText = getInputText("password");
        passwordInputText.sendKeys("12345");
        clickElement("login");
        assertThat(driver.getTitle(), is(equalTo("Sign On")));

    }

    private WebElement getInputText(String name) {
        WebElement element = driver.findElement(By.name(name));
        return element;
    }

    private void clickElement(String id) {
        WebElement element = driver.findElement(By.id(id));
        element.click();
    }
}
