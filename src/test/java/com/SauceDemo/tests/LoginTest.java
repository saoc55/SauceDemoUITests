package com.SauceDemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.DriverFactory;
import utils.ScreenShot;


public class LoginTest {
    WebDriver driver ; // = new ChromeDriver();

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void testValidLogin() {
        /*WebElement userName = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement button = driver.findElement(By.id("login-button"));

        userName.click();
        userName.sendKeys("standard_user");

        password.click();
        password.sendKeys("secret_sauce");

        button.click();*/

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
        // Assert successful login by checking URL
        assert driver.getCurrentUrl().contains("inventory");
    }

    @Test
    public void testInvalidLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("invalid_user","wrong_password");

        assert driver.findElement(By.cssSelector("[data-test='error']")).isDisplayed();
    }

    @Test
    public void testLogout(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");

        // open menu
        driver.findElement(By.id("react-burger-menu-btn")).click();

        //wait for menu to open (replace with WebdriverWait)
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        // click logout
        driver.findElement(By.id("logout_sidebar_link")).click();

        //Assert redirection to loginPage
        assert driver.getCurrentUrl().contains("saucedemo.com");
        assert driver.findElement(By.id("login-button")).isDisplayed();
        }


    @AfterMethod
    public void teardown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            ScreenShot.captureScreenShot(driver, result.getName());
        }
        driver.quit();
    }
}