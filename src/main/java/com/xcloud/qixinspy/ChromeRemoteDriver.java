package com.xcloud.qixinspy;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeRemoteDriver {

    public static void main(String[] args) {
        URL serverurl = null;
        try {
            serverurl = new URL("http://127.0.0.1:9515");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        WebDriver driver = new RemoteWebDriver(serverurl, capabilities);
        driver.get("http://www.google.com");
        WebElement searchEdit = driver.findElement(By.name("q"));
        searchEdit.sendKeys("Selftechy on google");
        searchEdit.submit();

    }
}