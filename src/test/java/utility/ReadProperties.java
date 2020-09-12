package utility;

import java.io.*;
import java.util.Properties;

public class ReadProperties {
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

    public void writeprop(String key, String value) {
        try {
           // final OutputStream output = new FileOutputStream(propertyFilePath);
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(propertyFilePath, true)));

            // set the properties value
            prop.setProperty(key, value);

            // save properties to project root folder
            prop.store(output, null);

            // get the property value and print it out

        } catch (final Exception e) {
        }
        // return prop.getProperty(key);
    }
}