package comAutomationTesting.Pages;

import comAutomationTesting.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {
    public ShopPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(linkText = "Shop")
    public WebElement shopButton;

    @FindBy(css = "span[style='left: 85.7143%;']")
    public WebElement filterByPric450;

    @FindBy(css = "span[style='left: 0%;']")
    public WebElement filterByPric150;

    @FindBy(xpath = "//span[@class='ui-slider-handle ui-corner-all ui-state-default'][2]")
    public WebElement filterRightButton;

    @FindBy(xpath = "//button[.='Filter']")
    public WebElement filterButton;

  @FindBy(xpath = "//a[.='Android']")
    public WebElement productAndroid;

  @FindBy(xpath = "//nav[@class='woocommerce-breadcrumb']")
    public WebElement homeChosenProduct;

  @FindBy(css = "select[name='orderby']")
    public WebElement defaultSortingDropdown;







}
