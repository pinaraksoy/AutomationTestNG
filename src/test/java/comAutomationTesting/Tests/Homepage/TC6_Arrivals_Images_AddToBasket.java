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



public class TC6_Arrivals_Images_AddToBasket {
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

    //5) Test whether the Home page has Three Arrivals only
    //6) The Home page must contain only three Arrivals
    @Test(priority = 3)
    public void ThreeArrivalOnly() {
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        jsexecutor.executeScript("window.scrollBy(0,1000)");
        int actualArrivals = homepage.threeArrivalOnly.size();
        int expectedArrivals = 3;
        Assert.assertEquals(actualArrivals, expectedArrivals);

    }

    //7) Now click the image in the Arrivals
    @Test(priority = 4)
    public void imagesInArrivals() {

        imageText = homepage.itemInImage1.getText().toLowerCase();
        homepage.image1.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(homepage.image1, 5);


        //8) Test whether it is navigating to next page where the user can add that book into his basket.
        //9) Image should be clickable and should navigate to next page where user can add that book to his basket

        Assert.assertTrue(Driver.getDriver().getTitle().toLowerCase().contains(imageText));
        assert homepage.addToBasketButton.isDisplayed();
    }

    //10) Click on the Add To Basket button which adds that book to your basket
    //11) User can view that Book in the Menu item with price.
    //12) User can add a book by clicking on Add To Basket button which adds that book in to his Basket
    @Test(priority = 5)
    public void Arrivals_Images_AddToBasket() {

        homepage.addToBasketButton.click();
        String expectedAddedMessage = "“Selenium Ruby” has been added to your basket.";
        String actualAddedMessage = homepage.messageText.getText();
        System.out.println("actualAddedMessage = " + actualAddedMessage);
        Assert.assertTrue(actualAddedMessage.contains(expectedAddedMessage));

        homepage.viewBasketButton.click();

        Assert.assertEquals(homepage.productName.getText().toLowerCase(),imageText);
        Assert.assertTrue(homepage.productPrice.isDisplayed());
    }

    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }


}