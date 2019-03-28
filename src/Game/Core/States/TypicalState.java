package Game.Core.States;

import Game.Core.GameState;
import Game.Core.UI.GG.Blacke;
import Game.Core.UI.Invetory.Inventory;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class TypicalState extends GameState {
    float scale = (float)0.7115;
    Image background;
    Blacke blacke;
    Inventory it;
    Input input;

    public TypicalState(int menu) {
        super(menu);
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        super.init(gameContainer,stateBasedGame);

        blacke = new Blacke("GG", gameContainer);
        it = new Inventory(gameContainer,50,50);
        input = gameContainer.getInput();
    }

    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        super.render(gameContainer,stateBasedGame,graphics);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

        blacke.update(gameContainer, i);
        callInvetory(input,stateBasedGame, it);
    }

    public void callInvetory(Input input, StateBasedGame stateBasedGame , Inventory invet) {
        if(input.isKeyPressed(Input.KEY_TAB)) {
            System.out.println("TAB pressed");

            if(invet != null && invet.isOpen) {
                invet.setIsOpen(false);
            } else {
                if(invet != null)
                    invet.setIsOpen(true);
            }
        }

        if(input.isKeyPressed(Input.KEY_ESCAPE)) {
            System.out.println("ESQ pressed");
            if(invet != null && invet.isOpen) {
                invet.setIsOpen(false);

            }
        }

    }
}
