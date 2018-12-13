package Game.Core.UI.Buttons;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;

public class ExitButton extends Button {
    Image image, focusImage;
    public ExitButton(GUIContext container, Image image, int x, int y) {
        super(container, image, x, y);
        this.image = image;
        try {
            focusImage = new Image("/src/Game/res/img/UI/exitOnFocus.png");
        } catch (SlickException e) {
            e.printStackTrace();
        }
        super.setMouseOverImage(focusImage);
    }

    @Override
    public void render(GUIContext container, Graphics g) {
        super.render(container, g);
    }

    @Override
    public void onClick() {
        super.onClick();
        System.exit(0);
    }

    @Override
    public void onFocus() {
        super.onFocus();
    }

    @Override
    public void setMouseOverImage(Image image) {
        super.setMouseOverImage(this.focusImage);
    }
}
