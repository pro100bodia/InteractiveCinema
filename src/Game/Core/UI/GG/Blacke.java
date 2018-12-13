package Game.Core.UI.GG;

import java.util.concurrent.TimeUnit;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;


public class Blacke extends BasicGame implements MouseListener {
	
	private Image ggImageLeft ;
	private Image ggImageRight ;
	private Image  ggImage;
	
	private float x, y, moveTo;
	GameContainer gameContainer;
	
	public Blacke(String title, GameContainer gameContainer) {
		super("GG");
		this.gameContainer=gameContainer;
		x=(int)( 885*0.71);
		y=(int)( 464*0.71);
		moveTo = x;
		try {
			ggImageLeft = new Image("Game/res/img/UI/blacke.png").getScaledCopy((int)( 168*0.71), (int)( 422*0.71));
			ggImageRight = new Image("Game/res/img/UI/blackeRight.png").getScaledCopy((int)( 168*0.71), (int)( 422*0.71));
			ggImage = ggImageLeft;
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
    	ggImage.draw(x,y);
    }
    @Override
    public void update(GameContainer gameContainer, int t) throws SlickException {
    	
    	if(x < moveTo) 
    	this.x +=5;
    	
    	if(x > moveTo)
        this.x -=5;
    	
    }
    
    public void moveTo(float x) {
    		moveTo = x;		
    		
    		if(moveTo > this.x)
    		{
    			this.ggImage = this.ggImageRight;
    		}
    		
    		if(moveTo < this.x)
    		{
    			this.ggImage = this.ggImageLeft;
    		}
    	
    	}
    
    public float getX() {return this.x;}
    public void setX(float x) { this.x = x;}
}
