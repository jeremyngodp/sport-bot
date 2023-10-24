package org.jeremy.bot.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class ApplicationPropertiesUtils {

    private static final String APPLICATION_PROPERTIES = "application.properties";
    public static String getAppProperties(String propName) throws IOException {

        String appPropertiesPath = Objects
                .requireNonNull(Thread.currentThread().getContextClassLoader().getResource(APPLICATION_PROPERTIES))
                .getPath();

        Properties prop = new Properties();

        prop.load(new FileInputStream(appPropertiesPath));

        return prop.getProperty(propName);
    }
}
