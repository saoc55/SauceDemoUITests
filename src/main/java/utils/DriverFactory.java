package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


    public class DriverFactory {
        private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

         public static WebDriver getDriver() {
             // Check if driver is null OR if the browser session is invalid (optional but safer)
             if (driverThread.get() == null) {
                 ChromeOptions options = new ChromeOptions();
                 options.addArguments("--headless=new");
                 options.addArguments("--window-size=1920,1080");
                 driverThread.set(new ChromeDriver(options));
            }
             return driverThread.get();
        }

    public static void quitDriver() {
         if(driverThread.get() != null) {
             driverThread.get().quit();
             driverThread.remove();
         }
    }

}
