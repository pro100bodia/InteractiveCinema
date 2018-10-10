/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState{
    
    public String mouse = "No input yet";
    public String gamestart = "New Game";
    public Menu(int state){
}
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
    }
 
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
       
     Image fon = new Image("src/menu/1.png");
      g.drawImage(fon, 0, 0);
      g.drawString(mouse, 50, 50);
      g.drawString(gamestart, 475, 255);
    }

public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
int xpos = Mouse.getX();
int ypos = Mouse.getY();
mouse = "Mouse position x:" + xpos + "y:" +ypos; 


}
public int getID(){
    return 0;
}
}