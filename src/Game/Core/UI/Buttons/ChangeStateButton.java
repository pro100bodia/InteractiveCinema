package Game.Core.UI.Buttons;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.io.IOException;
import java.util.ResourceBundle;

public class ChangeStateButton extends Button {
    private int state;
    private StateBasedGame basedGame;
    private float scale;
    public ChangeStateButton(GUIContext container, Image image, int x, int y, int state, String text, StateBasedGame game, ResourceBundle bundle) {
        super(container, image, x, y, text,bundle);
        this.state = state;
        this.basedGame = game;
    }
    public ChangeStateButton(GUIContext context,int x,int y, Image image, Image focusedImage, StateBasedGame game, int toState){
        super(context,image,x,y);
        this.state = toState;
        this.basedGame=game;
        setMouseOverImage(focusedImage);
    }

    public ChangeStateButton(GUIContext context,int x,int y, Image image, Image focusedImage, StateBasedGame game, int toState,float scalex, float scaley){
        //   super(context,image,(int)(x*(1/scalex)),(int)(y*(1/scaley/)));
        super(context,image,x,y);
        this.state = toState;
        this.basedGame=game;
        this.scale = scale;
        this.scalex=scalex;
        this.scaley=scaley;
        setMouseOverImage(focusedImage);
    }

    @Override
    public void onFocus() {
        super.onFocus();
        System.out.println("FOCUSEd");
    }

    @Override
    public void onClick() {
        super.onClick();
        basedGame.enterState(state, new FadeOutTransition(), new FadeInTransition());
    }



    @Override
    public void render(GUIContext container, Graphics g) {
        // g.scale(1/this.scalex,1/this.scaley);
        if(scalex!=0) {
            this.setX(this.getX() * (1/scalex));
            this.setY(this.getY() * (1/scaley));
        }
        super.render(container, g);
    }

    @Override
    public void redraw(GUIContext container, Graphics g, ResourceBundle freshBundle) {
        super.redraw(container, g, freshBundle);
    }
}