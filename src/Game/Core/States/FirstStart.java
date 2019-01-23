package Game.Core.States;

import Game.Core.GameState;
import Game.Core.UI.Buttons.ChangeStateButton;
import Game.Core.UI.Properties.GameProperties;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;
import org.newdawn.slick.state.StateBasedGame;

import java.io.File;
import java.io.IOException;

public class FirstStart extends GameState {
    private Image background;
    private ChangeStateButton startButton;
    private GameProperties properties;
    private  float propW, propH;

    public FirstStart(int i) {
        super(i);
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        super.init(gameContainer, stateBasedGame);
        background = new Image("Game/res/img/FirstStart/bar_0%.png");
        screenProportion(gameContainer);
       //startButton= new ChangeStateButton(gameContainer,2142,1092, new Image("Game/res/img/FirstStart/switch.png"),new Image("Game/res/img/FirstStart/switchFocused.png"),stateBasedGame,0,propW);
        //  startButton= new ChangeStateButton(gameContainer,(int)(2142*propW),(int) (1092*propH), new Image("Game/res/img/FirstStart/switch.png"),new Image("Game/res/img/FirstStart/switchFocused.png"),stateBasedGame,0,propW,propH);
        /* две строки сверху - было добалено изображения выключателя в "натуральный" размер, и по координатам как на рисунке,
            в первом случае, без prop (соотношение экрана к размеру картинки) объекта кнопки небыло в окне, или же после
             graphics.scale(propW,propH); сама картинка находится в окне, но объект, который реагирует на события находился
             за пределами экрана в точке 2142\1092

        */
    
        
        
        startButton= new ChangeStateButton(gameContainer, 892,338, new Image("Game/res/img/FirstStart/switch.png"),new Image("Game/res/img/FirstStart/switchFocused.png"),stateBasedGame,0);


    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        super.render(gameContainer, stateBasedGame, graphics);
       // graphics.scale(propW,propH);
      //  graphics.drawImage(background,0,0);
        // graphics.scale(1/propW,1/propH);
        startButton.render(gameContainer,graphics);
       

        graphics.drawString(Mouse.getX()+"      "+Mouse.getY(),20,100);
        if(Mouse.isButtonDown(Input.MOUSE_LEFT_BUTTON))
        {
           // startButton.onClick();
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        super.update(gameContainer, stateBasedGame, i);
        
    }
    protected void screenProportion( GameContainer gameContainer){
        float bW, bH;

        float w,bw,h,bh;
        w=gameContainer.getWidth();
        bw=3264;
        h=gameContainer.getHeight();
        bh = 2448;
        propW = w/bw;
        propH=h/bh;
        //bH=b*propW;
        //bW=;

    }
}