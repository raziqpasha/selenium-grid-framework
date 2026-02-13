package org.deploymentproject.base;


import org.deploymentproject.utilities.AllureManager;
import org.deploymentproject.utilities.ConfigReader;
import org.deploymentproject.utilities.DriverFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

    @BeforeMethod
    public void setup() {
        DriverFactory.initDriver();
        DriverFactory.getDriver().get(ConfigReader.get("url"));
    }

    @AfterMethod
    public void teardown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            AllureManager.attachScreenshot();
        }

        DriverFactory.quitDriver();
    }
}
