package testscases;

import base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCustomerTest extends TestBase {

    @Test(dataProvider = "getData")
    public void addCustomer(String firstName, String lastName, String postCode, String alertMessage) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(OR.getProperty("addCustomer"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(OR.getProperty("firstName"))).sendKeys(firstName);
        Thread.sleep(1000);
        driver.findElement(By.xpath(OR.getProperty("lastName"))).sendKeys(lastName);
        Thread.sleep(1000);
        driver.findElement(By.xpath(OR.getProperty("postCode"))).sendKeys(postCode);
        Thread.sleep(1000);
        driver.findElement(By.xpath(OR.getProperty("addCustomerButton"))).click();
        Thread.sleep(1000);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alert.getText().contains(alertMessage), "The customer is successfully added!!!");
        alert.accept();
        Thread.sleep(1000);

    }

    @DataProvider
    public Object[][] getData() {
        String sheetName = "AddCustomerTest";
        int rows = excelReader.getRowCount(sheetName);
        int cols = excelReader.getColumnCount(sheetName);

        Object[][] data = new Object[rows - 1][cols];

        for (int rowNum = 2; rowNum <= rows; rowNum++) {

            for (int colNum = 0; colNum < cols; colNum++) {
                data[rowNum - 2][colNum] = excelReader.getCellData(sheetName, colNum, rowNum);
            }
        }

        return data;
    }
}
