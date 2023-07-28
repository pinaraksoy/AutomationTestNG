package comAutomationTesting.Tests.MyAccountpage;

import com.github.javafaker.Faker;
import comAutomationTesting.Pages.MyAccountPage;
import comAutomationTesting.utilities.ConfigurationReader;
import comAutomationTesting.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC22_LoginWithEmptyUsernameValidPW {
    //22. Log-in with empty username and valid password
    MyAccountPage loginPage = new MyAccountPage();
    Faker faker = new Faker();
    @Test
    public void loginWithEmptyUsernameValidPW() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //3) Click on My Account Menu
        loginPage.myAccountButton.click();
        Driver.getDriver().navigate().refresh();
        loginPage.myAccountButton.click();

        //4) Enter empty username in username textbox
        loginPage.inputUsername.sendKeys("");

        //5) Now enter valid password in the password textbox
        loginPage.inputPassword.sendKeys(faker.internet().password());

        //6) Click on login button.
        loginPage.loginButton.click();

        //7) Proper error must be displayed(ie Invalid username) and prompt to enter login again
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        Assert.assertTrue(loginPage.errorMessage.getText().contains("Username is required."));
        Assert.assertTrue(loginPage.loginForm.isDisplayed());
    }
}