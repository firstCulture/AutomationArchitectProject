package utilities;

import base.TestBase;
import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class TestUtil extends TestBase {

    public static String screenshotPath;
    public static String screenshotName;

    public static void captureScreenshot() throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        screenshotName = "error.jpg";
        FileUtils.getFileUtils().copyFile(screenshotFile, new File(System.getProperty("user.dir") + "\\target\\surefire-reportsm\\" + screenshotName));
    }


}
