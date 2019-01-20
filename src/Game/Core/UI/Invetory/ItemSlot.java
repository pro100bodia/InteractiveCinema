package Game.Core.UI.Invetory;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;

import Game.Core.UI.Invetory.Item;

public class ItemSlot extends  AbstractComponent{
	
	
	public static final int SLOTSIZE = 50;
	
	private int x, y;
	
	private Item item;
	

	
	public ItemSlot(GUIContext context, int x, int y) {
		super(context);
		this.x = x;
		this.y = y;

		
	}
	

	
	public Item getItem() {
		
		return item;
	}
	
	public void addItem(Item item) {
		this.item=item;
		
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
		return x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void render(GUIContext arg0, Graphics g) throws SlickException {
		g.setColor(Color.gray);
		g.fillRect(x, y, SLOTSIZE, SLOTSIZE);
		
		g.setColor(Color.black);
		g.drawRect(x, y, SLOTSIZE, SLOTSIZE);

		if(item!= null && item.getTexture() != null) {
		g.drawImage(item.getTexture(), x, y);
		}
	

		
	}

	@Override
	public void setLocation(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}



	public void tick() {
		// TODO Auto-generated method stub
		
	}



	public void setItem(Item item) {
		this.item = item;
	}

}
