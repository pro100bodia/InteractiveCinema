package Game.Core.States;

import Game.Core.GameState;
import Game.Core.UI.Buttons.ChangeStateButton;
import Game.Core.UI.Buttons.ChangeStateDoor;

import Game.Core.UI.GG.Blacke;
import Game.Core.UI.Invetory.Inventory;
import org.newdawn.slick.*;

import org.newdawn.slick.state.StateBasedGame;


public class Bedroom extends GameState {
	private float scale = (float)0.7115;
    private Image background, bathRoomDoor, bed , servant;
    private ChangeStateDoor toTheLivingRoom;
    private Blacke blacke;



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
    	toTheLivingRoom = new ChangeStateDoor(gameContainer,new Image("Game/res/img/BedRoom/toTheLivingRoomPassive.png").getScaledCopy(100,375),new Image("Game/res/img/BedRoom/toTheLivingRoomActive.png").getScaledCopy(98,373),(int)(480*scale),(int)(190*scale),2,"toTheLivingRoom",stateBasedGame,resourceBundle);
    	bathRoomDoor = new Image("Game/res/img/BedRoom/toThebathroom.png").getScaledCopy(100,350);
        blacke = new Blacke("GG", gameContainer);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
    	 graphics.drawImage(background,0,0);
    	 graphics.drawImage(bathRoomDoor,930,135);
    	 graphics.drawImage(bed,245,340);
    	 graphics.drawImage(servant,0,0);
    	 

         toTheLivingRoom.setVisible();
         toTheLivingRoom.render(gameContainer,graphics);
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
        if(!Inventory.isOpen) {
            if(x > blacke.getX() + 119 || x<blacke.getX())
                blacke.moveTo(x);

            if (blacke.getX() <= toTheLivingRoom.getX() + 119 && x >= toTheLivingRoom.getX() && x <= toTheLivingRoom.getX() + 109 &&
                    y >= toTheLivingRoom.getY() && y <= toTheLivingRoom.getY() + 393) {
                ((ChangeStateDoor) toTheLivingRoom).open();
                blacke.setIsItMove(false);
            }
        }
    }
}
