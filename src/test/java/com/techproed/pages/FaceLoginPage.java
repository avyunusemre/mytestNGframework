package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceLoginPage {
    //create driver
    WebDriver driver;
    //constructor kullanarak driver'i baslatalım
    public FaceLoginPage(WebDriver driver) {
        this.driver = driver;
        //page objelerini baslatmak icin kullaniyoruz
        PageFactory.initElements(driver,this);

    }

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "pass")
    public WebElement password;

    @FindBy(id = "u_0_b")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement error_mesaj;

}
