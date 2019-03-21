package Game.Core.UI.Menues;

import Game.Core.UI.Buttons.ButtonsAndControls;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;

public class Dialog extends MouseOverArea {
    private String option, value1,value2;
    private ButtonsAndControls v1,v2;
    private String tetx;

    public Dialog(GUIContext container, Image image, int x, int y) {
        super(container, image, x, y);
    }

    public void createSettingsDialog(String option, String v1, String v2){
        this.option = option;
        this.value1=v1;
        this.value2=v2;
    }
    public void addText(String s){
        tetx=s;
    }

    private void init(){

    }

    @Override
    public void render(GUIContext container, Graphics g) {
        super.render(container, g);
    }


}
