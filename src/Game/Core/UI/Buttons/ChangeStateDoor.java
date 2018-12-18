package Game.Core.UI.Buttons;


import java.util.ResourceBundle;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class ChangeStateDoor extends ChangeStateButton {
	
	 private int state;
	 private StateBasedGame basedGame;
	
    Image image, focusImage;
    public ChangeStateDoor(GUIContext container, Image image, Image focusImage, int x, int y,int state, String text, StateBasedGame game, ResourceBundle bundle) {
    	super(container, image, x, y, state, text,game, bundle);
    	this.state = state;
        this.basedGame = game;
        this.image = image;
        this.focusImage = focusImage;
        
        super.setMouseOverImage(focusImage);
    }

    @Override
    public void render(GUIContext container, Graphics g) {
        super.render(container, g);
    }

    @Override
    public void onClick() {
        //super.onClick();
        
       // 
    }

    @Override
    public void onFocus() {
        super.onFocus();
    }

    @Override
    public void setMouseOverImage(Image image) {
        super.setMouseOverImage(this.focusImage);
    }
    
    public void open() {
    	basedGame.enterState(state, new FadeOutTransition(), new FadeInTransition());
    }
	
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
