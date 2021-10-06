package com.syntax.class08;

import com.syntax.utils.CommonMethods;

public class HW2 extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {
        String url = "https://the-internet.herokuapp.com/dynamic_controls";
        setUp(url);
        maximizeWindow();
        Thread.sleep(1000);
        navigateToURL("https://www.facebook.com/");
        Thread.sleep(1000);
        navigateBack();
        Thread.sleep(1000);
        navigateForward();
        implicitlyWait20sec();
        getUrl("https://www.amazon.com/");
        Thread.sleep(1000);
        navigateRefresh();
        Thread.sleep(1000);
        System.out.println(getCurrentUrl());
        System.out.println(getTitle());

    }
}
