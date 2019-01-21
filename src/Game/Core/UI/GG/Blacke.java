package Game.Core.UI.GG;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import Game.Core.Main;
import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;



public class Blacke extends BasicGame implements MouseListener {
	
private float scale = (float)0.7115;
	
	private Image  ggImage; // Спрайт ГГ в положении стоя
	
	private Image scaledLeft, scaledRight;
	
	private boolean isItMove; // Флаг находится ли герой в движении
	
	private float x, y, moveTo; // Координаты спрайта ГГ и куда кликнули мышкой относительно оси х
	
	private int width, height;
	
	private GameContainer gameContainer;
	
	private SpriteSheet  moveToLeft; // Атлас движений героя влево
	private SpriteSheet  moveToRight; // Атлас движений героя вправо
	
	private Image[] playerLeft = new Image[6] ; //Массив для хранения изображений с атласа для анимации движения влево
	private Image[] playerRight = new Image[6];//Массив для хранения изображений с атласа для анимации движения вправо

	private Animation left,right, currentMove; // Объект для анимации
	
	public Blacke(String title, GameContainer gameContainer) {
		super("GG");
		this.gameContainer=gameContainer;
		
		
		x=(int)( 885*scale);
		y=(int)( 464*scale);
		moveTo = x;
		try {
			// Загружаем атлас , устанавливаем размер кадра
			scaledLeft = new Image("Game/res/img/UI/GGsketch_5x2.png");
			moveToLeft = new SpriteSheet(scaledLeft.getScaledCopy((int)(scaledLeft.getWidth()*scale), (int)(scaledLeft.getHeight()*scale)), (int)(183*scale), (int)(397*scale));
			//Заполняем массив изображений кадрами из атласа, перемещаемся как по двумерному массиву
	    	         playerLeft[0] = moveToLeft.getSprite(0,0);
	    	         playerLeft[1] = moveToLeft.getSprite(1,0);
	    	         playerLeft[2] = moveToLeft.getSprite(2,0);
	    	         playerLeft[3] = moveToLeft.getSprite(3,0);
	    	         playerLeft[4] = moveToLeft.getSprite(4,0);
	    	         playerLeft[5] = moveToLeft.getSprite(0,1);
	    	
	    	scaledRight = new Image("Game/res/img/UI/GGsketchreverse_5x2.png");
	    	moveToRight = new SpriteSheet(scaledRight.getScaledCopy((int)(scaledRight.getWidth()*scale), (int)(scaledRight.getHeight()*scale)), (int)(183*scale), (int)(397*scale));
	    	         playerRight[0] = moveToRight.getSprite(1,0);
	    	         playerRight[1] = moveToRight.getSprite(2,0);
	    	         playerRight[2] = moveToRight.getSprite(3,0);
	    	         playerRight[3] = moveToRight.getSprite(4,0);
	    	         playerRight[4] = moveToRight.getSprite(0,1);
	    	         playerRight[5] = moveToRight.getSprite(1,1);
	    	 
	    	         //Задаем первоначальный спрайт для ГГ
	    	         ggImage = moveToLeft.getSprite(1,1);
	    	         
	    	         
	    	    isItMove = false;
	    	    
	    	    //Передаем в анимацию массив изображений, задержку переключения, флаг для включения анимации
	    	    
	    	    left= new Animation(playerLeft,350, true);
	    	    right= new Animation(playerRight,350, true);
	    	    currentMove= left;
			
		    
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
    	
    	//Если активен флаг на движение рисуем анимацию, иначе статичный спрайт
    	
    	if(isItMove == true) {
    	currentMove.draw(x,y);
    	} else {
    		ggImage.draw(x,y);
    	}
    }
    @Override
    public void update(GameContainer gameContainer, int t) throws SlickException {
    	
    	
    	//Двигаем ГГ относительно оси Х попутно проверяя условие остановки
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
    
    
    //Метод определяет в какую сторону движется персонаж и заменяет соответствующие спрайты
    public void moveTo(float x) {
    		
    		moveTo = x;
    		
    		if(moveTo > this.x + 119)
    		{
    			isItMove = true;
    			ggImage = moveToRight.getSprite(0,0);
    			this. currentMove= right;
    		}
    		
    		if(moveTo < this.x)
    		{
    			isItMove = true;
    			ggImage = moveToLeft.getSprite(1,1);
    			this. currentMove = left;
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