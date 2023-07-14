package comAutomationTesting.Tests.Homepage;

import comAutomationTesting.Pages.Homepage;
import comAutomationTesting.utilities.ConfigurationReader;
import comAutomationTesting.utilities.Driver;
import comAutomationTesting.utilities.ReusableMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC3_ImageInArrivals {
    @Test
    public void imagesInArrivals() {

        //Open the browser
        Homepage homepage = new Homepage();

//2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

//3) Click on Shop Menu
        ReusableMethods.clickWithJS(homepage.shopButton);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(homepage.shopButton, 2);
//4) Now click on Home menu button

        homepage.homeButton.click();
        Driver.getDriver().navigate().refresh();
        homepage.homeButton.click();

//5) Test whether the Home page has Three Arrivals only
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        jsexecutor.executeScript("window.scrollBy(0,750)");
        int actualArrivals = homepage.threeArrivalOnly.size();
        int expectedArrivals = 3;
//6) The Home page must contains only three Arrivals
        Assert.assertEquals(actualArrivals, expectedArrivals);

        //7) Now click the image in the Arrivals
        homepage.image1.click();
        Driver.getDriver().navigate().refresh();
        homepage.image1.click();

        //8) Test whether it is navigating to next page where the user can add that book into his basket.
        homepage.addToBasketButton.click();
        String expectedAddedMessage = " “Selenium Ruby” has been added to your basket.";
        String actualAddedMessage = homepage.addedToBasketMessage.getText();


        //9) Image should be clickable and should navigate to next page where user can add that book to his basket
        Assert.assertEquals(actualAddedMessage, expectedAddedMessage);
        Driver.closeDriver();

    }
    }