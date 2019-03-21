package Game.Core.States;

import Game.Core.GameState;
import Game.Core.UI.Buttons.ChangeStateButton;
import Game.Core.UI.Buttons.ChangeStateDoor;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import org.newdawn.slick.state.StateBasedGame;


public class Bedroom extends GameState {
	
	private float scale = (float)0.7115;
    private Image background, bathRoomDoor, bed , servant;
    private ChangeStateDoor toTheLivingRoom;
    
    
    private int id;
    private ChangeStateButton goBack;
    
    public Bedroom(int id) {
        super(id);
        this.id = id;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
    	servant = new Image("Game/res/img/BedRoom/servant.png").getScaledCopy(350,768);
    	bed= new Image("Game/res/img/BedRoom/bed.png").getScaledCopy(0.37f);
    	background = new Image("Game/res/img/BedRoom/bedroom.png").getScaledCopy((int)(1920*scale), (int)(1080*scale));
    	toTheLivingRoom = new ChangeStateDoor(gameContainer,new Image("Game/res/img/BedRoom/toTheLivingRoomPassive.png").getScaledCopy(100,375),new Image("Game/res/img/BedRoom/toTheLivingRoomActive.png").getScaledCopy(98,373),(int)(480*scale),(int)(190*scale),3,"toTheStreet",stateBasedGame,resourceBundle);
    	bathRoomDoor = new Image("Game/res/img/BedRoom/toThebathroom.png").getScaledCopy(100,350);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
    	 graphics.drawImage(background,0,0);
    	 graphics.drawImage(bathRoomDoor,930,135);
    	 graphics.drawImage(bed,245,340);
    	 graphics.drawImage(servant,0,0);
    	 

         toTheLivingRoom.setVisible();
         toTheLivingRoom.render(gameContainer,graphics);
        


    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }
}
