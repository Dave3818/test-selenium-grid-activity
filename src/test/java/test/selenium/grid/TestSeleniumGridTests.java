package test.selenium.grid;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestSeleniumGridTests {

    WebDriver driver;
    String baseURL, nodeURL;

    @BeforeTest
    public void setUp() throws MalformedURLException {


        baseURL = "http://demo.guru99.com/test/guru99home/";
        nodeURL = "http://192.168.1.95:4444/wd/hub";
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setBrowserName("chrome");
        capability.setPlatform(Platform.WINDOWS);
        ChromeOptions options = new ChromeOptions();
        options.merge(capability);
        options.setHeadless(true);
        driver = new RemoteWebDriver(new URL(nodeURL), options);
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

    @Test
    public void sampleTest2() {
        driver.get(baseURL);


        if (driver.getPageSource().contains("MOBILE TESTING")) {
            Assert.assertTrue(true, "Mobile Testing Link Found");
        } else {
            Assert.assertTrue(false, "Failed: Link not found");
        }

        System.out.println("ThreadCount: "+ Thread.currentThread().getId());
    }

    @Test
    public void sampleTest3() {
        driver.get(baseURL);


        if (driver.getPageSource().contains("MOBILE TESTING")) {
            Assert.assertTrue(true, "Mobile Testing Link Found");
        } else {
            Assert.assertTrue(false, "Failed: Link not found");
        }

        System.out.println("ThreadCount: "+ Thread.currentThread().getId());
    }



}
