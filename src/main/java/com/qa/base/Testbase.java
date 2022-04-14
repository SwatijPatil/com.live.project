package com.qa.base;

import com.qa.utility.Util;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Testbase {
    public WebDriver driver;
    public static Properties config;
    public Testbase() {
        try {
           config = new Properties();
            FileInputStream fis = new FileInputStream("C:\\Users\\Swati\\com.live.project\\src\\main\\java\\com\\qa\\utility\\confi.properties");
            config.load(fis);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    public WebDriver intialisation() {
        String browser_name = config.getProperty("browser");
        System.out.println(config.getProperty("browser"));
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Util.PAGELOAD, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Util.IMPLICITLY_WAIT, TimeUnit.SECONDS);
        driver.get(config.getProperty("url"));
        return driver;
         }
}
