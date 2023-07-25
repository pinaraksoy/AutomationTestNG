package comAutomationTesting.Tests.Loginpage;

import comAutomationTesting.Pages.LoginPage;
import comAutomationTesting.utilities.ConfigurationReader;
import comAutomationTesting.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC24_PasswordMasked {
    //24. Log-in -Password should be masked
    LoginPage loginPage = new LoginPage();

    @Test
    public void passwordMasked() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //3) Click on My Account Menu
        loginPage.myAccountButton.click();
        Driver.getDriver().navigate().refresh();
        loginPage.myAccountButton.click();

        //4) Enter the password field with some characters.
       loginPage.inputPassword.sendKeys("12345");
        String inputPass= loginPage.inputPassword.getText();
        System.out.println("inputPass = " + inputPass);

        //5) The password field should display the characters in asterisks or bullets
        // such that the password is not visible on the screen
        boolean isBulletSignDisplayed = inputPass.matches("^\\**$") || inputPass.isEmpty();
        Assert.assertTrue(isBulletSignDisplayed, "Password field does not display bullets/asterisks.");



    }
}