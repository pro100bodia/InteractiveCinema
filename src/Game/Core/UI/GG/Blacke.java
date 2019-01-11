package Game.Core.UI.GG;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;


public class Blacke{
	private float x;
	private float y;
	private float moveTo;

	private int width;
	private int height;

	private Image  ggImage;

	SpriteSheet  moveToLeft; // Атлас движений героя влево
	SpriteSheet  moveToRight; // Атлас движений героя вправо

	Image[] playerLeft = new Image[6] ; //Массив для хранения изображений с атласа для анимации движения влево
	Image[] playerRight = new Image[6];//Массив для хранения изображений с атласа для анимации движения вправо

	Animation aTommy; // Объект для анимации

	private boolean isItMove; // Флаг находится ли герой в движении

	private GameContainer gameContainer;

	public Blacke(int x, String title, GameContainer gameContainer) {
		this.gameContainer=gameContainer;
		this.x = x;
		y=315;
		moveTo = x;

		width = 135;
		height = 335;
		try {
			// Загружаем атлас , устанавливаем размер кадра
			moveToLeft = new SpriteSheet("Game/res/img/UI/GGsketch_5x2.png", 183, 397);
			//Заполняем массив изображений кадрами из атласа, перемещаемся как по двумерному массиву
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

			//Задаем первоначальный спрайт для ГГ
			ggImage = moveToLeft.getSprite(1,1);


			isItMove = false;

			//Передаем в анимацию массив изображений, задержку переключения, флаг для включения анимации
			aTommy = new Animation(playerLeft,300, true);


		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void init(GameContainer gameContainer) throws SlickException {



	}

	public void render(GameContainer gameContainer, Graphics g) throws SlickException {
		//Если активен флаг на движение рисуем анимацию, иначе статичный спрайт

		if(isItMove) {
			aTommy.draw(x,y,width,height);
		} else {
			ggImage.draw(x,y,width,height);
		}
	}

	public void update(GameContainer gameContainer, int t) throws SlickException {

		//Двигаем ГГ относительно оси Х попутно проверяя условие остановки
		if(x < moveTo) {
			this.x +=5;
			if (x > moveTo)
				x = moveTo;
		}

		if(x > moveTo) {
			this.x -=5;
			if (x < moveTo)
				x = moveTo;
		}

		if (x == moveTo){
			isItMove = false;
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
		return width;
	}

	public void setX(float x) {
		this.x = x;
	}
}