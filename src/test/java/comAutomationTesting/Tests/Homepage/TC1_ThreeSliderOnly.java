package comAutomationTesting.Tests.Homepage;

import comAutomationTesting.Pages.Homepage;
import comAutomationTesting.utilities.ConfigurationReader;
import comAutomationTesting.utilities.Driver;
import comAutomationTesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;

public class TC1_ThreeSliderOnly {

    Homepage homepage = new Homepage();
    @BeforeClass
    public void setUp(){
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

    }

    //3) Click on Shop Menu
    @Test(priority = 1)
    public void ClickOnShopMenu(){
        ReusableMethods.clickWithJS(homepage.shopButton);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(homepage.shopButton,2);
    }


    //4) Now click on Home menu button
    @Test(priority = 2)
    public void clickOnHomeMenuButton(){
        homepage.homeButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(homepage.homeButton, 3);
    }

    @Test(priority = 3)
    public void ThreeSlidersOnlyTest() {

        //5) Test whether the Home page has Three Sliders only
        //6) The Home page must contain only three sliders

        int expectedSlidersNumber = 3;
        int actualSliderNumber = homepage.threeSlidersOnly.size();

        Assert.assertEquals(actualSliderNumber, expectedSlidersNumber);

    }

    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
        }





}
