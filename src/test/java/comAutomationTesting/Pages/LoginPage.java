package comAutomationTesting.Pages;

import comAutomationTesting.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[.='My Account']")
    public WebElement myAccountButton;

    @FindBy(id = "reg_email")
    public WebElement inputEmailRegister;

    @FindBy(id = "reg_password")
    public WebElement inputPasswordRegister;

    @FindBy(id = "username")
    public WebElement inputUsername;

    @FindBy(id = "password")
    public WebElement inputPassword;

    @FindBy(css = "input[value='Login']")
    public WebElement loginButton;

    @FindBy(css = "input[value='Register']")
    public WebElement registerButton;

    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logoutButton;

    @FindBy(xpath = "//div[@class='woocommerce-MyAccount-content']/p")
    public WebElement loginHelloMessage;








}
