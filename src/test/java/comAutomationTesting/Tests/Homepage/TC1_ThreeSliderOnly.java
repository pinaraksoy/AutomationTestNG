package comAutomationTesting.Tests.Homepage;

import comAutomationTesting.Pages.Homepage;
import comAutomationTesting.utilities.ConfigurationReader;
import comAutomationTesting.utilities.Driver;
import comAutomationTesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1_ThreeSliderOnly {
    @Test
    public void ThreeSlidersOnlyTest() {

        Homepage homepage = new Homepage();
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //3) Click on Shop Menu
        ReusableMethods.clickWithJS(homepage.shopButton);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(homepage.shopButton,2);

        //4) Now click on Home menu button
        homepage.homeButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(homepage.homeButton, 5);

        //5) Test whether the Home page has Three Sliders only
        //6) The Home page must contain only three sliders

        int expectedSlidersNumber= 3;
        int actualSliderNumber= homepage.threeSlidersOnly.size();

        Assert.assertEquals(actualSliderNumber,expectedSlidersNumber);



        Driver.closeDriver();


    }
}
