package main.java;

import java.io.InputStream;
import java.util.Properties;

public class Util {

    public static String getConfig(String propertiesKey) {
        try (InputStream input = Util.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                throw new IllegalStateException("Unable to find config.properties");
            }
            prop.load(input);
            String value = prop.getProperty(propertiesKey);
            if (value == null || value.isBlank()) {
                throw new IllegalStateException(
                        "Key " + propertiesKey + " not found in config.properties or is empty.");
            }
            return value;
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error reading config.properties for key: " + propertiesKey + ". " + e.getMessage(), e);
        }
    }

    public static String getToken(String envName) {
        String env = getAppEnvOrDefault(envName, "TEST").toUpperCase();
        System.out.println("Using environment: " + env);
        String tokenVar = env.equals("PROD") ? "WISE_PROD_READ_TOKEN" : "WISE_TEST_READ_TOKEN";

        String token = System.getenv(tokenVar);
        System.out.println("Using token from environment variable: " + tokenVar);
        if (token == null || token.isBlank()) {
            throw new IllegalStateException("Environment variable " + tokenVar
                    + " is not set or is empty. Please set it to your Wise API token.");
        }
        return token;
    }

    public static String getAppEnvOrDefault(String envName, String defaultValue) {
        String resolvedEnvName = (envName == null || envName.isBlank()) ? "APP_ENV" : envName;
        String value = System.getenv(resolvedEnvName);

        return (value == null || value.isBlank()) ? defaultValue : value;
    }

}
