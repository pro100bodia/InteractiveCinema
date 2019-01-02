package Game.Core.UI.GG;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;


public class Blacke extends BasicGame implements MouseListener {
	private float x;
	private float y;
	private float moveTo;
	private float twiceX;
	private float twiceMove;

	private Image ggImageLeft ;
	private Image ggImageRight ;
	private Image  ggImage;

	private GameContainer gameContainer;

	public Blacke(int x, String title, GameContainer gameContainer) {
		super("GG");
		this.gameContainer=gameContainer;
		this.x = x;
		y=(int)( 464*0.71);
		moveTo = x;
		try {
			ggImageLeft = new Image("Game/res/img/UI/blacke.png").getScaledCopy((int)( 168*0.71), (int)( 422*0.71));
			ggImageRight = new Image("Game/res/img/UI/blackeRight.png").getScaledCopy((int)( 168*0.71), (int)( 422*0.71));
			ggImage = ggImageRight;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
    @Override
    public void init(GameContainer gameContainer) throws SlickException {
    	
    
    	
    }
	
  
    
    @Override
    public void render(GameContainer gameContainer, Graphics g) throws SlickException {
    	ggImage.draw(x + twiceX,y);
    }

    @Override
    public void update(GameContainer gameContainer, int t) throws SlickException {

		if(x < moveTo) { // движение в правую сторону
			if (moveTo - x <= 5)
				this.x = moveTo;
			else
				this.x += 5;
		}

		if(x > moveTo){ // движение в левую сторону
			if (x - moveTo <= 5)
				x = moveTo;
			else
				this.x -=5;
		}

		if(twiceX < twiceMove){
			if (twiceMove - twiceX <= 5)
				twiceX = twiceMove;
			else
				twiceX += 5;
		}

		if(twiceX > twiceMove){
			if (twiceX - twiceMove <= 5)
				twiceX = twiceMove;
			else
				twiceX -= 5;
		}
    	
    }
    
    public void moveTo(float x) {
    		moveTo = x;

		if (moveTo + twiceMove > this.x + twiceX){
			ggImage = ggImageRight;
		}

		if (moveTo + twiceMove < this.x + twiceX){
			ggImage = ggImageLeft;
		}
	}

	public float getX() {
		return this.x;
	}
    public int getWidth(){
		return ggImage.getWidth();
	}
	public int getMoveTo(){
    	return (int) moveTo;
	}
    public void setX(float x) {
    	this.x = x;
    }
    public void setTwiceMove (float move){
		twiceMove = move;
	}
	public void setDirection (String direction){
    	if (direction == "left"){
			ggImage = ggImageLeft;
		}else {
    		ggImage = ggImageRight;
		}
    }
}
