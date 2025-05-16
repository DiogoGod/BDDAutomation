package com.web.automation.base;

import com.web.automation.utility.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.IOException;

public class DriverInstance {
    static WebDriver driver= null;
    public static void startDriverInstance() throws IOException {
       if( ConfigReader.readProjectConfiguration("BrowserName").equalsIgnoreCase("Chrome")){
         System.setProperty("webdriver.chrome.driver", "Driver/chromedriver");
         driver = new ChromeDriver();
       }
       else if(ConfigReader.readProjectConfiguration("BrowserName").equalsIgnoreCase("Firefox")){
        System.setProperty("webdriver.gecko.driver", "Driver/geckodriver.exe");
        driver= new ChromeDriver();
       }
       else if(ConfigReader.readProjectConfiguration("BrowserName").equalsIgnoreCase("IE")){
        System.setProperty("webdriver.ie.driver", "Driver/InternetExplorerDriver.exe");
        driver= new InternetExplorerDriver();
       }
       else{
           System.setProperty("webdriver.chrome.driver", "Driver/chromedriver");
           driver = new ChromeDriver();
       }
    driver.manage().window().maximize();
    driver.get(ConfigReader.readProjectConfiguration("ApplicationURL"));

    }

    public  WebDriver getDriverInstance() throws IOException {
        if(driver!=null){
            return driver;
        }
        else{
            DriverInstance.startDriverInstance();
            return driver;
        }
    }
public static void setDriverInstanceToNull()
{
driver= null;
}


}
