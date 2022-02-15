package com.statusneo.framework;

import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

/**
 * Class contains all the properties required to configure the driver
 *
 * @author ikumar
 */
@Log4j2
public class Configuration {

    private static Properties prop;

    /* Browser Configuration */
    public static final String EXECUTION_ENVIRONMENT = getValue("execution.environment");
    public static final String BROWSER = getValue("local.browser");


    /* Driver Configuration */
    public static final long DEFAULT_IMPLICIT_TIMEOUT = Long.parseLong(getValue("timeout.implicit"));
    public static final long DEFAULT_EXPLICIT_TIMEOUT = Long.parseLong(getValue("timeout.explicit"));

    private static Properties getProp() {
        if (prop == null) {
            prop = new Properties();
            InputStream input;
            try {
                input = new FileInputStream(new File("config.properties"));
                prop.load(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return prop;
    }

    /**
     * Initially checks for any environment variable. If null
     * Checks for the property value which is set either from the terminal/console. If null
     * Gets the default value from the config file
     *
     * @param propertyName Property Key set from Environment variables/Maven command line/config
     * @return propertyValue
     */
    public static String getValue(String propertyName) {
        String propertyValue = System.getenv(propertyName);
        log.debug("Environment variable for [" + propertyName + "] = [" + propertyValue + "]");

        if (Objects.isNull(propertyValue)) {
            propertyValue = Objects.isNull(System.getProperty(propertyName)) ? getProp().getProperty(propertyName) : System.getProperty(propertyName);
        }
        log.info("[" + propertyName + "] value set to [" + propertyValue + "]");
        return propertyValue;
    }
}
