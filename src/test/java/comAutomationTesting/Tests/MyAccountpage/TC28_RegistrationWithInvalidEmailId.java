package comAutomationTesting.Tests.MyAccountpage;

import comAutomationTesting.Pages.MyAccountPage;
import comAutomationTesting.utilities.ConfigurationReader;
import comAutomationTesting.utilities.Driver;
import comAutomationTesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC28_RegistrationWithInvalidEmailId {
    MyAccountPage registrationPage =new MyAccountPage();
    @Test
    public void registrationWithInvalidEmailId() {
        //) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //3) Click on My Account Menu
        registrationPage.myAccountButton.click();
        Driver.getDriver().navigate().refresh();
        registrationPage.myAccountButton.click();

        //4) Enter invalid Email Address in Email-Address textbox
        registrationPage.inputEmailRegister.sendKeys(ConfigurationReader.getProperty("email.registered").replace(".com",""));

        //5) Enter your own password in password textbox
        registrationPage.inputPasswordRegister.sendKeys(ConfigurationReader.getProperty("password.registered"));

        //6) Click on Register button
        ReusableMethods.waitAndClick(registrationPage.registerButton,3);

        //7) Registration must fail with a warning message(ie You must enter a valid email address)
        Assert.assertTrue(registrationPage.errorMessage.getText().contains("Please provide a valid email address."));

    }
}