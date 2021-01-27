package properties;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class JavaTools {

    private Properties properties;
    private Map<String, String> toolMap = new HashMap<>();

    public JavaTools() {
        Properties prop = new Properties();
        try (InputStreamReader isr = new InputStreamReader(Files.newInputStream(Path.of("javatools.properties")))){
            prop.load(isr);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
        this.properties = prop;
        propertiesToSet();
    }

    private void propertiesToSet() {
        Set<String> keyStrings = properties.stringPropertyNames();
        for (String keyString: keyStrings) {
            toolMap.put(keyString, properties.getProperty(keyString));
        }
    }

    public Set<String> getToolKeys() {
        Set<String> keys = new HashSet<>();
        Set<String> keySet = toolMap.keySet();
        for (String key: keySet) {
            String tool = key.split("\\.")[0];
            keys.add(tool);
        }
        return keys;
    }

    public String getName(String str) {
        return toolMap.get(str + ".name");
    }

    public String getUrl(String str) {
        return toolMap.get(str + ".url");
    }

    public Set<String> getTools() {
        Set<String> names = new HashSet<>();
        Set<String> keySet = toolMap.keySet();
        for (String key: keySet) {
            if (key.split("\\.")[1].equals("name")) {
                names.add(toolMap.get(key));
            }
        }
        return names;
    }
}
