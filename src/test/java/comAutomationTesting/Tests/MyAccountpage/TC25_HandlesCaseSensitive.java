package comAutomationTesting.Tests.MyAccountpage;

import comAutomationTesting.Pages.MyAccountPage;
import comAutomationTesting.utilities.ConfigurationReader;
import comAutomationTesting.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC25_HandlesCaseSensitive {
    //25. Login-Handles case sensitive
    MyAccountPage loginPage = new MyAccountPage();

    @Test
    public void handlesCaseSensitive() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //3) Click on My Account Menu
        loginPage.myAccountButton.click();
        Driver.getDriver().navigate().refresh();
        loginPage.myAccountButton.click();

        //4) Enter the case changed username in username textbox
        loginPage.inputUsername.sendKeys(ConfigurationReader.getProperty("valid.email").toUpperCase());

        //5) Enter the case chenged password in the password tetxbox
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("valid.password").toUpperCase());

        //6) Now click on login button
        loginPage.loginButton.click();

        //7) Login must fail saying incorrect username/password.
        System.out.println("loginPage.errorMessage.getText() = " + loginPage.errorMessage.getText());
        Assert.assertTrue(loginPage.errorMessage.getText().contains(" is incorrect"));

    }
}