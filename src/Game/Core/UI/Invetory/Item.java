package Game.Core.UI.Invetory;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;

public class Item extends AbstractComponent {
	
	private String name;
	private Image texture;
	
	
	public Item(GUIContext context, String name, Image texture) {
		super(context);
		this.name = name;
		this.texture = texture;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Image getTexture() {
		return texture;
	}


	public void setTexture(Image texture) {
		this.texture = texture;
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


	@Override
	public void render(GUIContext arg0, Graphics g) throws SlickException {
		
		
	};


	@Override
	public void setLocation(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
}
