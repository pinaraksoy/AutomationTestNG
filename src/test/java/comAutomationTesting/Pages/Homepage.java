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

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/text()")
    public WebElement addedToBasketMessage;

    @FindBy(xpath = "//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div[1]//h3")
    public WebElement itemInImage1;

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



}
