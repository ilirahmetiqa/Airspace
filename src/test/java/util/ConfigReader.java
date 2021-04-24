package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private String url;
    private String driverLocation;

   public ConfigReader() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("config.properties");
            prop.load(input);
            this.url = prop.getProperty("url");
            this.driverLocation = prop.getProperty("driver_location");
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getUrl() {
        return url;
    }

    public String getDriverLocation() {
        return driverLocation;
    }

}
