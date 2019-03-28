package Game.Core.States;

import Game.Core.UI.Buttons.ChangeStateButton;
import Game.Core.UI.Invetory.Inventory;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class StreetDummy extends TypicalState {
    private int id;
    private ChangeStateButton goBack, goPark;

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
        super.init(gameContainer, stateBasedGame);

        background = new Image("Game/res/img/Street.png").getScaledCopy((int)(1920*scale),(int)(1080*scale));
        goPark = new ChangeStateButton(gameContainer, new Image("Game/res/img/UI/mainButton.png"), 300, 100, 5, "Park", stateBasedGame, resourceBundle);
        goBack = new ChangeStateButton(gameContainer, new Image("Game/res/img/UI/mainButton.png"),100,100,2,"street",stateBasedGame,resourceBundle);
        blacke.setY(1080 * scale - 295);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        super.render(gameContainer, stateBasedGame, graphics);

        graphics.drawString("Street", 500,50);
        graphics.drawImage(background,0,0);
        goBack.redraw(gameContainer,graphics,resourceBundle);
        goPark.redraw(gameContainer,graphics,resourceBundle);
        blacke.render(gameContainer,graphics);
        if(it!=null) {
            it.render(gameContainer, graphics);
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        super.update(gameContainer, stateBasedGame, i);

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
