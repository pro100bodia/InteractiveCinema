package Game.Core.States;

import Game.Core.GameState;
import Game.Core.UI.Buttons.ChangeStateButton;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import org.newdawn.slick.state.StateBasedGame;


public class BedroomDummy extends GameState {
    private int id;
    private ChangeStateButton goBack;
    public BedroomDummy(int id) {
        super(id);
        this.id = id;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        goBack = new ChangeStateButton(gameContainer, new Image("Game/res/img/UI/mainButton.png"),100,100,2,"bedroom",stateBasedGame,resourceBundle);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawString("Bed Room", 500,50);
        graphics.setBackground(Color.green);
        goBack.redraw(gameContainer,graphics,resourceBundle);


    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }
}
