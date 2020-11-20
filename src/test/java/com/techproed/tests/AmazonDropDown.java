package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class AmazonDropDown extends TestBase {
    //1.Tests packagenin altinda bir class olusturun: AmazonDropdown

    @Test
    public void dropDownTest() {
        // 2.https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");

        // 3.Dropdown elementini bulun.
        WebElement dropDownBox = driver.findElement(By.id("searchDropdownBox"));

        // 4.İlk seçilen seçeneği(firstSelectedOption)  konsolda yazdırın ve ilk secenegin “All Departments” ile esit oldugunu dogrulayin.
        Select options = new Select(dropDownBox);
        String firstOptions = options.getFirstSelectedOption().getText();
        System.out.println("FIRST OPTION : "+firstOptions + "\n");
        Assert.assertEquals(firstOptions,"All Departments");

        // 5.6.seçeneği(option) index kullanarak secin ve 6.seçeneğin “Books” oldugunu dogrulayin.
        // (Seçtikten sonra getFirstSelectedOption() metodunu kullanmanız gerekir)
        options.selectByIndex(5);
        String sixthOption = options.getFirstSelectedOption().getText();
        Assert.assertEquals(sixthOption,"Books");

        // 6.Butun dropdown seçeneklerini konsolda yazdırın
        List<WebElement> allOptions = options.getOptions();

        for (WebElement option : allOptions) {
            System.out.println(option.getText());
        }

        // 7.Dropdowndaki eleman sayisini konsolda yazdırın
        System.out.println("DROPDOWN ELEMAN SAYISI : " + allOptions.size());

        // 8.“Electronics” ın dropdownda olup olmadığını kontrol edin.
        // “Electronics” dropdownda bulunuyorsa konsolda True yazdırın. Aksi takdirde False yazdırın.

        boolean flag = false;
        for (WebElement option : allOptions) {
            if(option.getText().equals("Electronics"))  {
                flag = true;
                break;
            }
        }

        System.out.println(flag);

    }
}
