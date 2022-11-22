package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    //Launch website
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        //click on username
        sendTextToElement(By.name("username"), "Admin");
        //Enter password
        sendTextToElement(By.name("password"), "admin123");
        //click on login

        clickOnElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));

        //This is requirement
        String expectedMessage = "Dashboard";

        //Find the welcome test element and get the text
        WebElement actualTextMessageElement = BaseTest.driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));
        String actualMessage = actualTextMessageElement.getText();
        //This is requirement
        Assert.assertEquals("Text matching succesfully:", expectedMessage, actualMessage);

    }

    @After
    public void testDown() {
        //Closing browser
        closeBrowser();
    }
}

