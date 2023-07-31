package comAutomationTesting.Tests.ShopPage;

import comAutomationTesting.Pages.ShopPage;
import comAutomationTesting.utilities.ConfigurationReader;
import comAutomationTesting.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC33_ProductCategoriesFunctionality {
    ShopPage shopPage= new ShopPage();
    @Test
    public void productCategoriesFunctionality() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //3) Click on Shop Menu
        shopPage.shopButton.click();
        Driver.getDriver().navigate().refresh();
        shopPage.shopButton.click();

        //4) Click any of the product links available in the product category
        shopPage.productAndroid.click();

        //5) Now user can view only that particular product
        Assert.assertTrue(shopPage.homeChosenProduct.getText().contains("Android"));

    }
}