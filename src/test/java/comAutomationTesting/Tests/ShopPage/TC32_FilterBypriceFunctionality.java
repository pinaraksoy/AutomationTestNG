package comAutomationTesting.Tests.ShopPage;

import comAutomationTesting.Pages.ShopPage;
import comAutomationTesting.utilities.ConfigurationReader;
import comAutomationTesting.utilities.Driver;
import comAutomationTesting.utilities.ReusableMethods;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TC32_FilterBypriceFunctionality {
    ShopPage shopPage= new ShopPage();
    @Test
    public void filterBypriceFunctionality() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //3) Click on Shop Menu
       shopPage.shopButton.click();
        Driver.getDriver().navigate().refresh();
       shopPage.shopButton.click();

        //4) Adjust the filter by price between 150 to 450 rps
        Actions action=new Actions(Driver.getDriver());

        action.dragAndDropBy(shopPage.filterRightButton,-29,0).perform();
        ReusableMethods.waitFor(5);

        //5) Now click on Filter button
        shopPage.filterButton.click();

        //6) User can view books only between 150 to 450 rps price
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("min_price=150&max_price=449"));
    }
}