package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleExample extends TestBase {
    //Tests package’inda yeni bir class olusturun: WindowHandleExample


    @Test
    public void newWindowTest() {
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("PARENT WINDOW HANDLE => " + parentWindowHandle);

        //Sayfadaki textin  “Opening a new window” olduğunu doğrulayın.
        String actualText = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(actualText,"Opening a new window");

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,"The Internet");

        //Click Here butonuna basın.
        WebElement clickHereButton = driver.findElement(By.linkText("Click Here"));
        clickHereButton.click();

        //Acilan yeni pencerenin sayfa başlığının (title)  “New Window” oldugunu dogrulayin.
        Set<String> allWindowHandle = driver.getWindowHandles();
        for (String childWindowHandle : allWindowHandle) {
            if(!childWindowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(childWindowHandle);
                System.out.println("CHILD WINDOW HANDLE => " + childWindowHandle);
            }
        }
        String newWindowTitle = driver.getTitle();
        Assert.assertEquals(newWindowTitle, "New Window");

        //Sayfadaki textin   “New Window” olduğunu doğrulayın.
        String newWindowText = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(newWindowText, "New Window");

        //Bir önceki pencereye geri döndükten sonra sayfa başlığının  “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(parentWindowHandle);
        String exTitle = driver.getTitle();
        Assert.assertEquals(exTitle,"The Internet");

    }

}
