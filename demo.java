package test;

import graphql.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.Chrome.driver","C:\\Program Files\\Google\\Chrome\\Application.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://demowebshop.tricentis.com/");
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.className("email")).sendKeys("test_test01@gmail.com");
        driver.findElement(By.className("password")).sendKeys("Testing@1234");
        driver.findElement(By.className("login-button")).click();
        driver.findElement(By.className("cart-label")).click();
        driver.findElement(By.xpath("//input[@value='4353648']")).click();
        driver.findElement(By.xpath("//input[@value='4353651']")).click();
        driver.findElement(By.className("update-cart-button")).click();
        driver.findElement(By.cssSelector("Books")).click();




    }
}
