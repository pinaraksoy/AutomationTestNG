package comAutomationTesting.Pages;

import comAutomationTesting.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(xpath = "/img[@class='attachment-shop_catalog size-shop_catalog wp-post-image'][1]")
    public WebElement image1;

    @FindBy(xpath = "//button[.='Add to basket']")
    public WebElement addToBasketButton;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/text()")
    public WebElement addedToBasketMessage;

}
