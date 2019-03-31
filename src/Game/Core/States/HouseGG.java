package Game.Core.States;

import Game.Core.UI.Buttons.*;
import Game.Core.UI.Invetory.Inventory;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class HouseGG extends TypicalState implements MouseListener {
    private final int state;
    private Image table, chair;
    private ChangeStateDoor toTheBedroom, toTheStreet;
    private Desk desk;
    private Phone phone;

    private Music music;
    private boolean musicPlaying = false;


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
        
        music = new Music("Game/res/Sounds/Gatari.ogg");
        
        background = new Image("Game/res/img/GGHouse/HouseGG.png").getScaledCopy((int)(1920*scale), (int)(1080*scale));
        toTheStreet = new ChangeStateDoor(gameContainer,new Image("Game/res/img/GGHouse/DoorLeftPassive.png").getScaledCopy(100,375),new Image("Game/res/img/GGHouse/DoorLeftActive.png").getScaledCopy(100,375),(int)(480*scale),(int)(200*scale),3,"toTheStreet",stateBasedGame,resourceBundle);
        toTheBedroom = new ChangeStateDoor(gameContainer,new Image("Game/res/img/GGHouse/DoorRightPassive.png").getScaledCopy(100,360),new Image("Game/res/img/GGHouse/DoorRightActive.png").getScaledCopy(100,360),(int)(1320*scale),(int)(200*scale),4,"toTheBedroom",stateBasedGame,resourceBundle);

        table = new Image("Game/res/img/GGHouse/cofee_table.png").getScaledCopy(0.38f);
        chair = new Image("Game/res/img/GGHouse/chair.png");
        desk = new Desk(gameContainer, new Image("Game/res/img/GGHouse/desk_off.png").getScaledCopy(0.4f),  new Image("Game/res/img/GGHouse/desk_on.png").getScaledCopy(0.4f), 130, 50);
        phone = new Phone(gameContainer, new Image("Game/res/img/GGHouse/phone_off.png").getScaledCopy(0.4f),  new Image("Game/res/img/GGHouse/phone_on.png").getScaledCopy(0.4f), 0, 375);
        
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

        graphics.drawImage(table,875,350);

        desk.render(gameContainer,graphics);
        phone.render(gameContainer,graphics);

        if(it!=null) {
            it.render(gameContainer, graphics);
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        super.update(gameContainer, stateBasedGame, i);

        if (stateBasedGame.getCurrentStateID() == 2 && !musicPlaying ) {
			musicPlaying = true;
			music.play();
			
		}

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
//		it.tick();
    }



    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
        if(!Inventory.isOpen) {
    	if(x > blacke.getX() + 119 || x<blacke.getX())
        	blacke.moveTo(x);

            if (blacke.getX() <= toTheStreet.getX() + 119 && x >= toTheStreet.getX() && x <= toTheStreet.getX() + 109 &&
                    y >= toTheStreet.getY() && y <= toTheStreet.getY() + 393) {
            	((ChangeStateDoor) toTheStreet).open();
            	blacke.setIsItMove(false);
            }

            if (blacke.getX() >= toTheBedroom.getX() - blacke.getWidth() - 10 && x >= toTheBedroom.getX() && x <= toTheBedroom.getX() + 109 &&
                    y >= toTheBedroom.getY() && y <= toTheBedroom.getY() + 393) {
            	((ChangeStateDoor) toTheBedroom).open();
            	blacke.setIsItMove(false);
            }
    	}
    }
}