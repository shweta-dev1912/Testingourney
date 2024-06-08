package test;

import graphql.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class demo
{
    public static void main(String[] args)
    {
        //initializing chrome web browser
        System.setProperty("webdriver.Chrome.driver","C:\\Program Files\\Google\\Chrome\\Application.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://demowebshop.tricentis.com/");

        //Login and validation
        driver.findElement(By.linkText("Log in")).click();
        if(driver.getPageSource().contains("Welcome, Please Sign In!"))
        {
            System.out.println("Validated Welcome Text");
        }
        else {
            System.out.println("Welcome text not validated");
        }

        //enter the username and password and click login button and validate user
        driver.findElement(By.className("email")).sendKeys("test_test01@gmail.com");
        driver.findElement(By.className("password")).sendKeys("Testing@1234");
        driver.findElement(By.className("login-button")).click();
        if(driver.getPageSource().contains("test_test01@gmail.com"))
        {
            System.out.println("Validated User Name");
        }
        else {
            System.out.println("User Name not validated");
        }

        //Delete any item in cart if already present - empty the cart
        driver.findElement(By.className("cart-label")).click();
        List <WebElement> Cartitem=driver.findElements(By.name("removefromcart"));
        int n=Cartitem.size();
        System.out.println("The total item in the cart is "+n);
        for(int i=0;i<n;i++)
        {
            driver.findElement(By.xpath("//input[@name='removefromcart']")).click();
            driver.findElement(By.className("update-cart-button")).click();
        }
        System.out.println("Removed all the items from the cart");

        //Click on books, selected a product and get the price
        List <WebElement> BooksClick=driver.findElements(By.cssSelector(".top-menu"));
        BooksClick.get(0).findElement(By.linkText("BOOKS")).click();
        driver.findElement(By.linkText("Books")).click();
        driver.findElement(By.className("product-title")).click();
        System.out.println(driver.findElement(By.className("product-price")).getText());

        //Clear the quantity field and add some quantity
        driver.findElement(By.className("qty-input")).clear();
        driver.findElement(By.className("qty-input")).sendKeys("3");
        driver.findElement(By.xpath("//input[@value='Add to cart']")).click();

       /* -- notification message validation
        WebElement notificationdiv= driver.findElement(By.id("bar-notification"));
        WebElement notificationpara=notificationdiv.findElement(By.cssSelector(".content"));
        String notication=notificationpara.getText();
        if(driver.getPageSource().contains("The product has been added to your shopping cart"))
        {
            System.out.println("Validated notification Text");
        }
        else {
            System.out.println("Notification text not validated");
        }
         driver.findElement(By.cssSelector("#ctrlNotesWindow .notesData > .notesDate")).getText();

        */

        //validate the price and click on checkout
        driver.findElement(By.className("cart-label")).click();
        List <WebElement> cartsubtotal=driver.findElements(By.className("cart-total-right"));
        String cartprice=cartsubtotal.get(0).findElement(By.className("product-price")).getText();
        if(cartprice.equals("30.00"))
            System.out.println("Validated the cart price. The price is " + cartprice);
        else
            System.out.println("Not Validated the cart price.");
        driver.findElement(By.xpath("//input[@name='termsofservice']")).click();
        driver.findElement(By.name("checkout")).click();

        //Fill the address and proceed for shipping
        Select Address=new Select(driver.findElement(By.id("billing-address-select")));
        Address.selectByVisibleText("New Address");
        Select country=new Select(driver.findElement(By.id("BillingNewAddress_CountryId")));
        country.selectByValue("41");
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Hyderabad");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Secunderabad");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("567893");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("8908908909");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        WebElement listshipping=driver.findElement(By.id("shipping-buttons-container"));
        WebElement shippingbutton=listshipping.findElement(By.xpath("//input[@class='button-1 new-address-next-step-button']"));
        shippingbutton.click();
       // driver.findElement(By.xpath("//input[@value='Next Day Air___Shipping.FixedRate']")).click();
       // driver.findElement(By.xpath("//input[@value='Continue']")).click();
       // driver.findElement(By.xpath("//input[@value='Payments.CashOnDelivery']")).click();
       // driver.findElement(By.xpath("//input[@value='Continue']")).click();

    }
}
