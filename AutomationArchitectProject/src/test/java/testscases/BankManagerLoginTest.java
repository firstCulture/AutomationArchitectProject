package testscases;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankManagerLoginTest extends TestBase {

    @Test
    public void loginAsBankManager() throws InterruptedException {
        driver.findElement(By.cssSelector(OR.getProperty("bankManagerLogin"))).click();
        logger.info("The button is successfully  clicked!");

        Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustomer"))), "Login was not successful!");
        Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("openAccount"))), "Login was not successful!");
        Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("customers"))), "Login was not successful!");
    }

}
