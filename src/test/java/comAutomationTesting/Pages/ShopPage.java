package comAutomationTesting.Pages;

import comAutomationTesting.utilities.Driver;
import comAutomationTesting.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {
    public ShopPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(linkText = "Shop")
    public WebElement shopButton;



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

  @FindBy(xpath = "//span[@tabindex='0'][2]")
    public WebElement leftSliderHandleIcon;

  @FindBy(css = "span.to")
  public WebElement priceRangeTo;

  @FindBy(css = "span.from")
  public WebElement priceRangeFrom;

  @FindBy(xpath = "//span[@tabindex='0']")
  public WebElement rightSliderHandleIcon;

  @FindBy(xpath = "(//span[.='Sale!']/..)[1]")
  public WebElement saleProduct1;

  @FindBy(xpath = "((//span[.='Sale!'])/../..)//a[2]")
  public WebElement addToBasketBtnOfSaleProduct1;

  @FindBy(xpath = "//a[@class='wpmenucart-contents']")
  public WebElement menuItem;

  @FindBy(xpath = "//p[@class='price']/del/span")
  public WebElement oldPriceOfProduct1;

    @FindBy(xpath = "//p[@class='price']/ins/span")
    public WebElement actualPriceOfProduct1;

    @FindBy(css = "a[title='View Basket']")
    public WebElement viewBasket;

    @FindBy(xpath = "(//span[.='Sale!']/..)[1]//ins/span")
    public WebElement actualPriceOfProduct1inShopPage;

    @FindBy(xpath = "")
    public WebElement iframe;

    public void adjustPriceBySlider(int startPrice, int endPrice) {
        Actions move = new Actions(Driver.getDriver());
        move.click(leftSliderHandleIcon).build().perform();
        ReusableMethods.wait(2);

        int i = 0;
        while (i >= 0) {
            if (priceRangeTo.getText().contains(String.valueOf(endPrice)) && priceRangeFrom.getText().contains(String.valueOf(startPrice))) {
                break;
            } else {
                move.sendKeys(Keys.ARROW_LEFT).build().perform();
            }
            i++;
        }
    }





}
