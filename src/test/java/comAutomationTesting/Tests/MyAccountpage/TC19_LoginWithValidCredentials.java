package comAutomationTesting.Tests.MyAccountpage;

import com.github.javafaker.Faker;
import comAutomationTesting.Pages.MyAccountPage;
import comAutomationTesting.utilities.ConfigurationReader;
import comAutomationTesting.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC19_LoginWithValidCredentials {
    //19. Log-in with valid username and password

    MyAccountPage loginPage = new MyAccountPage();
    Faker faker = new Faker();

    @Test
    public void LoginWithValidCredentials() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //3) Click on My Account Menu
        loginPage.myAccountButton.click();
        Driver.getDriver().navigate().refresh();
        loginPage.myAccountButton.click();

        //4) Enter registered username in username textbox
        String email=faker.internet().emailAddress();
        String password=faker.internet().password();
        System.out.println("password = " + password);
        System.out.println("email = " + email);

        loginPage.inputEmailRegister.sendKeys(email);
        loginPage.inputPasswordRegister.sendKeys(password);
        loginPage.registerButton.click();
        loginPage.logoutButton.click();

        loginPage.inputUsername.sendKeys(email);

        //5) Enter password in password textbox
        loginPage.inputPassword.sendKeys(password);

        //6) Click on login button
        loginPage.loginButton.click();

        //7) User must successfully login to the web page
        Assert.assertTrue(loginPage.loginHelloMessage.getText().contains(email.substring(0,email.indexOf('@'))));


    }
}