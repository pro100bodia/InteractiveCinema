package Game.Core.UI.Invetory;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;



public class Inventory extends AbstractComponent implements MouseListener {
	
	
		public static boolean isOpen = false;
		public static int mouseX;
		public static int mouseY;
		
		public static boolean isClicked;
		
		
		private Image background;
	
		private int x, y, tab, draw;
		private int width, height;
		
		private ButtonNextTab nextT;
		private ButtonPrevTab prevT;
		
		private Image tabOn, tabOff;
		
		private ArrayList<Task> tasks;
	
		private Animation openNote;
		
		public Inventory (GUIContext context, int x, int y) {
			super(context);
			this.x = x;
			this.y = y;
			
			try {
				background = new Image ("Game/res/img/TAB/note 18.png").getScaledCopy(600,650);
				
				nextT = new ButtonNextTab(context,new Image("Game/res/img/TAB/rightButtonOff.png").getScaledCopy(40,80),
						new Image ("Game/res/img/TAB/rightButtonOn.png").getScaledCopy(40,80),825, 580);
				prevT = new ButtonPrevTab(context, new Image ("Game/res/img/TAB/leftButtonOff.png").getScaledCopy(40,80),
						new Image ("Game/res/img/TAB/leftButtonOn.png").getScaledCopy(40,80),770, 580);
			
				tabOn = new Image("Game/res/img/TAB/tabOn.png").getScaledCopy(120,30);
				tabOff = new Image("Game/res/img/TAB/tabOff.png").getScaledCopy(120,30);
				
		
				
				Image [] note =  {
						new Image ("Game/res/img/TAB/note 1.png").getScaledCopy(600,650),
						new Image ("Game/res/img/TAB/note 2.png").getScaledCopy(600,650),
						new Image ("Game/res/img/TAB/note 3.png").getScaledCopy(600,650),
						new Image ("Game/res/img/TAB/note 4.png").getScaledCopy(600,650),
						new Image ("Game/res/img/TAB/note 5.png").getScaledCopy(600,650),
						new Image ("Game/res/img/TAB/note 6.png").getScaledCopy(600,650),
						new Image ("Game/res/img/TAB/note 7.png").getScaledCopy(600,650),
						new Image ("Game/res/img/TAB/note 8.png").getScaledCopy(600,650),
						new Image ("Game/res/img/TAB/note 9.png").getScaledCopy(600,650),
						new Image ("Game/res/img/TAB/note 10.png").getScaledCopy(600,650),
						new Image ("Game/res/img/TAB/note 11.png").getScaledCopy(600,650),
						new Image ("Game/res/img/TAB/note 12.png").getScaledCopy(600,650),
						new Image ("Game/res/img/TAB/note 13.png").getScaledCopy(600,650),
						new Image ("Game/res/img/TAB/note 14.png").getScaledCopy(600,650),
						new Image ("Game/res/img/TAB/note 15.png").getScaledCopy(600,650),
						new Image ("Game/res/img/TAB/note 16.png").getScaledCopy(600,650),
						new Image ("Game/res/img/TAB/note 17.png").getScaledCopy(600,650),
						new Image ("Game/res/img/TAB/note 18.png").getScaledCopy(600,650),
						
				};
				
				draw = 0;
				tab=50;
				openNote = new Animation(note,100,true);
				openNote.setLooping(false);
				
				tasks = new ArrayList<Task>();
				
				tasks.add(new Task ("Убить шерифа", false,490,140));
				tasks.add(new Task ("Оживить шерифа", true,490,180));
				
			} catch (SlickException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
		}
		
		
		public void setIsOpen(boolean isOpen) {
			this.isOpen = isOpen;
		}



		@Override
		public void render(GUIContext arg0, Graphics g) throws SlickException {
			
			if(isOpen) {
				
				//g.drawImage(background, x+300,y+20);
				openNote.draw(x+300,y+20);
				g.drawImage(tabOff, x+700,y);
				g.drawImage(tabOff, x+600,y);
				g.drawImage(tabOff, x+500,y);
				g.drawImage(tabOn, x+400,y);
				
				prevT.render(arg0, g);
				nextT.render(arg0, g); 
				g.setColor(Color.red);
				
				if(openNote.isStopped()) {
				for(Task task : tasks) {
	    		g.drawString(task.getName(), task.getX(), task.getY());
				}
				}

			}
			// TODO Auto-generated method stub
			
		}



		
		public void tick() {
		
		}
		
		
		@Override
		public void setLocation(int arg0, int arg1) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(int button,int x,int y) {
			isClicked = true;
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
