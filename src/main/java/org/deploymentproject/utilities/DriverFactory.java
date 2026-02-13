package org.deploymentproject.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;

import java.net.URL;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    // ThreadLocal = Supports parallel execution

    public static void initDriver() {

        String browser = ConfigReader.get("browser");
        String gridUrl = ConfigReader.get("grid.url");

        try {

            switch (browser.toLowerCase()) {

                case "chrome":
                    driver.set(new RemoteWebDriver(
                            new URL(gridUrl),
                            new ChromeOptions()));   // Chrome capability
                    break;

                case "firefox":
                    driver.set(new RemoteWebDriver(
                            new URL(gridUrl),
                            new FirefoxOptions()));  // Firefox capability
                    break;

                case "edge":
                    driver.set(new RemoteWebDriver(
                            new URL(gridUrl),
                            new EdgeOptions()));     // Edge capability
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        driver.get().quit();
        driver.remove();
    }
}
