package com.selenium.Dome;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testDome1 {
    private static Logger  logger = Logger.getLogger(testDome1.class.getName());
    WebDriver  driver = new ChromeDriver();

    @Test
    public void stast(){
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        DOMConfigurator.configure("log4j.xml");

        logger.info("+++++++打开服务器连接++++++++");
        String title = driver.getTitle();
        assertEquals("Web form", title);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        WebElement textBox  = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));
        textBox.sendKeys("Selenium");
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));

        String value  = message.getText();
        assertEquals("Received!", value);
        driver.quit();
    }
}
