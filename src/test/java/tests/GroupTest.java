package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test(groups = "login")
    public void loginTest() {

        driver.findElement(By.id("user-name"))
               .sendKeys("standard_user");

        driver.findElement(By.id("password"))
               .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
               .click();

        Assert.assertEquals(driver.getTitle(), "Swag Labs");

        System.out.println("Login Test");
    }

    @Test(groups = "products")
    public void productTest() {

        System.out.println("Product Test");
    }

    @Test(groups = "checkout")
    public void checkoutTest() {

        System.out.println("Checkout Test");
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}