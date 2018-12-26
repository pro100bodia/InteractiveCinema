package Game.Core.UI.GG;

import java.util.concurrent.TimeUnit;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;


public class Blacke extends BasicGame implements MouseListener {
	
	private Image ggImageLeft ;
	private Image ggImageRight ;
	private Image  ggImage;
	
	private boolean isItMove;
	
	private float x, y, moveTo;
	GameContainer gameContainer;
	
	SpriteSheet  moveToLeft;
	SpriteSheet  moveToRight;
	Image[] playerLeft = new Image[6] ;
	Image[] playerRight = new Image[6];

	Animation aTommy;
	
	public Blacke(String title, GameContainer gameContainer) {
		super("GG");
		this.gameContainer=gameContainer;
		x=(int)( 885*0.71);
		y=(int)( 464*0.71);
		moveTo = x;
		try {
			ggImageLeft = new Image("Game/res/img/UI/blacke.png").getScaledCopy((int)( 168*0.71), (int)( 422*0.71));
			ggImageRight = new Image("Game/res/img/UI/blackeRight.png").getScaledCopy((int)( 168*0.71), (int)( 422*0.71));
			
			moveToLeft = new SpriteSheet("Game/res/img/UI/GGsketch_5x2.png", 183, 397);
	    	         playerLeft[0] = moveToLeft.getSprite(0,0);
	    	         playerLeft[1] = moveToLeft.getSprite(1,0);
	    	         playerLeft[2] = moveToLeft.getSprite(2,0);
	    	         playerLeft[3] = moveToLeft.getSprite(3,0);
	    	         playerLeft[4] = moveToLeft.getSprite(4,0);
	    	         playerLeft[5] = moveToLeft.getSprite(0,1);
	    	         
	    	moveToRight = new SpriteSheet("Game/res/img/UI/GGsketchreverse_5x2.png", 183, 397);
	    	         playerRight[0] = moveToRight.getSprite(1,0);
	    	         playerRight[1] = moveToRight.getSprite(2,0);
	    	         playerRight[2] = moveToRight.getSprite(3,0);
	    	         playerRight[3] = moveToRight.getSprite(4,0);
	    	         playerRight[4] = moveToRight.getSprite(0,1);
	    	         playerRight[5] = moveToRight.getSprite(1,1);
	    	 
	    	         
	    	         ggImage = moveToLeft.getSprite(1,1);
	    	         
	    	         
	    	    isItMove = false;
	    	    aTommy = new Animation(playerLeft,300, true);
			
		    
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
    	
    	if(isItMove == true) {
    	aTommy.draw(x,y);
    	} else {
    		ggImage.draw(x,y);
    	}
    }
    @Override
    public void update(GameContainer gameContainer, int t) throws SlickException {
    	
    	if(x < moveTo) {
    	this.x +=5;
    		if(x >= moveTo) {
    			isItMove = false;
    		}
    	}
    	
    	if(x > moveTo) {
        this.x -=5;
        	if(x <= moveTo) {
        		isItMove = false;
        	}
    	}
    	
    }
    
    public void moveTo(float x) {
    		moveTo = x;
    		
    		if(moveTo > this.x)
    		{
    			isItMove = true;
    			ggImage = moveToRight.getSprite(0,0);
    			this.aTommy = new Animation(playerRight,300, true);
    		}
    		
    		if(moveTo < this.x)
    		{
    			isItMove = true;
    			ggImage = moveToLeft.getSprite(1,1);
    			this.aTommy = new Animation(playerLeft,300, true);
    		}
    	
    	}

    public float getX() {
		return this.x;
	}
    public int getWidth(){
		return ggImage.getWidth();
	}
    public void setX(float x) {
    	this.x = x;
    }
    
    public void setIsItMove (boolean m) {
    	isItMove = m;
    }
    
}
