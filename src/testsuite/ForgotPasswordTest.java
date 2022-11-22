package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class ForgotPasswordTest extends Utility {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        //Launch browser
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {


        clickOnElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']"));
        //This is requirement
        String expectedMessage = "Reset Password";

        //Find the welcome test element and get the text
        WebElement actualTextMessageElement = BaseTest.driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']"));
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
