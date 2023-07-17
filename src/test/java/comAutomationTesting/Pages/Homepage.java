package comAutomationTesting.Pages;

import comAutomationTesting.utilities.ConfigurationReader;
import comAutomationTesting.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Homepage {
    public Homepage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Shop")
    public WebElement shopButton;

    @FindBy(xpath = "//a[.='Home']")
    public WebElement homeButton;

    @FindBy (xpath = "//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]")
    public WebElement threeSliders;

    @FindBy(xpath = "//div[@data-slide-duration='0']")
    public List<WebElement> threeSlidersOnly;

    @FindBy(xpath = "//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div")
    public List<WebElement> threeArrivalOnly;

    @FindBy(xpath = "//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div[1]//img")
    public WebElement image1;

    @FindBy(xpath = "//button[.='Add to basket']")
    public WebElement addToBasketButton;

    @FindBy(xpath = "//div[@class='woocommerce-message']")
    public WebElement messageText;

    @FindBy(xpath = "//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div[1]//h3")
    public WebElement itemInImage1;

    @FindBy(xpath = "//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div[3]//h3")
    public WebElement itemInImage3;

    @FindBy(xpath = "//img[@title='Mastering JavaScript']")
    public WebElement image3LessThan450;

    @FindBy(css = "li[class='description_tab active']")
    public WebElement descriptionButton;

    @FindBy(xpath = "//div[@id='tab-description']/p")
    public WebElement descriptionText;

    @FindBy(xpath = "//span[@class='posted_in']/a")
    public WebElement categoryOfBook;

    @FindBy(xpath = "//li[@class='reviews_tab']")
    public  WebElement reviewsButton;

    @FindBy(xpath = "//div[@id='comments']//p")
    public WebElement reviewText;

    @FindBy(xpath = "//a[.='View Basket']")
    public WebElement viewBasketButton;

    @FindBy(xpath = "//a[.='Selenium Ruby']")
    public WebElement productNameImage1;

    @FindBy(xpath = "//td[@data-title='Product']/a")
    public WebElement productName;

    @FindBy(xpath = "//td[@class='product-price']/span")
    public WebElement productPrice;

    @FindBy(css = "input[title='Qty']")
    public WebElement quantityOfBook;

    @FindBy(className = "cartcontents")
    public WebElement itemLink;

    @FindBy(css = "a[class='checkout-button button alt wc-forward'")
    public WebElement proceedToCheckout;

    @FindBy(id = "coupon_code")
    public WebElement inputCouponCode;

    @FindBy(xpath = "//input[@value='Apply Coupon']")
    public WebElement applyCouponButton;

    @FindBy(xpath = "//td[@data-title='Coupon: krishnasakinala']/span")
    public WebElement freeCouponAmount;

    @FindBy(xpath = "//a[.='×']")
    public WebElement removeButton;

    @FindBy(xpath = "//a[@class='button wc-backward']")
    public WebElement returnToShopButton;



    @FindBy(xpath = "//ul[@class='woocommerce-error']/li")
    public WebElement couponErrorMessage;

    @FindBy(css = "a[class='pp_close']")
    public WebElement closeButton;

    @FindBy(css = "input[value='Update Basket']")
    public WebElement updateBasketButton;

    @FindBy(xpath = "(//td[@data-title='Total'])[1]/span")
    public WebElement totalPriceOfSelectedBook;

    @FindBy(xpath = "(//td[@data-title='Total'])[2]/strong/span")
    public WebElement finalTotalPrice;


}
