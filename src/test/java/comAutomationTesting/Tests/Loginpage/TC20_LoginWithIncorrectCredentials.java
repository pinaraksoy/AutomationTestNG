package comAutomationTesting.Tests.Loginpage;

import com.github.javafaker.Faker;
import comAutomationTesting.Pages.LoginPage;
import comAutomationTesting.utilities.ConfigurationReader;
import comAutomationTesting.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC20_LoginWithIncorrectCredentials {
    //20. Log-in with incorrect username and incorrect password
    LoginPage loginPage = new LoginPage();


    @Test
    public void loginWithIncorrectCredentials() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //3) Click on My Account Menu
        loginPage.myAccountButton.click();
        Driver.getDriver().navigate().refresh();
        loginPage.myAccountButton.click();

        //4) Enter incorrect username in username textbox
         loginPage.inputUsername.sendKeys("abcdef@email.com");

        //5) Enter incorrect password in password textbox.
        loginPage.inputPassword.sendKeys("123456");

        //6) Click on login button
        loginPage.loginButton.click();

        //7) Proper error must be displayed(ie Invalid username) and prompt to enter login again
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        Assert.assertTrue(loginPage.errorMessage.getText().contains("Error"));
        Assert.assertTrue(loginPage.inputUsername.isDisplayed());
        Assert.assertTrue(loginPage.inputPassword.isDisplayed());

    }
}