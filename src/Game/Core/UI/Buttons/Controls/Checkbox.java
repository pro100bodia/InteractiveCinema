package Game.Core.UI.Buttons.Controls;

import Game.Core.GameSettings;
import Game.Core.UI.Buttons.Button;
import Game.Core.UI.Properties.GameProperties;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;

import java.io.*;
import java.util.ResourceBundle;

public class Checkbox extends Button {


    private Image unchecked = new Image("Game/res/img/UI/checkbox.png");
    private Image checked = new Image("Game/res/img/UI/checkboxChecked.png");
    private Image checkedOnFosus = new Image("Game/res/img/UI/checkboxCheckedOnFocus.png");
    private Image ucheckedOnFosus = new Image("Game/res/img/UI/checkboxUncheckedOnFocus.png");
    private boolean checkedB=false;
    private String option,text;
    private GameProperties gameProperties;
    private ResourceBundle bundle;
    private GameSettings gameSettings;
    private int X,Y;



    public Checkbox (GUIContext context, int x, int y) throws SlickException, IOException {
        super(context,new Image("Game/res/img/UI/checkbox.png"),new Image("Game/res/img/UI/checkboxUncheckedOnFocus.png"),x,y);
        gameProperties = new GameProperties();
        gameSettings = new GameSettings();

    }

    public Checkbox (GUIContext context, int x, int y,String option) throws SlickException, IOException {
        this(context, x, y);
        X=x;
        Y=y;
        text = gameSettings.getBundle().getString(option);
        this.option=option;
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void render(GUIContext container, Graphics g) {
        gameSettings.refresh();
        text=gameSettings.getBundle().getString(option);
        g.drawString(text,X-400,Y+10);
        super.render(container, g);
    }


    private void init() throws IOException {

        if(gameProperties.getProperty(option).equals("true")){
            checkedB=true;
        }
        else
            checkedB=false;
        tubmlr();
    }


    @Override
    public void onClick() {
        try {
            tubmlr();
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.onClick();
    }

    private void tubmlr() throws IOException {
        if(checkedB){
            checkedB=false;
            super.setNormalImage(checked);
            super.setMouseOverImage(checkedOnFosus);
            gameProperties.setProperty(option,"true");
        }
        else {
            checkedB=true;
            super.setNormalImage(unchecked);
            super.setMouseOverImage(ucheckedOnFosus);
            gameProperties.setProperty(option,"false");
        }
    }

    public void saveChanges() throws IOException {
        gameProperties.saveChanges();
    }


}
