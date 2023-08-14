package executionEngine;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverScript {

    @Test
    public void login() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        WebDriver  driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.get("https://www.baidu.com");
        Thread.sleep(2000);

        driver.findElement(By.xpath(".//*[@id='u1']/a[text()='登录']")).click();
        // 点击账号密码登录
        driver.findElement(By.id("TANGRAM__PSP_11__changePwdCodeItem")).click();


        driver.findElement(By.id("TANGRAM__PSP_11__userName")).sendKeys("xxxxx");

        driver.findElement(By.id("TANGRAM__PSP_11__password")).sendKeys("xxxxx");
        driver.findElement(By.id("TANGRAM__PSP_11__submit")).click();


    }

}
