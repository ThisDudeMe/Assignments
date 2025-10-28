package se.sprinto.hakan.adventuregame;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class AppInfo {

    private static AppInfo instance;
    private Properties properties;

    private AppInfo() {

        properties = new Properties();
        loadProperties();


    }

    public static AppInfo getInstance() {

        if (instance == null) {
            instance = new AppInfo();
        }

        return instance;
    }

    private void loadProperties(){

        try (InputStream input = getClass().getClassLoader().getResourceAsStream("app.properties")) {

            if (input == null) {
                System.err.println("Could not find app.properties");
                return;
            }
            properties.load(input);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
    public String getAuthor(){

        return properties.getProperty("author");
    }

    public String getVersion(){

        return properties.getProperty("version");
    }

}
