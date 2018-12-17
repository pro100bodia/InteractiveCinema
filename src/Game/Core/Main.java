package Game.Core;

import Game.Core.States.BedroomDummy;
import Game.Core.States.FirstStart;
import Game.Core.States.Game;
import Game.Core.States.HouseGG;
import Game.Core.States.MainMenu;
import Game.Core.States.StreetDummy;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


import java.util.Properties;

public final class Main extends StateBasedGame {
    public final static int FIRST_START=-1, MENU=0, NEWGAME=1, HOUSE = 2, STREET = 3, BEDROOM = 4;
    private static int width, height;
    private static GameSettings settings;

    private Main(String name) {
        super("GAME");
        this.addState(new FirstStart(FIRST_START));
        this.addState(new MainMenu(MENU));
        this.addState(new Game(NEWGAME));
        this.addState(new HouseGG(HOUSE));
        this.addState(new StreetDummy(STREET));
        this.addState(new BedroomDummy(BEDROOM));
        this.enterState(-1);//временно установлено статически

}

    public static void main(String[] args) {

        settings=new GameSettings();
        AppGameContainer appc;
        try{
            appc = new AppGameContainer(new Main("GAME"));
            width = appc.getScreenWidth();
            height = appc.getScreenHeight();

            appc.setDisplayMode(1366, 768 ,settings.isFullscreen());
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