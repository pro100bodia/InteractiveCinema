package Game.Core.States;


import Game.Core.GameState;
import Game.Core.UI.Buttons.*;
import Game.Core.UI.Properties.GameProperties;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

import java.io.IOException;

public class MainMenu extends GameState {

    private final int state;
    private Image background;
    private Button newGame, loadGame, exit;
    private SettingsButton settingsB;
    private Music music;
    private boolean musicPlaying = false;
    private GameProperties properties;
    private  float propW, propH, bW;
    
    private Image [] fire = new Image[9];
    private Image [] spark = new Image[10];
    
    private Animation fireAnimation;
    private Animation sparkAnimation;


    public MainMenu(int menu) {
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
        //propW = gameSettings.getScreenProportion();

        music = new Music("Game/res/Sounds/music.ogg");
        background = new Image("Game/res/img/MainMenu/bar.png").getScaledCopy(1366, 766);
        //exit = new ExitButton(gameContainer,new Image("Game/res/img/UI/exit.png"),1192,265);
        exit = new ExitButton(gameContainer,new Image("Game/res/img/UI/exit.png").getScaledCopy(47, 350),946,200);

        newGame = new ChangeStateButton(gameContainer, new Image("Game/res/img/UI/mainButton.png").getScaledCopy(103,125),550,275,2,"newGame",stateBasedGame,resourceBundle);
        settingsB = new SettingsButton(gameContainer,new Image("Game/res/img/UI/mainButton.png").getScaledCopy(103,125),653,275,"settings",resourceBundle);
        loadGame = new Button(gameContainer, new Image("Game/res/img/UI/mainButton.png").getScaledCopy(103,125),756,275,"loadGame",resourceBundle);
       // screenProportion(gameContainer);
       // music.play();
        
        fire[0] = new Image("Game/res/img/MainMenu/fire1.png").getScaledCopy(280, 40);
        fire[1] = new Image("Game/res/img/MainMenu/fire2.png").getScaledCopy(280, 40);
        fire[2] = new Image("Game/res/img/MainMenu/fire3.png").getScaledCopy(280, 40);
        fire[3] = new Image("Game/res/img/MainMenu/fire4.png").getScaledCopy(280, 40);
        fire[4] = new Image("Game/res/img/MainMenu/fire5.png").getScaledCopy(280, 40);
        fire[5] = new Image("Game/res/img/MainMenu/fire6.png").getScaledCopy(280, 40);
        fire[6] = new Image("Game/res/img/MainMenu/fire7.png").getScaledCopy(280, 40);
        fire[7] = new Image("Game/res/img/MainMenu/fire8.png").getScaledCopy(280, 40);
        fire[8] = new Image("Game/res/img/MainMenu/fire9.png").getScaledCopy(280, 40);
        
        spark[0] = new Image("Game/res/img/MainMenu/spark1.png").getScaledCopy(280, 40);
        spark[1] = new Image("Game/res/img/MainMenu/spark2.png").getScaledCopy(280, 40);
        spark[2] = new Image("Game/res/img/MainMenu/spark3.png").getScaledCopy(280, 40);
        spark[3] = new Image("Game/res/img/MainMenu/spark4.png").getScaledCopy(280, 40);
        spark[4] = new Image("Game/res/img/MainMenu/spark5.png").getScaledCopy(280, 40);
        spark[5] = new Image("Game/res/img/MainMenu/spark6.png").getScaledCopy(280, 40);
        spark[6] = new Image("Game/res/img/MainMenu/spark7.png").getScaledCopy(280, 40);
        spark[7] = new Image("Game/res/img/MainMenu/spark8.png").getScaledCopy(280, 40);
        spark[8] = new Image("Game/res/img/MainMenu/spark9.png").getScaledCopy(280, 40);
        spark[9] = new Image("Game/res/img/MainMenu/spark10.png").getScaledCopy(280, 40);
       
        
        fireAnimation = new Animation(fire,300, true);
        sparkAnimation = new Animation(spark,300, true);

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

    	
    	
       // graphics.scale(propW,propH);// масштабируем изображение к размеру экрана
        graphics.drawImage(background,0,0);
       // graphics.scale(1/propW,1/propH);// для всех остальных элементов возращаем стандартный масштаб
        graphics.drawString(Mouse.getX()+"      "+Mouse.getY(),20,100);
        fireAnimation.draw(566,430);
        sparkAnimation.draw(566,430);
        super.render(gameContainer,stateBasedGame,graphics);
        if(settingsB.getDrawMenu()){
            newGame.setInvisible();
            settingsB.setInvisible();
            loadGame.setInvisible();
            exit.setInvisible();

        }
        else {
            settingsB.setVisible();
            newGame.setVisible();
            loadGame.setVisible();
            exit.setVisible();
        }

        newGame.redraw(gameContainer,graphics,resourceBundle);
        settingsB.redraw(gameContainer,graphics,resourceBundle);
        loadGame.redraw(gameContainer,graphics,resourceBundle);
        exit.render(gameContainer,graphics);

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
    
    	if (stateBasedGame.getCurrentStateID() == 0 && !musicPlaying ) {
    				musicPlaying = true;
    				music.play();
    				
    			}

    }

    protected void screenProportion( GameContainer gameContainer){
            float w,bw,h,bh;
            w=gameContainer.getWidth();
            bw=3264;
            h=gameContainer.getHeight();
            bh = 2448;
            propW = w/bw;
            propH=h/bh;

    }
}
