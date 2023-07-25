package comAutomationTesting.Tests.Loginpage;

import com.github.javafaker.Faker;
import comAutomationTesting.Pages.LoginPage;
import comAutomationTesting.utilities.ConfigurationReader;
import comAutomationTesting.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC21_LoginWithCorrectUsernameEmptyPW  {
    //21. Log-in with correct username and empty password
    LoginPage loginPage = new LoginPage();
    Faker faker = new Faker();

    @Test
    public void loginWithCorrectUsernameEmptyPW() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //3) Click on My Account Menu
        loginPage.myAccountButton.click();
        Driver.getDriver().navigate().refresh();
        loginPage.myAccountButton.click();

        //4) Enter valid username in username textbox
        loginPage.inputUsername.sendKeys(faker.internet().emailAddress());

        //5) Now enter empty password in the password textbox
        loginPage.inputPassword.sendKeys("");

        //6) Click on login button.
        loginPage.loginButton.click();

        //7) Proper error must be displayed(ie Invalid password) and prompt to enter login again
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        Assert.assertTrue(loginPage.errorMessage.getText().contains("Password is required."));
        Assert.assertTrue(loginPage.loginForm.isDisplayed());
    }
}