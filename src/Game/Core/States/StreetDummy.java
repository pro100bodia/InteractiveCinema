package Game.Core.States;

import Game.Core.GameState;
import Game.Core.UI.Buttons.ChangeStateButton;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ResourceBundle;

public class StreetDummy extends GameState {
    private int id;
    private ChangeStateButton goBack, goPark;
    private Image background;

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
        background = new Image("Game/res/img/Street.png").getScaledCopy((int)(1920*0.71),(int)(1080*0.71));
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawString("Street", 500,50);
        graphics.drawImage(background,0,0);
        goBack.redraw(gameContainer,graphics,resourceBundle);
        


    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }
}
