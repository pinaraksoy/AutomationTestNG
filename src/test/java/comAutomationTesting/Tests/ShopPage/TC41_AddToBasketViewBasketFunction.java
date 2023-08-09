package comAutomationTesting.Tests.ShopPage;

import com.github.javafaker.Faker;
import comAutomationTesting.Pages.Homepage;
import comAutomationTesting.Pages.ShopPage;
import comAutomationTesting.utilities.ConfigurationReader;
import comAutomationTesting.utilities.Driver;
import comAutomationTesting.utilities.ReusableMethods;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC41_AddToBasketViewBasketFunction {
    ShopPage shopPage = new ShopPage();
    Homepage homepage = new Homepage();
    JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());

    Faker faker =new Faker();
    @Test
    public void addToBasketViewBasketFunction() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //3) Click on Shop Menu
        shopPage.shopButton.click();
        Driver.getDriver().navigate().refresh();
        shopPage.shopButton.click();

        //4) Click on the Add To Basket button which adds that book to your basket
        ReusableMethods.scrollIntoViewJS(shopPage.saleProduct1);
        Driver.getDriver().navigate().refresh();
        shopPage.addToBasketBtnOfSaleProduct1.click();

        //5) User can view that Book in the Menu item with price .
        System.out.println(shopPage.menuItem.getText());
        System.out.println(shopPage.actualPriceOfProduct1inShopPage.getText());
        Assert.assertTrue(shopPage.menuItem.getText().contains(shopPage.actualPriceOfProduct1inShopPage.getText()));

        //6) Now click on View Basket link which navigates to proceed to check out page.
        shopPage.viewBasket.click();
        Driver.getDriver().navigate().refresh();
        try{
            shopPage.addToBasketBtnOfSaleProduct1.click();
            shopPage.viewBasket.click();
        }catch (StaleElementReferenceException e){

        }

        //7) Now user can find total and subtotal values just above the Proceed to Checkout button.
        Assert.assertTrue(homepage.subtotalValue.isDisplayed());
        Assert.assertTrue(homepage.finalTotalPrice.isDisplayed());

        //8) The total always < !!!!!! (>)subtotal because taxes are added in the subtotal
        double subtotal = Double.parseDouble(homepage.subtotalValue.getText().substring(1));
        double totalPrice= Double.parseDouble(homepage.finalTotalPrice.getText().substring(1));

        Assert.assertTrue(totalPrice>subtotal,"the step is written wrong.Total price is greater than subtotal");

        //9) Now click on Proceed to Check out button which navigates to payment gateway page.
        jsexecutor.executeScript("window.scrollBy(0,250)");
        homepage.proceedToCheckout.click();
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Checkout"));

        //10) User can view Billing Details,Order Details,Additional details and Payment gateway details.
        Assert.assertTrue(homepage.billingDetails.isDisplayed());
        Assert.assertTrue(homepage.orderDetails.isDisplayed());
        Assert.assertTrue(homepage.additionalInformation.isDisplayed());
        Assert.assertTrue(homepage.paymentGateway.isDisplayed());

        //11) Now user can fill his details in billing details form and can opt any payment
        // in the payment gateway like Direct bank transfer,cheque,cash or paypal.
        homepage.inputFirstName.sendKeys(faker.name().firstName());
        homepage.inputLastName.sendKeys(faker.name().lastName());
        homepage.inputEmailAddress.sendKeys(faker.internet().emailAddress());
        homepage.inputPhoneNumber.sendKeys(faker.phoneNumber().cellPhone());
        jsexecutor.executeScript("window.scrollBy(0,500)");

        homepage.inputCountry.click();
        homepage.searchCountryBox.sendKeys("Turkey", Keys.ENTER);

        homepage.inputAddress.sendKeys(faker.address().streetAddress());
        homepage.inputPostCode.sendKeys(faker.address().zipCode());
        homepage.inputTown.sendKeys(faker.address().cityName());

        homepage.inputProvince.click();
        homepage.searchProvinceBox.sendKeys("İstanbul",Keys.ENTER);
        jsexecutor.executeScript("window.scrollBy(0,750)");

        Assert.assertTrue(homepage.checkRadioBtn.isDisplayed());
        Assert.assertTrue(homepage.payPalRadioBtn.isDisplayed());
        Assert.assertTrue(homepage.cashOnDeliveryRadioBtn.isDisplayed());
        Assert.assertTrue(homepage.directBankRadioBtn.isSelected());




        //12) Now click on Place Order button to complete process
        ReusableMethods.waitAndClick(homepage.placeOrderButton);

        //13) On clicking place order button user completes his process where the page navigates
        // to Order confirmation page with order details,bank details,customer details and billing details.
        Assert.assertTrue(homepage.orderThankyouMessage.getText().contains("Thank you. Your order has been received."));
        assert homepage.orderDetailTable.isDisplayed();
        assert homepage.bankDetail.isDisplayed();

    }
}