package com.config;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static com.executionEngine.DriverScript.OR;

import  com.utility.Log;
public class ActionsKeywords {

    private static WebDriver driver;
    /**
     * 以下方法，我们针对dataengine.xlsx文件中的action_keyword这列的关键字都进行封装
     * 等关键字框架快设计完了，我们再来调整，读取配置文件去启动不同测试浏览器和测试地址
     * 这样就不会代码写死这两个参数
     * */
    public static void openBrowser(String object){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Log.info("启动浏览器并最大化");
    }

    public static void openUrl(String object) throws InterruptedException {
        driver.get(Constants.URL);
        Thread.sleep(500);
        Log.info("打开登录连接");
    }

    public static void click(String object){
        //driver.findElement(By.xpath(".//*[@id='u1']/a[text()='登录']")).click();
        //driver.findElement(By.id("TANGRAM__PSP_11__changePwdCodeItem")).click();
        driver.findElement(By.xpath(OR.getProperty(object))).click();
        Log.info("点击元素");
    }

    public static void input(String object){
      //  driver.findElement(By.id("TANGRAM__PSP_11__userName")).sendKeys(Constants.Username);
        driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Constants.Username);
    }

//    public static void input_Password(String object){
//        driver.findElement(By.id("TANGRAM__PSP_11__password")).sendKeys(Constants.Password);
//    }

//    public static void click_Submit(){
//        driver.findElement(By.id("TANGRAM__PSP_11__submit")).click();
//    }

    public static void waiatFor() throws InterruptedException {
        Thread.sleep(3000);
    }
    public static void closeBrowser(){
        driver.quit();
    }
}
