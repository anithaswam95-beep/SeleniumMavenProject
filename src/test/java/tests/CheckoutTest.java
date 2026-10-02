package tests;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {

        // Chrome options
        ChromeOptions options = new ChromeOptions();

        // Disable Chrome password manager notifications
       options.addArguments("--disable-notifications");
        options.addArguments("--disable-save-password-bubble");

        Map<String, Object> prefs = new HashMap<>();

        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);

        options.setExperimentalOption("prefs", prefs);

        // Start Chrome
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open SauceDemo
        driver.get("https://www.saucedemo.com/");

        // Login
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("user-name")))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
                .click();

        // Wait for Products page
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("title")));
    }

    @Test
    public void checkoutTest() {

        // 1. Add Sauce Labs Backpack
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("add-to-cart-sauce-labs-backpack")))
                .click();

        // 2. Verify cart count
        String cartCount = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.className("shopping_cart_badge")))
                .getText();

        System.out.println("Cart count: " + cartCount);

        Assert.assertEquals(cartCount, "1");

        // 3. Open shopping cart
        wait.until(ExpectedConditions.elementToBeClickable(
                By.className("shopping_cart_link")))
                .click();

        // 4. Verify product is in cart
        String productName = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.className("inventory_item_name")))
                .getText();

        System.out.println("Product in cart: " + productName);

        Assert.assertEquals(
                productName,
                "Sauce Labs Backpack");

        // 5. Wait for Checkout button
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("checkout")));

        // 6. Click Checkout
        driver.findElement(By.id("checkout"))
                .click();

        // 7. Wait for First Name field
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("first-name")));

        // 8. Enter First Name
        driver.findElement(By.id("first-name"))
                .sendKeys("Anitha");

        // 9. Enter Last Name
        driver.findElement(By.id("last-name"))
                .sendKeys("Test");

        // 10. Enter Zip Code
        driver.findElement(By.id("postal-code"))
                .sendKeys("20105");

        // 11. Click Continue
        driver.findElement(By.id("continue"))
                .click();

        // 12. Verify Checkout Overview
        String pageTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.className("title")))
                .getText();

        System.out.println("Page title: " + pageTitle);

        Assert.assertEquals(
                pageTitle,
                "Checkout: Overview");
    
 // Click Finish
    driver. findElement(By.id("finish")).click();

    // Verify order confirmation
    String confirmationMessage = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                    By.className("complete-header")))
            .getText();

    Assert.assertEquals(
            confirmationMessage,
            "Thank you for your order!");}
    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}