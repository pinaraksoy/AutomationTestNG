package comAutomationTesting.Tests.ShopPage;

import comAutomationTesting.Pages.ShopPage;
import comAutomationTesting.utilities.ConfigurationReader;
import comAutomationTesting.utilities.Driver;
import comAutomationTesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC40_SaleFunctionality {
    ShopPage shopPage = new ShopPage();

    @Test
    public void saleFunctionality() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //3) Click on Shop Menu
        shopPage.shopButton.click();
        Driver.getDriver().navigate().refresh();
        shopPage.shopButton.click();

        //4) Click on Sale written product in home page
        ReusableMethods.scrollIntoViewJS(shopPage.saleProduct1);
        Driver.getDriver().navigate().refresh();
        shopPage.saleProduct1.click();


        //5) User can clearly view the actual price with old price striken for the sale written products
        Assert.assertTrue(shopPage.oldPriceOfProduct1.isDisplayed());
        Assert.assertTrue(shopPage.actualPriceOfProduct1.isDisplayed());

        Driver.closeDriver();
    }
}