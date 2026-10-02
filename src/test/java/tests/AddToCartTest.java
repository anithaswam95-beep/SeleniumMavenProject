package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        // Login
        driver.findElement(By.id("user-name"))
               .sendKeys("standard_user");

        driver.findElement(By.id("password"))
               .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
               .click();
    }

    @Test
    public void addProductToCartTest() {

        // Add Sauce Labs Backpack to cart
        driver.findElement(
                By.id("add-to-cart-sauce-labs-backpack")
        ).click();

        // Open shopping cart
        driver.findElement(
                By.className("shopping_cart_link")
        ).click();

        // Verify product is in the cart
        String productName = driver.findElement(
                By.className("inventory_item_name")
        ).getText();

        System.out.println("Product in cart: " + productName);

        Assert.assertEquals(
                productName,
                "Sauce Labs Backpack"
        );
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}