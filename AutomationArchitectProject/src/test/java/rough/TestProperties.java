package rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    public static void main(String[] args) throws IOException {

        // print default project directory
        System.out.println(System.getProperty("user.dir"));

        Properties config = new Properties();
        Properties OR = new Properties();

        // load files data to Properties file
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resoureces\\properties\\Config.properties");
        config.load(fileInputStream);

        fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resoureces\\properties\\OR.properties");
        OR.load(fileInputStream);

        System.out.println(config.getProperty("browser"));

        // driver.findElement(By.cssSelector(OR.setProperty("bankManagerLogin"))).click();
        System.out.println(OR.getProperty("bankManagerLogin"));
    }
}
