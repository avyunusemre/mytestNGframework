package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownload extends TestBase {
    //Tests packagenin altina bir class oluşturun : FileDownload
    //Iki tane metod oluşturun : isExist() ve downloadTest()

    @Test
    public void isExist() {
        String mevcutKlasor = System.getProperty("user.dir");
        System.out.println("MEVCUT KLASOR => " + mevcutKlasor);

        String userKlasor = System.getProperty("user.home");
        System.out.println("USER KLASOR => " + userKlasor);

        String filePath = userKlasor + "/Desktop/YAZILIM/logos/apple.png";

        boolean isFileExist = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isFileExist);
    }
    //downloadTest () metodunun icinde aşağıdaki testi yapın:
    @Test
    public void downloadTest() throws InterruptedException {
        //https://the-internet.herokuapp.com/download adresine gidin.
        driver.get("https://the-internet.herokuapp.com/download");
        //image1.jpg dosyasını indir
        WebElement image1 = driver.findElement(By.linkText("image1.jpg"));
        image1.click();
        //Dosyanın yuklenmesi icin zamana ihtiyacı olabilir.
        Thread.sleep(5000);//HARD WAIT
        //Ardından dosyanın başarıyla indirilip indirilmediğini doğrulayın.

        String userKlasor = System.getProperty("user.home");

        String filePath = userKlasor + "/Downloads/image1.jpg";

        boolean isDownladed = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isDownladed);
    }




}
