package com.techproed.paralelTesting;

import org.testng.annotations.Test;

public class Test2 {

    @Test
    public void method4(){
        System.out.println("Test2 _ Method4");
        System.out.println("Method 4- Thread ID : "+Thread.currentThread().getId());
    }

    @Test
    public void method5(){
        System.out.println("Test2 _ Method5");
        System.out.println("Method 5- Thread ID : "+Thread.currentThread().getId());
    }

    @Test
    public void method6(){
        System.out.println("Test2 _ Method6");
        System.out.println("Method 6- Thread ID : "+Thread.currentThread().getId());
    }
}
