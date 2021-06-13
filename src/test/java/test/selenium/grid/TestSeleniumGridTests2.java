package test.selenium.grid;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestSeleniumGridTests2 {

    WebDriver driver;
    String baseURL, nodeURL;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        baseURL = "http://demo.guru99.com/test/guru99home/";
        nodeURL = "http://192.168.1.95:4444/wd/hub";
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setBrowserName("firefox");
        capability.setPlatform(Platform.WINDOWS);
        FirefoxOptions ffox = new FirefoxOptions();
        ffox.merge(capability);

        driver = new RemoteWebDriver(new URL(nodeURL), ffox);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
    @Test
    public void sampleTest() {
        driver.get(baseURL);


        if (driver.getPageSource().contains("MOBILE TESTING")) {
            Assert.assertTrue(true, "Mobile Testing Link Found");
        } else {
            Assert.assertTrue(false, "Failed: Link not found");
        }
        System.out.println("ThreadCount: "+ Thread.currentThread().getId());
    }



}
