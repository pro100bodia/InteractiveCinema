package Game.Core.UI.Invetory;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.GUIContext;

public class UpperTab extends ButtonNextTab {
    private int index;

    public UpperTab(GUIContext container, Image state1, Image state2, int x, int y, int index){
        super(container, state1, state2, x, y);
        this.index = index;
    }

    @Override
    public void render(GUIContext container, Graphics g){
        super.render(container, g);
    }

    public int getIndex() {
        return index;
    }
}
