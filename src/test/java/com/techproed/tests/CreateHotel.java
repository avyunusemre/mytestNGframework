package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateHotel extends TestBase {

    //Tests packagenin altina class olusturun: CreateHotel

    //Bir method olusturun: createHotel
    @Test
    public void createHotel() throws InterruptedException {
        //http://www.fhctrip.com/admin/HotelAdmin/Create adresine gidin.
        driver.get("http://fhctrip-qa.com/Account/Logon");

        //Username textbox ve password textboxlarini locate edin ve asagidaki verileri girin.
        //Username : manager2
        //Password : Man1ager2!
        //Login butonuna basin.

        WebElement userName = driver.findElement(By.id("UserName"));
        WebElement password = driver.findElement(By.id("Password"));
        WebElement logInButton = driver.findElement(By.id("btnSubmit"));

        userName.sendKeys("manager2");
        password.sendKeys("Man1ager2!");
        logInButton.click();

        Thread.sleep(3000);
        //Acilan sayfadaki butun textboxlara istediginiz verileri girin (en sondaki dropdowna dikkat edin).
        WebElement codeBox = driver.findElement(By.id("Code"));
        codeBox.sendKeys("BUTIK");
        WebElement nameBox = driver.findElement(By.id("Name"));
        nameBox.sendKeys("Kalamıs");
        WebElement addressBox = driver.findElement(By.id("Address"));
        addressBox.sendKeys("Trabzon");
        WebElement phoneBox = driver.findElement(By.id("Phone"));
        phoneBox.sendKeys("0176 412 3232 12");
        WebElement emailBox = driver.findElement(By.id("Email"));
        emailBox.sendKeys("kalamisHotel_Trabzon@gmail.com");
        WebElement IDGroup = driver.findElement(By.id("IDGroup"));

        Select select = new Select(IDGroup);
        select.selectByIndex(1);

        //Save butonuna basin.
        WebElement saveElement = driver.findElement(By.id("btnSubmit"));
        saveElement.click();
        //“Hotel was inserted successfully” textinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver,10);
        boolean isTrue = wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='bootbox-body']"),"Hotel was inserted successfully"));
        Assert.assertTrue(isTrue);

        //OK butonuna tiklayin.
        WebElement okButton = driver.findElement(By.xpath("//button[@data-bb-handler='ok']"));
        okButton.click();
    }







}
