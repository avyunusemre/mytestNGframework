package com.techproed.tests;
import com.techproed.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class HandlingAlerts extends TestBase {
    //Bir metod olusturun: acceptAlert
    //Bir metod olusturun: dismissAlert

    //Bir metod olusturun: sendKeysAlert
    //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.


    @Test
    public void acceptAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //1. butona tıklayın, uyarıdaki(alert) OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
        // locate 1. buton
        WebElement buton1 = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        buton1.click();
        //Alert uzerindeki mesaji konsolda yazdir.
        System.out.println("Alert mesaji: " + driver.switchTo().alert().getText());
        // uyarıdaki(alert) OK butonuna tıklayın
        driver.switchTo().alert().accept();// accept() => click ok demektir.
        WebElement resultMesaj = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(resultMesaj.isDisplayed()); //Hard assert

    }

    @Test
    public void dismissAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
        WebElement buton2 = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        buton2.click();
        driver.switchTo().alert().dismiss(); //dismiss() => Cancel butonuna basmak demektir.
        WebElement resultMesaj2 = driver.findElement(By.xpath("//p[@id='result']"));
        String actualResult = resultMesaj2.getText();
        String expectedResult = "You clicked: Cancel";
        Assert.assertEquals(actualResult,expectedResult); //Hard assert
    }
    @Test
    public void sendKeysAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement buton3 = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        buton3.click();
        driver.switchTo().alert().sendKeys("Yunus Emre");
        driver.switchTo().alert().accept();
        //result mesajinin goruntulendigini dogrulayin
        WebElement resultMesaj = driver.findElement(By.id("result"));
        System.out.println(resultMesaj.getText());
        Assert.assertTrue(resultMesaj.isDisplayed());
    }


}