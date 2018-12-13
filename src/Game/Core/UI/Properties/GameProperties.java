package Game.Core.UI.Properties;

import Game.Core.GameSettings;

import java.io.*;
import java.util.Properties;

public class GameProperties {
    private FileInputStream in;
    private Properties property;
    private String path;
    GameSettings settings;

    public GameProperties() throws IOException {
        path = "src/Game/properties/settings.properties";
        in = new FileInputStream(path);
        property = new Properties();
        property.load(in);
        settings = new GameSettings();
    }

    public String getProperty(String propertyName){

        try {
            in = new FileInputStream(path);
            property.load(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property.getProperty(propertyName);
    }

    public void setProperty(String key,String value) throws IOException {
        in = new FileInputStream(path);
        property.load(in);
        String oldValue= property.getProperty(key);
        property.setProperty(key, value);
        if(!oldValue.equals(value))
        {
            property.remove(key,oldValue);
            FileWriter w = new FileWriter(path);
            property.store(w,null);
            w.close();
            settings.refresh();
        }
        in.close();

    }

    public void saveChanges(){
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
