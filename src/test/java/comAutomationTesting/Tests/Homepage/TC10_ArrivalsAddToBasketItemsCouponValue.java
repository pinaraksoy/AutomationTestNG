package comAutomationTesting.Tests.Homepage;

import comAutomationTesting.Pages.Homepage;
import comAutomationTesting.utilities.ConfigurationReader;
import comAutomationTesting.utilities.Driver;
import comAutomationTesting.utilities.ReusableMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class TC10_ArrivalsAddToBasketItemsCouponValue {
    Homepage homepage = new Homepage();
    JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
    String imageText;
    @BeforeClass
    public void setUp() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

    }

    //3) Click on Shop Menu
    @Test(priority = 1)
    public void ClickOnShopMenu() {
        ReusableMethods.clickWithJS(homepage.shopButton);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(homepage.shopButton, 2);
    }

    //4) Now click on Home menu button
    @Test(priority = 2)
    public void clickOnHomeMenuButton() {
        homepage.homeButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(homepage.homeButton, 3);
    }

    @Test(priority = 3)
    public void ThreeArrivalOnly() {

        //5) Test whether the Home page has Three Arrivals only
        //6) The Home page must contain only three Arrivals
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        jsexecutor.executeScript("window.scrollBy(0,1000)");
        int actualArrivals = homepage.threeArrivalOnly.size();
        int expectedArrivals = 3;
        Assert.assertEquals(actualArrivals, expectedArrivals);

    }
    @Test(priority = 4)
    public void imagesInArrivals() {
        //7) Now click the image in the Arrivals
        imageText = homepage.itemInImage3.getText();
        homepage.image3LessThan450.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(homepage.image3LessThan450, 2);


        //8) Test whether it is navigating to next page where the user can add that book into his basket.
        //9) Image should be clickable and should navigate to next page where user can add that book to his basket

        Assert.assertTrue(Driver.getDriver().getTitle().contains(imageText));
        assert homepage.addToBasketButton.isDisplayed();
    }

    @Test(priority = 5)
    public void Arrivals_AddToBasketItems() {
        //10) Click on the Add To Basket button which adds that book to your basket
        ReusableMethods.waitForClickablility(homepage.addToBasketButton,5);
        homepage.closeButton.click();
        homepage.addToBasketButton.click();

        String expectedAddedMessage = "“"+imageText+"” has been added to your basket.";
        String actualAddedMessage = homepage.messageText.getText();
        System.out.println("actualAddedMessage = " + actualAddedMessage);
        Assert.assertTrue(actualAddedMessage.contains(expectedAddedMessage));

        //11) User can view that Book in the Menu item with price.
        homepage.viewBasketButton.click();
        Assert.assertEquals(homepage.productName.getText(),imageText);
        Assert.assertTrue(homepage.productPrice.isDisplayed());

        //12) Now click on Item link which navigates to proceed to check out page.
        //13) User can click on the Item link in menu item after adding the book in to the basket which leads to the check out page
        Assert.assertTrue(homepage.proceedToCheckout.isEnabled());
        homepage.itemLink.click();
    }
    @Test(priority = 6)
    public void ArrivalsAddToBasketItemsCouponValue() {
        //14) Enter the Coupon code as ‘krishnasakinala’ to get 50rps off on the total.
        //15) User can not able to apply coupon by entering ‘krishnasakinala’ in the coupon textbox which give 50rps off on the total price
        //because the coupon is applicable for the book price > 450 rps

        homepage.inputCouponCode.sendKeys(ConfigurationReader.getProperty("coupon.code"));
        homepage.applyCouponButton.click();
        Assert.assertTrue(homepage.couponErrorMessage.getText().contains("The minimum spend for this coupon is ₹450.00."));
    }

    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }
}