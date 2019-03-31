package Game.Core.UI.Invetory;

import org.newdawn.slick.*;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;

import java.util.ArrayList;
import java.util.List;


public class Inventory extends AbstractComponent implements MouseListener {
		public static boolean isOpen = false;
		public static int mouseX;
		public static int mouseY;
		
		public static boolean isClicked;
		
		
		private int x, y;
		private ButtonNextTab nextT;
		private ButtonPrevTab prevT;
		
		private int openedPage;

		private Notepad notepad;

		private List<UpperTab> tabs;
		
		public Inventory (GUIContext context, int x, int y) {
			super(context);
			this.x = x;
			this.y = y;

			openedPage = 0;

			try {
				nextT = new ButtonNextTab(context,new Image("Game/res/img/TAB/rightButtonOff.png").getScaledCopy(40,80),
						new Image ("Game/res/img/TAB/rightButtonOn.png").getScaledCopy(40,80),825, 580);
				prevT = new ButtonPrevTab(context, new Image ("Game/res/img/TAB/leftButtonOff.png").getScaledCopy(40,80),
						new Image ("Game/res/img/TAB/leftButtonOn.png").getScaledCopy(40,80),770, 580);

                tabs = new ArrayList<UpperTab>();
                tabs.add(new UpperTab(context, new Image("Game/res/img/TAB/tabOn.png").getScaledCopy(120,30), new Image("Game/res/img/TAB/tabOff.png").getScaledCopy(120,30), x+400, y, 0));
                tabs.add(new UpperTab(context, new Image("Game/res/img/TAB/tabOn.png").getScaledCopy(120,30), new Image("Game/res/img/TAB/tabOff.png").getScaledCopy(120,30), x+500, y, 1));
                tabs.add(new UpperTab(context, new Image("Game/res/img/TAB/tabOn.png").getScaledCopy(120,30), new Image("Game/res/img/TAB/tabOff.png").getScaledCopy(120,30), x+600, y, 2));
                tabs.add(new UpperTab(context, new Image("Game/res/img/TAB/tabOn.png").getScaledCopy(120,30), new Image("Game/res/img/TAB/tabOff.png").getScaledCopy(120,30), x+700, y, 3));

                tabs.get(0).changeStatus(true);//отмечаем первую вкладку активной
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
				notepad.render(arg0, g);

				for(UpperTab ut: tabs){
					ut.render(arg0, g);
					ut.changeStatus(false);
				}
				tabs.get(openedPage).changeStatus(true);

				prevT.render(arg0, g);
				nextT.render(arg0, g);

			}
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(int button,int x,int y) {

			openedPage = notepad.getCurrent();

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

			//one of tabs is pressed
            int i;
			UpperTab curTab = tabs.get(0);
            for(i = 0; i < tabs.size(); i++)
            {
                curTab = tabs.get(i);
                if(x > curTab.getX() && x <= curTab.getX() + 120 &&
                        y >= curTab.getY() && y <= curTab.getY() + 30){

                		openedPage = curTab.getIndex();
                	    notepad.turnTo(openedPage);

                }
            }
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
