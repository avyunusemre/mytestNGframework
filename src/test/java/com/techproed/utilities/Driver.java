package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    //Driver class, driver instance'i baslatmak icin kullanilir.(Singleton Driver)
    //Ihtıyacımız olduğunda driver'i kurmak ve basşlatmak icin kullanırız.
    //Driver null olduğundan create edip baslatacağız.(if(driver==null))
    //Driver classi farkli browserlar ile de kullanacağız şekilde olusturacağız.

    private Driver() {
        //Baska obje olusturulmasini istemediğimiz icin create ediyoruz.
    }

    //driver instance olusturalım
    static WebDriver driver;

    public static WebDriver getDriver() {
        if(driver==null) {
            switch (ConfigReader.getProperty("browser")) {
                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox" :
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "safari" :
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;
                case "headless-chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
            }

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static void closeDriver() {
        if(driver!=null) {
            driver.quit();
            driver=null;
        }
    }
}
