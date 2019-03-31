package Game.Core.UI.Menues;


import Game.Core.UI.Buttons.Button;
import Game.Core.UI.Buttons.Controls.Checkbox;
import Game.Core.UI.Buttons.Controls.LangButton;
import Game.Core.UI.Buttons.Controls.Scrollbar;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;

import java.io.IOException;

public class Settings extends MouseOverArea {
    private boolean closed=false;
    private Button closeB;
    private LangButton rus,eng;
    private Checkbox fullscreen;
    private Scrollbar sound,music;



    public Settings(GUIContext container, Image image, int x, int y) {
        super(container, image, x, y);
        init();
    }

    private void init (){
        try {
            closeB = new Button(this.container, new Image("/src/Game/res/img/UI/bOk.png"),new Image("/src/Game/res/img/UI/bOkOnFocus.png"),670,500);
            fullscreen = new Checkbox(this.container, 870,200,"fullscreen");
            sound = new Scrollbar(this.container,840,300, "sound");
            music = new Scrollbar(this.container,840,400,"music");
            rus = new LangButton(this.container,860,500,"ru");
            eng = new LangButton(this.container,900,500,"eng");

        } catch (SlickException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void render(GUIContext container, Graphics g) {
        super.render(container, g);
        closeB.render(container,g);
        fullscreen.render(container,g);
        music.render(container,g);
        sound.render(container,g);
        rus.render(container,g);
        eng.render(container,g);
        g.drawString("X = "+Mouse.getX()+"   Y = "+Mouse.getY(),20,100);
        if (closeB.isClicked()|| Keyboard.isKeyDown(Keyboard.KEY_RETURN)){
            closed=true;
        }
    }




    public boolean isClosed(){
        return closed;
    }
    public void saveSettings() throws IOException {
        fullscreen.saveChanges();
    }




}
