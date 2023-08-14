package com.selenium.Dome;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriverService;

public class DriverServiceClass {

    @Test
    public void driverService(){
        ChromeDriverService driverService = new ChromeDriverService.Builder().build();
    }
}
