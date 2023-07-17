package comAutomationTesting.Tests.Homepage;

import comAutomationTesting.Pages.Homepage;
import comAutomationTesting.utilities.ConfigurationReader;
import comAutomationTesting.utilities.Driver;
import comAutomationTesting.utilities.ReusableMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC7_Arrivals_AddToBasketWithMoreBooks {
    Homepage homepage = new Homepage();
    JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
    String imageText;
    @BeforeClass
    public void setUp() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

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
        String actualAddedMessage = homepage.addedToBasketMessage.getText();
        System.out.println("actualAddedMessage = " + actualAddedMessage);
        Assert.assertTrue(actualAddedMessage.contains(expectedAddedMessage));

        homepage.viewBasketButton.click();


        Assert.assertEquals(homepage.productName.getText().toLowerCase(),imageText);
        Assert.assertTrue(homepage.productPrice.isDisplayed());
    }

    @Test(priority = 6)
    public void Arrivals_AddToBasketWithMoreBooks() {

        //13) Select more books than the books in stock.Ex if the stock has 20 books, try to add 21.
        homepage.productName.click();
        homepage.quantityOfBook.clear();
        homepage.quantityOfBook.sendKeys("25");

        //14) Click the add to basket button
        homepage.addToBasketButton.click();

        //15) Now it throws an error prompt like you must enter a value between 1 and 20
        String expectedErrorMessage= "you must enter a value between 1 and 20";
        String actualErrorMessage= homepage.addedToBasketMessage.getText();
        System.out.println("actualErrorMessage = " + actualErrorMessage);
        Assert.assertTrue(actualErrorMessage.toLowerCase().contains(expectedErrorMessage));
        System.out.println("there is no stock limit ");
    }
}