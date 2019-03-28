package Game.Core.States;

import Game.Core.UI.Camera.Camera;
import Game.Core.UI.Invetory.Inventory;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import java.awt.*;

public class Park extends TypicalState {
    private int x;
    private int width;
    private int height;
    private int moveTo;
    private int windowWidth;
    private int clickedX;
    private int movedX;

    private Camera camera;
    private Image image;

    public Park(int id) {
        super(id);
    }

    @Override
    public int getID() {
        return super.getID();
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        super.init(gameContainer, stateBasedGame);

        Dimension sSize = Toolkit.getDefaultToolkit ().getScreenSize (); // объект, при помощи которого можно узнать размеры окна
        width = 3000;
        height = 900;
        x = 0;
        image = new Image("Game/res/img/Park/background.png");
        //blacke.moveTo(10);
        //blacke.setX(10);
        camera = new Camera(width, height, blacke);

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        super.render(gameContainer, stateBasedGame, graphics);

        camera.translate(graphics);
        image.draw(0, 0, width, height);

        blacke.render(gameContainer,graphics);

        if(it!=null) {
            it.render(gameContainer, graphics);
        }

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        super.update(gameContainer, stateBasedGame, i);
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
        if(!Inventory.isOpen) {
            if (x >= width - blacke.getWidth()) {
                blacke.moveTo(width - blacke.getWidth());
            } else {
                blacke.moveTo(x);
            }
        }
    }
}
