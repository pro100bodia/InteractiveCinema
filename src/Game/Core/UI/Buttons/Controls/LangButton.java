package Game.Core.UI.Buttons.Controls;

import Game.Core.GameSettings;
import Game.Core.UI.Buttons.Button;
import Game.Core.UI.Properties.GameProperties;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;

import java.io.IOException;

public class LangButton extends Button {
    private String lang,text;
    private GameSettings settings;
    private GameProperties properties;
    private Image focused;
    private Graphics graphics;
    private LangButton(GUIContext container, Image image, int x, int y, String option) throws SlickException {
        super(container, image, x, y);
        focused =new Image("Game/res/img/UI/squareButtonFocused.png");
        lang = option;
        settings = new GameSettings();
        try {
            properties = new GameProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setMouseOverImage(focused);
    }
    public LangButton(GUIContext context, int x,int y, String option) throws SlickException {
        this(context,new Image("Game/res/img/UI/squareButton.png"),x,y,option);
    }

    @Override
    public void render(GUIContext container, Graphics g) {
        isChoosen();
        graphics=g;
        super.render(container, g);
        try{
            drawText(g);
        }
        catch (NullPointerException e){}
    }

    @Override
    public void onClick() {
        super.onClick();
        if(!isChoosen()) {
            try {
                properties.setProperty("language", lang);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        isChoosen();
    }

     boolean isChoosen(){
        boolean t=true;
        try {
            if (properties.getProperty("language").equals(lang))
            {
                super.setNormalImage(focused);
                t=true;
            }
            else {
                super.setNormalImage(image);
                t= false;
            }
            drawText(graphics);
        }
        catch (NullPointerException e){ }
        return t;
    }

    @Override
    protected void drawText(Graphics g) {
        g.setColor(Color.white);
        switch (lang){
            case "ru": text="Rus";
            break;
            case "eng": text="Eng";
            break;
            default: text="Eng";
            break;
        }
        g.drawString(text,this.getX()+5,this.getY()+10);
    }
}
