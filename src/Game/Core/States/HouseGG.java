package Game.Core.States;

import Game.Core.GameSettings;
import Game.Core.GameState;
import Game.Core.UI.Buttons.*;
import Game.Core.UI.GG.Blacke;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class HouseGG extends GameState implements MouseListener {

	private float scale = (float)0.71;
	
    private final int state;
    private Image background;
    private Button toTheBedroom, toTheStreet;
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
        background = new Image("Game/res/img/2.png").getScaledCopy((int)(1920*scale), (int)(1080*scale));
       // toTheStreet = new ChangeStateDoor(gameContainer,new Image("Game/res/img/UI/HouseGGDoor.png").getScaledCopy(110,400),new Image("/src/Game/res/img/UI/HouseGGDoorActive1.png").getScaledCopy(125,397),210,255,3,"toTheStreet",stateBasedGame,resourceBundle);
        toTheStreet = new ChangeStateDoor(gameContainer,new Image("Game/res/img/UI/HouseGGDoor.png").getScaledCopy((int)(155*scale),(int)(562*scale)),new Image("/src/Game/res/img/UI/HouseGGDoorActive1.png").getScaledCopy((int)(176*scale),(int)(558*scale)),(int)(295*scale),(int)(358*scale),3,"toTheStreet",stateBasedGame,resourceBundle);
        toTheBedroom = new ChangeStateDoor(gameContainer,new Image("Game/res/img/UI/HouseGGDoor2.png").getScaledCopy((int)(155*scale),(int)(562*scale)),new Image("Game/res/img/UI/HouseGGDoor2Active.png").getScaledCopy((int)(155*scale),(int)(562*scale)),(int)(1469*scale),(int)(337*scale),4,"toTheBedroom",stateBasedGame,resourceBundle);
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
    		
    		if(blacke.getX()<=(int)(421*scale)) {
    			blacke.setX(blacke.getX()+5);
    			blacke.moveTo(blacke.getX());
    			blacke.setIsItMove(false);
    		
    			
    			
    		}
    		if(blacke.getX()+119 >=(int)(1476*scale)) {
    			
    			blacke.setX(blacke.getX()-5);
    			blacke.moveTo(blacke.getX());
    			blacke.setIsItMove(false);
    			
    			
    		}
    }
    

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
       
    	if(x > blacke.getX() + 119 || x<blacke.getX())
    	blacke.moveTo(x);

        if (blacke.getX() <= toTheStreet.getX() + 119 && x >= toTheStreet.getX() && x <= toTheStreet.getX() + 109 &&
                y >= toTheStreet.getY() && y <= toTheStreet.getY() + 393)
        	((ChangeStateDoor) toTheStreet).open();

        if (blacke.getX() >= toTheBedroom.getX() - blacke.getWidth() - 10 && x >= toTheBedroom.getX() && x <= toTheBedroom.getX() + 109 &&
                y >= toTheBedroom.getY() && y <= toTheBedroom.getY() + 393)
        	((ChangeStateDoor) toTheBedroom).open();

    }
}
