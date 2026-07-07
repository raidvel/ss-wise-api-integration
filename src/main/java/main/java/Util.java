package main.java;

import java.io.InputStream;
import java.util.Properties;

public class Util {

    public static String getToken(String tokenName) {
        try (InputStream input = Util.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IllegalStateException("config.properties not found on classpath");
            }
            Properties prop = new Properties();
            prop.load(input);
            return prop.getProperty(tokenName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
