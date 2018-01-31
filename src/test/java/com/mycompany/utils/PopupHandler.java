package com.mycompany.utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

//ToDO use Java dynamic proxies
// www.testautomationguru.com/selenium-webdriver-how-to-handle-annoying-random-popup-alerts
public class PopupHandler {
    public static void switchToOriginalWindow(WebDriver driver) {
        Set<String> handles = driver.getWindowHandles();
        if (handles.size() > 1) {
            driver.switchTo().window(handles.toArray(new String[handles.size()])[1]);
            System.out.println("Switching to window : " + handles.toArray(new String[handles.size()])[1] );
        }
    }
}
