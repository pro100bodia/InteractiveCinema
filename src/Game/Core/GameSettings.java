package Game.Core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public  class GameSettings {
    private Properties properties;
    private String path;
    private FileInputStream in;
    private boolean fullscreen;
    private String language;
    private float music;
    private float sound;
    private float proportion;
    private ResourceBundle bundle;

    public GameSettings(){
        path = "src/Game/properties/settings.properties";
        properties = new Properties();
        refresh();

    }

    public void refresh(){
        try {
            in = new FileInputStream(path);
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(properties.getProperty("fullscreen").equals("true")){
            fullscreen=true;
        }
        else if (properties.getProperty("fullscreen").equals("false")){
            fullscreen=false;
        }
        language= properties.getProperty("language");
        music= Float.parseFloat(properties.getProperty("music"));
        sound=Float.parseFloat(properties.getProperty("sound"));
        bundle = ResourceBundle.getBundle("Game.Core.UI.Properties.Lang.lang",new Locale(getLanguage()));
        proportion = Float.parseFloat(properties.getProperty("screenProportion"));
    }

    public float getMusic() {
        return music;
    }

    public boolean isFullscreen() {
        return fullscreen;
    }

    public float getSound() {
        return sound;
    }

    public String getLanguage() {
        return language;
    }

    public ResourceBundle getBundle() {
        return bundle;
    }

    public float getScreenProportion(){return proportion;}
}
