package org.deploymentproject.testcase;



import org.deploymentproject.pages.LoginPage;
import org.deploymentproject.base.BaseTest;
import org.deploymentproject.utilities.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLogin() {

        LoginPage loginPage = new LoginPage();
        loginPage.login("Admin", "admin123");

        String title = DriverFactory.getDriver().getTitle();
        Assert.assertTrue(title.contains("Orange"));
    }
}
