package com.selenium.Dome;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class pageLoadStrategy {
    @Test
    public void pageLoadStra(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        try{
            webDriver.get("https://www.baidu.com/");
        }finally {
            webDriver.quit();
        }
    }

    @Test
    public void pageLoadStrategyEAGER(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        WebDriver driver = new ChromeDriver(chromeOptions);

        try{
            driver.get("https://www.baidu.com/");
        }finally {
           // driver.quit();
        }
    }
    @Test
    public void pageLoadStrategynone(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        WebDriver driver = new ChromeDriver(chromeOptions);

        try{
            driver.get("https://www.baidu.com/");
        }finally {

        }
    }

    @Test
    public void webDriver(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com/");

    }

    @Test
    public void ProxyTest(){
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("<HOST:PORT>");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("proxy",proxy);

        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.baidu.com/");
        driver.manage().window().maximize();


    }

}
