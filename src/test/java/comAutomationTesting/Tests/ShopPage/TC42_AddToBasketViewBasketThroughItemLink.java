package comAutomationTesting.Tests.ShopPage;

import com.github.javafaker.Faker;
import comAutomationTesting.Pages.Homepage;
import comAutomationTesting.Pages.ShopPage;
import comAutomationTesting.Pages.CheckOutPage;
import comAutomationTesting.utilities.ConfigurationReader;
import comAutomationTesting.utilities.Driver;
import comAutomationTesting.utilities.ReusableMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC42_AddToBasketViewBasketThroughItemLink {
    ShopPage shopPage = new ShopPage();
    Homepage homepage = new Homepage();
    JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
    Faker faker =new Faker();
    CheckOutPage checkOutPage = new CheckOutPage();

    @Test
    public void addToBasketViewBasketThroughItemLink() {
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
        Assert.assertTrue(shopPage.menuItem.getText().contains(shopPage.actualPriceOfProduct1inShopPage.getText()));

        //6) Now click on Item link which navigates to proceed to check out page.
         homepage.itemLink.click();

        //7) Now user can find total and subtotal values just above the Proceed to Checkout button.
        Assert.assertTrue(homepage.subtotalValue.isDisplayed());
        Assert.assertTrue(homepage.finalTotalPrice.isDisplayed());

        //8) The total always < subtotal because taxes are added in the subtotal
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

        //11) Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal.
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

        //13) On clicking place order button user completes his process where the page navigates to Order confirmation page
        //with order details,bank details,customer details and billing details
        Assert.assertTrue(homepage.orderThankyouMessage.getText().contains("Thank you. Your order has been received."));
        assert homepage.orderDetailTable.isDisplayed();
        assert homepage.bankDetail.isDisplayed();

    }

    //second way
    @Test
    public void addToBasketAndViewTheBasket() {

        //Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //Click on Shop Menu
        homepage.shopButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(homepage.shopButton, 2);

        //Click on the Add To Basket button which adds that book to your basket
        shopPage.addToBasketLink.click();


        //User can view that Book in the Menu item with price
        Assert.assertTrue(shopPage.cartContentOnShoppingCart.isDisplayed());

        Assert.assertTrue(shopPage.amountOnShoppingCart.isDisplayed());

        //Now click on View Basket link which navigates to proceed to check out page.
        ReusableMethods.waitAndClick(shopPage.viewShoppingCartLink, 2);
        Driver.getDriver().navigate().refresh();


        // Now user can find total and subtotal values just above the Proceed to Checkout button.
        Assert.assertTrue(checkOutPage.orderTotalAmount.isDisplayed());
        Assert.assertTrue(checkOutPage.subtotalAmount.isDisplayed());

        //The total always > subtotal because taxes are added in the subtotal
        String subTotalOfOrder = checkOutPage.subtotalAmount.getText();
        String subtotal = subTotalOfOrder.substring(1);
        double subTotal = Double.parseDouble(subtotal);
        String totalAmountAfterTax = checkOutPage.orderTotalAmount.getText();
        String totalamount = totalAmountAfterTax.substring(1);
        double totalAmount = Double.parseDouble(totalamount);
        Assert.assertTrue(totalAmount > subTotal);

        //Now click on Proceed to Check out button which navigates to payment gateway page.
        checkOutPage.proceedToCheckoutBtn.click();

        //User can view Billing Details,Order Details,Additional details and Payment gateway details.
        checkOutPage.verifyPaymentMethods();
        checkOutPage.verifyDetailsText();

        //Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal.
        checkOutPage.fillInBillingDetails();
        checkOutPage.clickOnExpectedPaymetMethods("Cash on Delivery");

        //Now click on Place Order button to complete process
        checkOutPage.placeOrderBtn.click();

        //On clicking place order button user completes his process where the page navigates to Order confirmation page with order details,bank details,customer details and billing details.
        Assert.assertEquals(checkOutPage.orderReceivedMessage.getText(), "Thank you. Your order has been received.");
        Driver.closeDriver();

    }
}
