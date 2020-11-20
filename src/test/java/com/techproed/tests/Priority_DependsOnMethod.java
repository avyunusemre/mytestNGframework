package com.techproed.tests;

import org.testng.annotations.Test;

public class Priority_DependsOnMethod {

    @Test(priority = 4)
    public void login() {
        System.out.println("Bu metod login metodu");
    }

    @Test(priority = 9, dependsOnMethods = "login")
    public void homePage() {
        System.out.println("Bu metod homepage metodu");
    }

    @Test(priority = 10)
    public void search() {
        System.out.println("Bu metod search metodu");
    }

    @Test(priority = 12, dependsOnMethods = "search")
    public void result() {
        System.out.println("Bu metod result metodu");
    }
}
