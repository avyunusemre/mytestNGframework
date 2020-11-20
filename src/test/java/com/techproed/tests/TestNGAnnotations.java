package com.techproed.tests;

import org.testng.annotations.*;

public class TestNGAnnotations {
    @Ignore //@Ignore sadece test annatation'ını gormezden gelir.Aksi taktirde calismaz
    @BeforeMethod
    public void BeforeMethod() {
        System.out.println("===========Before Method============");
    }

    @BeforeClass
    public void BeforeClass() {
        System.out.println("===========Before Class===========");
    }


    @Test
    public void test1() {
        System.out.println("Bu Test1 metodudur.");
    }

    @Test
    public void test2() {
        System.out.println("Bu Test2 metodudur.");
    }

    @Ignore
    @Test
    public void test3() {
        System.out.println("Bu Test3 metodudur.");
    }

    @AfterMethod
    public void AfterMethod() {
        System.out.println("===========After Method============");
    }

    @AfterClass
    public void AfterClass() {
        System.out.println("===========After Class==============");
    }


}
