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
    private int x;
    private int xToBorder;
    private int width;
    private int height;
    private int moveTo;
    private int moveToBorder;
    private int windowWidth;
    private int clickedX;
    private int movedX;

    private boolean OnMoveToBorder;

    private String direction;

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
        windowWidth = sSize.width;

        super.init(gameContainer, stateBasedGame);
        width = 3000;
        height = 900;
        x = 0;
        image = new Image("Game/res/img/Park/background.png");
        blacke = new Blacke(10,"", gameContainer);
        blacke.setX(10);

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        super.render(gameContainer, stateBasedGame, graphics);
        image.draw(x + xToBorder, 0, width, height);
        blacke.render(gameContainer, graphics);

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        super.update(gameContainer, stateBasedGame, i);

        move();


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

        if (x < windowWidth / 2){
            moveTo = this.x + (windowWidth / 2 - x);
        }

        if (x > windowWidth / 2){
            moveTo = this.x - (x - windowWidth / 2);
        }

        clickedX = x;
        if (clickedX > windowWidth - blacke.getWidth()){
            clickedX = windowWidth - blacke.getWidth();
        }
    }

    public void move() {

        if (blacke.getX() == windowWidth / 2) {
            if (this.x <= 0 && this.x >= (width - windowWidth) * -1) {
                    if (this.x < moveTo) { // движение влево
                        this.x += 5;
                        blacke.setDirection("left");
                    }

                    if (this.x > moveTo) { // движение вправо
                        this.x -= 5;
                        blacke.setDirection("right");
                    }
            } else { // если фон ушёл за границы экрана

                if (this.x >= 0){
                    this.x = 0;
                }

                if (this.x <= (width - windowWidth) * -1){
                    this.x = (width - windowWidth) * -1;
                }

                moveTo = this.x;
                blacke.moveTo(clickedX);
            }
        }else { // если блейк не по центру
            // движение блейка

            if (blacke.getX() <= windowWidth / 2) { // если блейк слева
                if (clickedX >= windowWidth / 2) {
                    blacke.moveTo(windowWidth / 2);
                } else {
                    blacke.moveTo(clickedX);
                }
            }

            if (blacke.getX() >= windowWidth / 2) { // если блейк справа
                if (clickedX <= windowWidth / 2) {
                    blacke.moveTo(windowWidth / 2);
                } else {
                    blacke.moveTo(clickedX);
                }
            }
        }

        //движение в левую сторону когда мышка возле левого края экрана
        if (movedX <= windowWidth / 100 * 10 && x <= -20 && !OnMoveToBorder) {
                blacke.setTwiceMove(20);
                moveToBorder += 20;
                OnMoveToBorder = true;
                direction = "left";
        }

        //движение в правую сторону когда мышка возле правого края экрана
        if (movedX >= windowWidth / 100 * 90 && x >= (width - windowWidth - 20) * -1 && !OnMoveToBorder) {
            blacke.setTwiceMove(-20);
            moveToBorder -= 20;
            OnMoveToBorder = true;
            direction = "right";
        }


        if (movedX >= windowWidth / 100 * 10 && movedX <= windowWidth / 100 * 90) {

            if (OnMoveToBorder && direction == "left") {
                moveToBorder -= 20;
            }

            if (OnMoveToBorder && direction == "right") {
                moveToBorder += 20;
            }

            blacke.setTwiceMove(0);
            OnMoveToBorder = false;
        }

        if (xToBorder < moveToBorder) {
            xToBorder += 5;
        }

        if (xToBorder > moveToBorder) {
            xToBorder -= 5;
        }

        if (x + xToBorder > 0 || x + xToBorder < (width - windowWidth) * -1){
            moveToBorder = 0;
            xToBorder = 0;
        }
    }
}
