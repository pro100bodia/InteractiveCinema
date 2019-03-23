package Game.Core.States;

import Game.Core.GameState;
import Game.Core.UI.Buttons.ChangeStateButton;
import Game.Core.UI.GG.Blacke;
import Game.Core.UI.Invetory.Inventory;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ResourceBundle;

public class StreetDummy extends GameState {
    private float scale = (float)0.7115;
    private int id;
    private ChangeStateButton goBack, goPark;
    private Image background;
    private Blacke blacke;

    public StreetDummy(int id) {
        super(id);
        this.id = id;
   
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        goPark = new ChangeStateButton(gameContainer, new Image("Game/res/img/UI/mainButton.png"), 300, 100, 5, "Park", stateBasedGame, resourceBundle);
        goBack = new ChangeStateButton(gameContainer, new Image("Game/res/img/UI/mainButton.png"),100,100,2,"street",stateBasedGame,resourceBundle);
        background = new Image("Game/res/img/Street.png").getScaledCopy((int)(1920*0.7115),(int)(1080*0.7115));
        blacke = new Blacke("GG", gameContainer);
        //blacke.setX();
        blacke.setY(1080 * scale - 295);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawString("Street", 500,50);
        graphics.drawImage(background,0,0);
        goBack.redraw(gameContainer,graphics,resourceBundle);
        goPark.redraw(gameContainer,graphics,resourceBundle);
        blacke.render(gameContainer,graphics);


    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        blacke.update(gameContainer, i);

        if(blacke.getX()+119 >=(int)(1920*scale)) {

            blacke.setX(blacke.getX()-5);
            blacke.moveTo(blacke.getX());
            blacke.setIsItMove(false);


        }
    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
        if(!Inventory.isOpen) {
            if(x > blacke.getX() + 119 || x<blacke.getX())
                blacke.moveTo(x);


        }
    }
}
