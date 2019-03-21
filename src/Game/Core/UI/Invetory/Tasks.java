package Game.Core.UI.Invetory;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.StateBasedGame;

public class Tasks extends Tab {

	private ArrayList<Task> tasks;
	
	public Tasks(GUIContext container, Image image, int x, int y) {
		super(container, image, x, y);
		// TODO Auto-generated constructor stub
		tasks = new ArrayList<Task>();
		
		//tasks.add(new Task ("Убить шерифа", false));
		//tasks.add(new Task ("Оживить шерифа", true));
		
	}
	

    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) {
        
    	
    		
    	
    }

}
