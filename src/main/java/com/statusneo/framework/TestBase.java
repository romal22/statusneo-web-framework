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

    protected ThreadLocal<BrowserInstance> browserInstance = new ThreadLocal<>();
    protected static final String DEFAULT_PROVIDER = "defaultConfig";

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodTestBase(ITestContext iTestContext, Method method, Object[] params) {
        getBrowserInstance().start("NA");
        log.info("beforeMethodTestBase() called");
    }


    @AfterMethod(alwaysRun = true)
    public void afterMethodTestBase(ITestResult result) {
        log.info("afterMethodTestBase() called");
        getDriver().quit();
       // log.info("Test log for " + getBrowserInstance().getTestName() + " is available at " + getBrowserInstance().getLogger().getLogFilePath());
    }

    private BrowserInstance getBrowserInstance() {
        return browserInstance.get();
    }

    public WebDriver getDriver() {
        return getBrowserInstance().getDriver();
    }
}
