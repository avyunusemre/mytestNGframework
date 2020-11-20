package com.techproed.smoketest;

import com.techproed.pages.GlbSignInPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTestGlbSignIn {

    @Test(groups = "group test1")
    public void gecersizEmail() {
        Driver.getDriver().get(ConfigReader.getProperty("glb_signIn_url"));

        GlbSignInPage glbSignInPage = new GlbSignInPage();
        glbSignInPage.email.sendKeys(ConfigReader.getProperty("negative_test_email"));
        glbSignInPage.password.sendKeys(ConfigReader.getProperty("test_password"));
        glbSignInPage.loginButton.click();

        Assert.assertTrue(glbSignInPage.alertMesaj.isDisplayed());
    }

    @Test(groups = "group test1")
    public void gecersizPassword() {
        Driver.getDriver().get(ConfigReader.getProperty("glb_signIn_url"));

        GlbSignInPage glbSignInPage = new GlbSignInPage();
        glbSignInPage.email.sendKeys(ConfigReader.getProperty("test_email"));
        glbSignInPage.password.sendKeys(ConfigReader.getProperty("negative_test_password"));
        glbSignInPage.loginButton.click();

        Assert.assertTrue(glbSignInPage.alertMesaj.isDisplayed());
    }

    @Test
    public void gecersizAccount() {
        Driver.getDriver().get(ConfigReader.getProperty("glb_signIn_url"));

        GlbSignInPage glbSignInPage = new GlbSignInPage();
        glbSignInPage.email.sendKeys(ConfigReader.getProperty("negative_test_email"));
        glbSignInPage.password.sendKeys(ConfigReader.getProperty("negative_test_password"));
        glbSignInPage.loginButton.click();

        Assert.assertTrue(glbSignInPage.alertMesaj.isDisplayed());
    }
}
