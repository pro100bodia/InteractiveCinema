package Game.Core.UI.Buttons;


import Game.Core.UI.Menues.Settings;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;

import java.io.IOException;
import java.util.ResourceBundle;

public class SettingsButton extends Button {
    private Settings settingsMenu;
    private boolean drawMenu=false;

    public SettingsButton(GUIContext container, Image image, int x, int y, String text, ResourceBundle bundle){
        super(container, image, x, y, text,bundle);
    }


    @Override
    public void onClick() {
        super.onClick();
        try {

            settingsMenu = new Settings(container,new Image("/src/Game/res/img/UI/settings2.png"),283,20);
            drawMenu=true;
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void render(GUIContext container, Graphics g) {
        if (drawMenu){
            settingsMenu.render(container, g);
            if (settingsMenu.isClosed()){
                drawMenu=false;
                try {
                    settingsMenu.saveSettings();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        super.render(container, g);
    }

    public boolean getDrawMenu(){return  drawMenu;}



 }
