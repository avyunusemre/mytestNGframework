package com.techproed.tests;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class WebTables extends TestBase {

    //    login() metodun oluşturun ve oturum açın.
    public void login(){
        driver.get("http://www.fhctrip.com/admin/HotelRoomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager2");     //Username : manager2;
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");   //Password : Man1ager2!;
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test
    public void table() throws InterruptedException {
        login();
        // tbody'deki datalari konsolda yazdirin
        Thread.sleep(3000);
        WebElement tbody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tbody.getText());
        //        Tüm table body’sinin boyutunu(size) bulun. kac tane hucre var(cell)
        List<WebElement> table = driver.findElements(By.xpath("//tbody//td"));
        System.out.println("TABLE BODY SIZE : " + table.size());
//        Table’daki başlıkları(headers) konsolda yazdırın.
        List<WebElement> allHeaders = driver.findElements(By.tagName("th"));
        for(WebElement header : allHeaders){
            System.out.println(header.getText());
        }
    }
    @Test
    public void printRows() {
        login();
        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        System.out.println("Table body'de toplam " + driver.findElements(By.xpath("//tbody//tr")).size() + " tane satir(row) vardir.");
        //Table body’sinde bulunan satirlari(rows)  konsolda yazdırın.
        List<WebElement> allRows = driver.findElements(By.xpath("//tbody//tr"));
        for (WebElement row : allRows) {
            System.out.println(row.getText());
        }
        //4.satirdaki(row) elementleri konsolda yazdırın.
        List<WebElement> elementsRow4 = driver.findElements(By.xpath("//tr[4]//td"));
        for (WebElement element : elementsRow4) {
            System.out.println(element.getText());
            }
        }

        //printCells() metodu oluşturun
        @Test
        public void printCells() {
            login();
            //table body’sinde bulunan toplam hücre(cell) sayısını bulun.
            System.out.println("Tabloda toplam " + driver.findElements(By.xpath("//tbody//td")).size() + " tane hucre(cell) vardır.");
            //Table body'sinde bulunan hücreleri(cells)  konsolda yazdırın.
            List<WebElement> allCells = driver.findElements(By.xpath("//tbody//td"));
            for (WebElement cell:allCells) {
                System.out.println(cell.getText());
            }

        }
        //printColumns() metodu oluşturun
        @Test
        public void printColumns() {
            login();
            //table body’sinde bulunan toplam sutun(column) sayısını bulun.
            System.out.println("Tabloda toplam " + driver.findElements(By.xpath("//th")).size() + " tane sutun(column) vardir.");
            //5.column daki elementleri  konsolda yazdırın.
            List<WebElement> column5 = driver.findElements(By.xpath("//tbody//td[5]"));
            //Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
            for (WebElement element : column5) {
                System.out.println(element.getText());
            }

        }

        public void printData (int row, int column) {
            String xpath ="//tbody//tr["+row+"]//td["+column+"]";
            WebElement data = driver.findElement(By.xpath(xpath));
            System.out.println(data.getText());
        }

        @Test
        public void printDataTest() {
            login();
            printData(8,3);
            printData(5,2);
            printData(9,5);

        }



}