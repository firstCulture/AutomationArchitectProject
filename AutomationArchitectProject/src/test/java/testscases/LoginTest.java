package testscases;

import base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginAsBankManager() throws InterruptedException {
        driver.findElement(By.cssSelector(OR.getProperty("bankManagerLogin"))).click();
        logger.info("The button is successfully  clicked!");
        Thread.sleep(3000);
    }


}
