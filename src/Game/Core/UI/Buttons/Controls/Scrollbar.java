package Game.Core.UI.Buttons.Controls;

import Game.Core.GameSettings;
import Game.Core.UI.Buttons.Button;
import Game.Core.UI.Properties.GameProperties;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;

import java.io.IOException;

public class Scrollbar extends Button{
    private int x,y, absoluteX;
    private Graphics graphics;
    private Image ball;
    private GameProperties properties;
    private GameSettings gameSettings;
    private float position;
    private String text,option;


    public Scrollbar(GUIContext context, int x, int y,String option) throws SlickException, IOException {
        super(context,new Image( "Game/res/img/UI/scrollLine.png"),x,y);
        this.y=y;
        this.option=option;
            gameSettings = new GameSettings();
            this.text = gameSettings.getBundle().getString(option);
        absoluteX=x;
        properties = new GameProperties();
        position= Float.parseFloat(properties.getProperty(option));
        this.x = (int) (absoluteX+((image.getWidth()-30)*position));
        setMouseOverImage(new Image("Game/res/img/UI/scrollLineFocused.png"));

    }
    @Override
    public void render(GUIContext container, Graphics g) {

        try{
            gameSettings.refresh();
            g.drawString(gameSettings.getBundle().getString(option),absoluteX-370,y-10);
        }
        catch (NullPointerException e){
        }
        super.render(container, g);
        try {
            draw();
        } catch (SlickException e) {
            e.printStackTrace();
        }
        graphics=g;
        actionDeterminate();
    }

    private void draw() throws SlickException {
        ball=new Image("Game/res/img/UI/scrollButton.png");
        ball.draw(x ,y-5);
    }

    public void onSwipe() throws IOException {
        if(isMax(Mouse.getX())&&isMin(Mouse.getX())){
            this.x = Mouse.getX()-ball.getWidth()/2;
            getValue();
        }
    }

    @Override
    public boolean isMouseOver() {
        return super.isMouseOver();
    }


    public void actionDeterminate() {
        if (isMouseOver()&&Mouse.isButtonDown(Input.MOUSE_LEFT_BUTTON)){
            try {
                onSwipe();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void mouseWheelMoved(int change) {
               if(isMouseOver()) {
                   super.mouseWheelMoved(change);
                   if (change > 0&&isMax()) {
                       this.x += 5;
                   } else if(change<0&& isMin()){
                       this.x -= 5;
                   }
                   render(container, graphics);
                   try {
                       getValue();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
    }

    private boolean isMin(){
        return this.x >= absoluteX+5;
    }
    private boolean isMax(){
        return this.x <= absoluteX + (image.getWidth()-ball.getWidth()-5);
    }
    private boolean isMin(int X){
        System.out.println("MIN "+(X >= absoluteX+5));
        return X >= absoluteX+(ball.getWidth()/2);
    }
    private boolean isMax(int X){
        return X <= absoluteX + (image.getWidth()-(ball.getWidth()/2));
    }

    private void getValue() throws IOException {
        float width, coord, percent;
        width=image.getWidth()-ball.getWidth();
        coord=(x)-absoluteX;
        percent = (coord/width);
        System.out.println(percent);
        properties.setProperty(option,String.valueOf(percent));
    }

}
