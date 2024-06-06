package demo;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static graphql.Assert.assertTrue;

public class Url
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.Chrome.driver","C:\\Program Files\\Google\\Chrome\\Application.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://demowebshop.tricentis.com/");
        driver.findElement(By.linkText("Log in")).click();
        if(driver.getPageSource().contains("Welcome, Please Sign In!"))
        {
         System.out.println("Validated Welcome Text");
        }
        else {
            System.out.println("Welcome text not validated");
        }

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
        /*Boolean valid02=driver.getPageSource().contains("test_test01@gmail.com");
        assertTrue(valid02);*/





    }

}
