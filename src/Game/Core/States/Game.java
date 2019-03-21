package Game.Core.States;

import Game.Core.GameState;
import Game.Core.UI.Buttons.ChangeStateButton;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ResourceBundle;

public class Game extends GameState {
    private int id;
    private ChangeStateButton goBack;
    public Game(int id) {
        super(id);
        this.id = id;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        goBack = new ChangeStateButton(gameContainer, new Image("Game/res/img/UI/mainButton.png"),100,100,0,"back",stateBasedGame,resourceBundle);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawString("back", 500,50);
        goBack.redraw(gameContainer,graphics,resourceBundle);


    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }
}
