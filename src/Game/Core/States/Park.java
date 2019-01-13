package Game.Core.States;

import Game.Core.GameState;
import Game.Core.UI.Camera.Camera;
import Game.Core.UI.GG.Blacke;
import jdk.jfr.Category;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import javax.swing.*;
import java.awt.*;

public class Park extends GameState {
    private int x;
    private int width;
    private int height;
    private int moveTo;
    private int windowWidth;
    private int clickedX;
    private int movedX;

    private Camera camera;
    private Image image;
    private Blacke blacke;

    public Park(int id) {
        super(id);
    }

    @Override
    public int getID() {
        return super.getID();
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        Dimension sSize = Toolkit.getDefaultToolkit ().getScreenSize (); // объект, при помощи которого можно узнать размеры окна

        super.init(gameContainer, stateBasedGame);
        width = 3000;
        height = 900;
        x = 0;
        image = new Image("Game/res/img/Park/background.png");
        blacke = new Blacke("GG", gameContainer);
        blacke.setX(10);
        camera = new Camera(width, height, blacke);

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        super.render(gameContainer, stateBasedGame, graphics);
        camera.translate(graphics);
        image.draw(0, 0, width, height);
        blacke.render(gameContainer, graphics);

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        super.update(gameContainer, stateBasedGame, i);
        blacke.update(gameContainer, 1);
    }

    /**
     * Действие когда мышь двигается
     * @param newx положение мыши по x
     */
    @Override
    public void mouseMoved(int oldx, int oldy, int newx, int newy) {
        super.mouseMoved(oldx, oldy, newx, newy);
        movedX = newx;
    }



    /**
     * Действие при нажатии мыши
     * @param button кнопка мыши
     */
    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
        super.mouseClicked(button, x, y, clickCount);
        x -= camera.getX();
        if (x >= width - blacke.getWidth()){
            blacke.moveTo(width - blacke.getWidth());
        }else{
            blacke.moveTo(x);
        }
    }
}
