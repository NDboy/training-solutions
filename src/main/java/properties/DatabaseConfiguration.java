package properties;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class DatabaseConfiguration {

    private Properties properties;
    private final static String CHARACTER_CODE = "UTF-8";

    public DatabaseConfiguration() {
        Properties prop = new Properties();
        try(InputStreamReader isr = new InputStreamReader(DatabaseConfiguration.class.getResourceAsStream("/db.properties"), CHARACTER_CODE)) {
            prop.load(isr);
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file", ioe);
        }
        properties = prop;
    }

    public DatabaseConfiguration(File file) {
        Properties prop = new Properties();
        try(InputStreamReader isr = new InputStreamReader(Files.newInputStream(file.toPath()), CHARACTER_CODE)) {
            prop.load(isr);
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file", ioe);
        }
        properties = prop;
    }

    public String getHost() {
        return properties.getProperty("db.host");
    }

    public int getPort() {
        return Integer.parseInt(properties.getProperty("db.port"));
    }

    public String getSchema() {
        return properties.getProperty("db.schema");
    }

}
