package Game.Core;

import Game.Core.States.*;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public final class Main extends StateBasedGame {
    public final static int FIRST_START=-1, MENU=0, NEWGAME=1, HOUSE = 2, STREET = 3, BEDROOM = 4, PARK = 5;
    public static final int WIDTH = 1366, HEIGHT = 768;
    private static GameSettings settings;

    private Main(String name) {
        super("GAME");
        this.addState(new FirstStart(FIRST_START));
        this.addState(new MainMenu(MENU));
        this.addState(new Game(NEWGAME));
        this.addState(new HouseGG(HOUSE));
        this.addState(new StreetDummy(STREET));
        this.addState(new BedroomDummy(BEDROOM));
        this.addState(new Park(PARK));
        this.enterState(-1);//временно установлено статически

}

    public static void main(String[] args) {
        settings=new GameSettings();
        AppGameContainer appc;
        try{
            appc = new AppGameContainer(new Main("GAME"));

            appc.setDisplayMode(WIDTH, HEIGHT, settings.isFullscreen());
            appc.setTargetFrameRate(60);
            appc.start();


        }catch (SlickException e){
            System.out.println("crashed build app game container");
        }
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.getState(MENU).init(gameContainer,this);
        this.getState(NEWGAME).init(gameContainer,this);
    }



}
