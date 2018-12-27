package Game.Core.States;

import Game.Core.GameState;
import Game.Core.UI.GG.Blacke;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import javax.swing.*;
import java.awt.*;

public class Park extends GameState {
    private final int state;
    private int x;
    private float mousePlusX;
    private int width;
    private int height;
    private int moveTo;
    private int windowWidth; // mousePlusX отвечает за движение фона когда двигается мышка
    private Image image;
    private Blacke blacke;

    public Park(int id) {
        super(id);
        state = id;
    }

    @Override
    public int getID() {
        return super.getID();
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        super.init(gameContainer, stateBasedGame);
        width = 5000;
        height = 900;
        x = 0;
        image = new Image("Game/res/img/Park/background.png");
        blacke = new Blacke(10,"", gameContainer);
        blacke.setX(10);

        Dimension sSize = Toolkit.getDefaultToolkit ().getScreenSize (); // объект, при помощи которого можно узнать размеры окна
        windowWidth = sSize.width;

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        super.render(gameContainer, stateBasedGame, graphics);
        image.draw(x, 0, width, height);
        blacke.render(gameContainer, graphics);

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        super.update(gameContainer, stateBasedGame, i);
        move();

        blacke.update(gameContainer, i);
    }

    /**
     * Действие когда мышь двигается
     * @param newx положение мыши по x
     */
    @Override
    public void mouseMoved(int oldx, int oldy, int newx, int newy) {
        super.mouseMoved(oldx, oldy, newx, newy);

        x += mousePlusX;
        blacke.setX(blacke.getX() + mousePlusX);

        mousePlusX = (newx - blacke.getX()) / 100 * 10;

        x -= mousePlusX;
        blacke.setX(blacke.getX() - mousePlusX);
    }



    /**
     * Действие при нажатии мыши
     * @param button кнопка мыши
     */
    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
        super.mouseClicked(button, x, y, clickCount);


        if (button == 0){
            moveTo = x - windowWidth / 2;
        }

        // выход блейка из левого края
        if (blacke.getX() < windowWidth / 2){
            if (x <= windowWidth / 2)
                blacke.moveTo(x);
            else {
                blacke.moveTo(windowWidth / 2);
            }
        }


        // выход блейка из правого края
        if (blacke.getX() > windowWidth / 2){
            if (x >= windowWidth / 2)
                blacke.moveTo(x);
            else{
                blacke.moveTo(windowWidth / 2);
            }
        }
    }

    public void move() {
        // [-=] ->
        // [+=] <-

        // проверка на выход за пределы карты
        if (x > 0){
            x = 0;
            moveTo = 0;
        }else if (x < -width + windowWidth){
            x = -width + windowWidth;
            moveTo = 0;
        }


        // вход блейка в левый край
        if (blacke.getX() == windowWidth / 2 && this.x == 0 && moveTo + windowWidth / 2 <= windowWidth / 2){
            blacke.moveTo(moveTo + windowWidth / 2);
        }

        // вход блейка в правый край
        if (blacke.getX() == windowWidth / 2 && this.x == -width + windowWidth && moveTo + windowWidth / 2 >= windowWidth / 2){
            blacke.moveTo(moveTo + windowWidth / 2);
        }


        // движение
        if (blacke.getX() == windowWidth / 2)
            if (moveTo < 0) { // [<-]
                if (moveTo > -5){
                    x += moveTo;
                    moveTo = 0;
                }else {
                    x += 5;
                    moveTo += 5;
                }
            }else if (moveTo > 0) { // [->]
                if (moveTo < 5) {
                    x -= moveTo;
                    moveTo = 0;
                } else {
                    x -= 5;
                    moveTo -= 5;
                }
            }
    }
}
