package Game.Core.UI.Invetory;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;

public class ButtonNextTab extends MouseOverArea {
	
	Image state1, state2;

	public ButtonNextTab(GUIContext container, Image state1, Image state2, int x, int y) {
		super(container, state1, x, y);
	
		this.state1 = state1;
		this.state2 = state2;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void render(GUIContext container, Graphics g)  {
		if(isMouseOver()) {
			g.drawImage(state2, super.getX(), super.getY());
		} else {
			g.drawImage(state1, super.getX(), super.getY());
		}
	}

}
