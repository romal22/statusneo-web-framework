package com.statusneo.framework;


import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

/**
 * Class contains the Pre-requisite setup before running a Test Case
 *
 * @author ikumar
 */
@Log4j2
public class TestBase {

    protected static final String DEFAULT_PROVIDER = "defaultConfig";
    protected BrowserInstance app;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodTestBase(ITestContext iTestContext, Method method, Object[] params) {
        app = new BrowserInstance();
        log.info("beforeMethodTestBase() called");
    }


    @AfterMethod(alwaysRun = true)
    public void afterMethodTestBase(ITestResult result) {
        log.info("afterMethodTestBase() called");
        getDriver().quit();
    }

    private BrowserInstance getBrowserInstance() {
        return app;
    }

    public WebDriver getDriver() {
        return getBrowserInstance().getDriver();
    }
}
