package Game.Core.States;

import Game.Core.GameSettings;
import Game.Core.GameState;
import Game.Core.UI.Buttons.*;
import Game.Core.UI.GG.Blacke;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class HouseGG extends GameState implements MouseListener {

    private final int state;
    private Image background;
    private ChangeStateDoor toTheBedroom, toTheStreet;
    private Blacke blacke;



    public HouseGG (int menu) {
        super(menu);
        state=menu;
    }


    @Override
    public int getID() {
        return state;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        super.init(gameContainer,stateBasedGame);
        background = new Image("Game/res/img/2.png").getScaledCopy((int)(1920*0.71), (int)(1080*0.71));
        // toTheStreet = new ChangeStateDoor(gameContainer,new Image("Game/res/img/UI/HouseGGDoor.png").getScaledCopy(110,400),new Image("/src/Game/res/img/UI/HouseGGDoorActive1.png").getScaledCopy(125,397),210,255,3,"toTheStreet",stateBasedGame,resourceBundle);
        toTheStreet = new ChangeStateDoor(gameContainer,new Image("Game/res/img/UI/HouseGGDoor.png").getScaledCopy(109,403),new Image("/src/Game/res/img/UI/HouseGGDoorActive1.png").getScaledCopy((int)(176*0.71),(int)(558*0.71)),(int)(295*0.71),(int)(358*0.71),3,"toTheStreet",stateBasedGame,resourceBundle);
        toTheBedroom = new ChangeStateDoor(gameContainer,new Image("Game/res/img/UI/HouseGGDoor2.png").getScaledCopy(109,393),new Image("Game/res/img/UI/HouseGGDoor2Active.png").getScaledCopy((int)(155*0.71),(int)(562*0.71)),(int)(1469*0.71),(int)(337*0.71),4,"toTheBedroom",stateBasedGame,resourceBundle);
        blacke = new Blacke("GG", gameContainer);

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        super.render(gameContainer,stateBasedGame,graphics);
        graphics.drawImage(background,0,0);

        toTheStreet.setVisible();
        toTheStreet.render(gameContainer,graphics);
        toTheBedroom.setVisible();
        toTheBedroom.render(gameContainer,graphics);
        blacke.render(gameContainer,graphics);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

        blacke.update(gameContainer, i);
        if(blacke.getX()<=273) {
            blacke.setX(273);
            blacke.moveTo(blacke.getX());
        }
        if(blacke.getX() >=984) {
            blacke.setX(984);
            blacke.moveTo(blacke.getX());
        }
    }



    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
        blacke.moveTo(x);

        if (blacke.getX() <= toTheStreet.getX() + 119 && x >= toTheStreet.getX() && x <= toTheStreet.getX() + 109 &&
                y >= toTheStreet.getY() && y <= toTheStreet.getY() + 393)
            toTheStreet.open();

        if (blacke.getX() >= toTheBedroom.getX() - blacke.getWidth() - 10 && x >= toTheBedroom.getX() && x <= toTheBedroom.getX() + 109 &&
                y >= toTheBedroom.getY() && y <= toTheBedroom.getY() + 393)
            toTheBedroom.open();

    }
}