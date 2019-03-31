package Game.Core.UI.Invetory;

import java.util.ArrayList;

public class Task {
	
	private String name;
	private boolean status;
	private int x,y;

	
	Task (String name, boolean status, int x , int y) {
		this.name = name;
		this.status = status;
		this.x = x;
		this.y = y;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean getStatus () {
		return status;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

}
