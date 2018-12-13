package Game.Core;

import Game.Core.UI.Properties.GameProperties;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.io.IOException;
import java.util.ResourceBundle;

public class GameState extends BasicGameState {
    private int id;
    protected GameSettings gameSettings;
    protected ResourceBundle resourceBundle;
    private  GameContainer gameContainer;
    private GameProperties properties;


    public GameState(int i){
        id=i;
        gameSettings = new GameSettings();
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.gameContainer =gameContainer;

        try {
            this.properties =new GameProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
        resourceBundle= gameSettings.getBundle();

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
            gameSettings.refresh();
            gameContainer.setFullscreen(gameSettings.isFullscreen());
            gameContainer.setMusicVolume(gameSettings.getMusic());
            gameContainer.setSoundVolume(gameSettings.getSound());
            resourceBundle= gameSettings.getBundle();
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        System.out.println("");
    }




}
