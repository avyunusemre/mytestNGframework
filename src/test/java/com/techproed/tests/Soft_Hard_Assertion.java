package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Soft_Hard_Assertion {
    //Class name : Soft_Hard_Assertion
    //http://a.testaddressbook.com/sign_in adresine gidin.
    //email textbox,password textbox, ve signin button elementlerini locate edin.
    //Aşağıdaki username ve password girin ve signin buttonuna tıklayın.
    //Username :  testtechproed@gmail.com
    //Password :   Test1234!
    //Daha sonra farklı iddialar(assertions) kullanarak sayfaya doğru giriş yaptığınızı doğrulayın.
    //Daha sonra farklı iddialar(assertions) kullanarak testtechproed@gmail.com beklenen kullanıcı  kimliğinin(userID) doğrulayın
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://a.testaddressbook.com/sign_in");
    }

    @Test
    public void login() {
        WebElement emailBox = driver.findElement(By.id("session_email"));
        emailBox.sendKeys("testtechproed@gmail.com");

        WebElement passwordBox = driver.findElement(By.id("session_password"));
        passwordBox.sendKeys("Test1234!");

        WebElement signInButton = driver.findElement(By.name("commit"));
        signInButton.click();
    }

    @Test(dependsOnMethods = "login")
    public void homePage() {
        WebElement welcomeMessage = driver.findElement(By.xpath("//h1[.='Welcome to Address Book']"));
        System.out.println(welcomeMessage.getText());
        //Assert.assertTrue(welcomeMessage.isDisplayed());
        System.out.println("Hard assert fail olursa bu satir calismayacak");

        //SOFT ASSERT
        //1. adim : create object
        SoftAssert softAssert = new SoftAssert();
        //2. adim : assertion icin olusturdugumuz objecti kullan
        //softAssert.assertTrue(!welcomeMessage.isDisplayed());//Fail
        softAssert.assertTrue(welcomeMessage.isDisplayed());//Pass
        //softAssert.assertEquals(3,5);//Fail
        //3. adim : assertAll(); ==> sonuna assertAll() yazmadıkca soft assert'te test hep pass olur.
        softAssert.assertAll(); // Bu satir cok ONEMLI. assertAll(), gercek assertionu yapar.
                                // assertionAll() kullanilmazsa test fail olmasi gerektiginde de pass olur.

        //Daha sonra farklı iddialar(assertions) kullanarak testtechproed@gmail.com beklenen kullanıcı  kimliğinin(userID) doğrulayın
        WebElement userID = driver.findElement(By.className("navbar-text"));
        String actualID = userID.getText();
        String expectedID = "testtechproed@gmail.com";
        Assert.assertEquals(actualID,expectedID);//Hard assert

        //SOFT ASSERT
        //2. adim
        softAssert.assertEquals(actualID,expectedID);
        //3. adim : assertAll();
        softAssert.assertAll();

        
    }


}
