package com.coherent.aqa.java.training.web.korobeynik.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;


public class CommonUtils {

    public static String getPropertyValue(String property) {
        String value = null;
        try (InputStream input = Files.newInputStream(Paths.get("src/main/resources/config.properties"))) {
            Properties prop = new Properties();
            prop.load(input);
            value = prop.getProperty(property);
        } catch (NullPointerException | IOException e) {
            throw new RuntimeException("Something wrong with getting values for testing: " + e);
        }
        return value;
    }
}
