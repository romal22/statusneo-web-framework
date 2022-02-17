package com.statusneo;

import com.statusneo.framework.TestBase;
import org.testng.annotations.Test;

/**
 * Class to test the framework
 *
 * @author ikumar
 */
public class FrameworkTests extends TestBase {

    @Test
    public void verifyHomePageTest() {
        app.start("http://statusneo.com");
    }


}
