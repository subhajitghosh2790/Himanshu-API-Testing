package utility;

import java.io.*;
import java.util.Properties;

public class PropertiesConfigure {
    Properties prop = new Properties();

    String propertyFilePath = System.getProperty("prop.file");


    public String readprop(String key) {

        try {

            final InputStream input = new FileInputStream(propertyFilePath);

            // load a properties file
            prop.load(input);

            // get the property value and print it out

        } catch (final Exception e) {
        }
        return prop.getProperty(key);
    }
}