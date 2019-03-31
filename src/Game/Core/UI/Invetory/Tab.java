package Game.Core.UI.Invetory;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;

public class Tab extends MouseOverArea {
	Image page;

	public Tab(GUIContext container, Image image, int x, int y) {
		super(container, image, x, y);
		// TODO Auto-generated constructor stub
		this.page = image;
	}

	@Override
	public void render(GUIContext container, Graphics g)  {
		g.drawImage(page, super.getX(), super.getY());
	}

	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {

	}
	
}
