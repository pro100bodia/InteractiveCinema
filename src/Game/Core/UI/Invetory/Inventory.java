package Game.Core.UI.Invetory;

import org.newdawn.slick.*;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.StateBasedGame;


public class Inventory extends AbstractComponent implements MouseListener {
		public static boolean isOpen = false;
		public static int mouseX;
		public static int mouseY;
		
		public static boolean isClicked;
		
		
		private int x, y;
//		private int tab, draw;
//		private int width, height;
		
		private ButtonNextTab nextT;
		private ButtonPrevTab prevT;
		
		private Image tabOn, tabOff;

		private int openedPage;

		//private ArrayList<Task> tasks;
	
		private Notepad notepad;
		
		public Inventory (GUIContext context, int x, int y) {
			super(context);
			this.x = x;
			this.y = y;

			openedPage = 0;

			try {
//				background = new Image ("Game/res/img/TAB/note 18.png").getScaledCopy(600,650);
				
				nextT = new ButtonNextTab(context,new Image("Game/res/img/TAB/rightButtonOff.png").getScaledCopy(40,80),
						new Image ("Game/res/img/TAB/rightButtonOn.png").getScaledCopy(40,80),825, 580);
				prevT = new ButtonPrevTab(context, new Image ("Game/res/img/TAB/leftButtonOff.png").getScaledCopy(40,80),
						new Image ("Game/res/img/TAB/leftButtonOn.png").getScaledCopy(40,80),770, 580);
			
				tabOn = new Image("Game/res/img/TAB/tabOn.png").getScaledCopy(120,30);
				tabOff = new Image("Game/res/img/TAB/tabOff.png").getScaledCopy(120,30);
//				draw = 0;
//				tab=50;

//				tasks = new ArrayList<Task>();
//
//				tasks.add(new Task ("Убить шерифа", false,490,140));
//				tasks.add(new Task ("Оживить шерифа", true,490,180));
				
			} catch (SlickException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			notepad = new Notepad(context, x, y);
			notepad.turnTo(openedPage);//открываем блокнот на первую страницу сразу при открытии инвертаря

		}
		
		
		public void setIsOpen(boolean isOpen) {
			this.isOpen = isOpen;
		}



		@Override
		public void render(GUIContext arg0, Graphics g) throws SlickException {
			if(isOpen) {
				//g.drawImage(background, x+300,y+20);
				notepad.render(arg0, g);
				g.drawImage(tabOff, x+700,y);
				g.drawImage(tabOff, x+600,y);
				g.drawImage(tabOff, x+500,y);
				g.drawImage(tabOn, x+400,y);

				prevT.render(arg0, g);
				nextT.render(arg0, g);
				g.setColor(Color.red);
			}
			// TODO Auto-generated method stub
			
		}

//		public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
//
//			//notepad.update(gameContainer, i);
//		}

		@Override
		public void mousePressed(int button,int x,int y) {

			//nextTButton is pressed
			if(x >= nextT.getX() && x <= nextT.getX() + 40 &&
					y >= nextT.getY() && y <= nextT.getY() + 80){
				if(openedPage < 3){
					openedPage ++;
					notepad.turnTo(openedPage);
				}
			}

			//prevTButton is pressed
			if(x > prevT.getX() && x <= prevT.getX() + 40 &&
					y >= prevT.getY() && y <= prevT.getY() + 80){
				if(openedPage > 0){
					openedPage--;
					notepad.turnTo(openedPage);
				}
			}

			//
		}

		
		public void tick() {

		}
		
		
		@Override
		public void setLocation(int arg0, int arg1) {
			// TODO Auto-generated method stub
			
		}
		

	
		@Override
		public void mouseReleased(int button,int x,int y) {
			isClicked = false;
		}
		
		@Override
		public void mouseDragged(int oldx, int oldy, int newx, int newy) {
			mouseX =  newx;
			mouseY = newy;
		}
		@Override
		public void mouseMoved(int oldx, int oldy, int newx, int newy) {
			mouseX =  newx;
			mouseY = newy;
		}
		@Override
		public int getHeight() {
			// TODO Auto-generated method stub
			return 0;
		}


		@Override
		public int getWidth() {
			// TODO Auto-generated method stub
			return 0;
		}


		@Override
		public int getX() {
			// TODO Auto-generated method stub
			return 0;
		}


		@Override
		public int getY() {
			// TODO Auto-generated method stub
			return 0;
		}

}
