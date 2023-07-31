package comAutomationTesting.Tests.ShopPage;

import comAutomationTesting.Pages.ShopPage;
import comAutomationTesting.utilities.ConfigurationReader;
import comAutomationTesting.utilities.Driver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC35_DefaultSortingByAverage {
    ShopPage shopPage = new ShopPage();

    @Test
    public void defaultSortingByAverage() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //3) Click on Shop Menu
        shopPage.shopButton.click();
        Driver.getDriver().navigate().refresh();
        shopPage.shopButton.click();

        //4) Click on Sort by Average ratings in Default sorting dropdown
        Select defaultSorting = new Select(shopPage.defaultSortingDropdown);
        defaultSorting.selectByVisibleText("Sort by average rating");

        //5) Now user can view the popular products only
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("orderby=rating"));

    }
}