package Game.Core.UI.Invetory;

import java.util.concurrent.CopyOnWriteArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;

import Game.Core.UI.Invetory.Item;


public class Inventory extends AbstractComponent implements MouseListener {
	
	
		public static boolean isOpen = false;
		private boolean hasBeenPressed = false;
		public static int mouseX;
		public static int mouseY;
		
		public static boolean isClicked;
	
		private int x, y;
		private int width, height;
		
		private int numCols = 6;
		private int numRows = 4;
	
		private Item currSelectedSlot;
		private CopyOnWriteArrayList<ItemSlot> itemsSlots = new CopyOnWriteArrayList<ItemSlot>();
		
		
		public Inventory (GUIContext context, int x, int y) {
			super(context);
			this.x = x;
			this.y = y;
			
			for (int i = 0; i < numCols; i++) {
				for(int j = 0; j < numRows; j++) {
					if(j == (numRows-1)) {
						y+=35;
					}
						itemsSlots.add(new ItemSlot(context, x + (i * ItemSlot.SLOTSIZE + 10), y + (j * ItemSlot.SLOTSIZE +10 )));
					
					if(j == (numRows-1)) {
						y-=35;
					}
					
				}
				
			}
			
			width = numCols *(ItemSlot.SLOTSIZE +10);
			height = numRows *(ItemSlot.SLOTSIZE +10) + 35;
			
			try {
				itemsSlots.get(2).setItem(new Item(context,"Dildo",new Image("Game/res/img/UI/Black.png"))) ;
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			
		}
		
		
		public void setIsOpen(boolean isOpen) {
			this.isOpen = isOpen;
		}



		@Override
		public void render(GUIContext arg0, Graphics g) throws SlickException {
			
			if(isOpen) {
				
				g.setColor(Color.lightGray);
				g.fillRect(x - 17, y - 17, width + 30, height + 30);
				g.setColor(Color.blue);
				g.drawRect(x - 17, y - 17, width + 30, height + 30);
				g.setColor(Color.red);
				g.fillRect(width + 45, y - 17, 15 , 15 );
				
				for(ItemSlot is : itemsSlots) {
					if(is != null)
					is.render(arg0, g);
				}
				

				if(currSelectedSlot != null) {
					g.drawImage(currSelectedSlot.getTexture(), mouseX, mouseY, null);
				}
			
		}
			// TODO Auto-generated method stub
			
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

			
		public void tick() {
			
			if(isOpen) {
				
				Rectangle exit = new Rectangle(width + 45, y - 17, 15 , 15 );
				if(isClicked) {
					if(exit.contains(mouseX, mouseY)) {
						isOpen = false;
					}
				for(ItemSlot is : itemsSlots) {
					
					Rectangle temp2 = new Rectangle(is.getX(), is.getY(), ItemSlot.SLOTSIZE, ItemSlot.SLOTSIZE);
				
					if(isClicked) {
						if(temp2.contains(mouseX, mouseY) && !hasBeenPressed) {
							hasBeenPressed = true;
							System.out.println(hasBeenPressed);
							if(currSelectedSlot == null) {
								if(is.getItem() != null) {
									currSelectedSlot = is.getItem();
									is.setItem(null);
								} 
							} else {
								System.out.println(isClicked);
									if(is.getItem()==null) {
										is.addItem(currSelectedSlot);
									} else {
										is.setItem(currSelectedSlot);
									}
									
									currSelectedSlot = null;
							}
						}
					}
				}
			}
		
			
				
				if(hasBeenPressed && ! isClicked) {
					hasBeenPressed = false;
				}
				
				
			}
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
