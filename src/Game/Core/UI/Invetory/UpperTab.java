package Game.Core.UI.Invetory;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.GUIContext;

public class UpperTab extends ButtonNextTab{
    private int index;
    private boolean status;//флажок активна ли вкладка

    public UpperTab(GUIContext container, Image state1, Image state2, int x, int y, int index){
        super(container, state1, state2, x, y);
        this.index = index;
        this.status = false;
    }

    @Override
    public void render(GUIContext container, Graphics g){
        super.render(container, g);

        if(status){
            g.drawImage(state2, super.getX(), super.getY());
        }else{
            g.drawImage(state1, super.getX(), super.getY());
        }
    }

    public void changeStatus(boolean status){

        this.status = status;
    }

    public int getIndex() {
        return index;
    }


}
