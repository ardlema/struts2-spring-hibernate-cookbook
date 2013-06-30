package org.ardlema.functional;

import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;


public class RecetaTestIT
        extends TestCase
{
    private String baseUrl;
    private WebDriver driver;

    public void setUp() throws Exception
    {
        super.setUp();
        String port = System.getProperty("servlet.port");
        this.baseUrl = "http://localhost:" + port + "/cookbook-struts2/cookbook/Welcome.jsp";
        this.driver = new HtmlUnitDriver();
    }

    public void testRecetaSaveOK() throws Exception
    {
        driver.get(this.baseUrl);
        WebElement userNameInputText = getInputText("nombre");
        userNameInputText.sendKeys("Macarrones con chorizo");
        WebElement passwordInputText = getInputText("dificultad");
        passwordInputText.sendKeys("1");
        WebElement elaboracionInputText = getInputText("elaboracion");
        elaboracionInputText.sendKeys("Hacer los macarrones con chorizo");
        clickElement("save");
        assertThat(driver.getTitle(), is(equalTo("Welcome")));

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
