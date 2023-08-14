package com.selenium.Dome;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteWebDriver {
    @Test
    public void RemoteDriver()  {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
            WebDriver driver = new ChromeDriver(chromeOptions);
    }
}
