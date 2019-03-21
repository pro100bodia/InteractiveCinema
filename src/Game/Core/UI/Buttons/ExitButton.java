package Game.Core.UI.Buttons;

import Game.Core.States.MainMenu;
import Game.Core.UI.Properties.GameProperties;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ResourceBundle;

public class ExitButton extends Button {
    Image image, focusImage;
    Button agree, disagree;
    private  MainMenu mainMenu;

    public ExitButton(GUIContext container, Image image, int x, int y, MainMenu mainMenu, ResourceBundle resourceBundle) {
        super(container, image, x, y);
        this.image = image;
        this.mainMenu = mainMenu;



        try {
            agree = new Button(container, new Image("Game/res/img/UI/mainButton.png").getScaledCopy(156,125), 703, 275, "agree",resourceBundle);
            disagree = new Button(container, new Image("Game/res/img/UI/mainButton.png").getScaledCopy(156,125),550,275,"disagree",resourceBundle);

            focusImage = new Image("/src/Game/res/img/UI/exitOnFocus.png").getScaledCopy(50, 350);
        } catch (SlickException e) {
            e.printStackTrace();
        }
        super.setMouseOverImage(focusImage);
    }

    @Override
    public void render(GUIContext container, Graphics g) {
        super.render(container, g);
        try {
                if (this.clicked) {
                    agree.setVisible();
                    disagree.setVisible();

                    agree.render(container, g);
                    disagree.render(container, g);


                    g.drawString ("Do you want to leave the game?" , 600, 435);


                    if (agree.clicked){
                        System.exit(0);
                    }
                    if (disagree.clicked){
                        agree.setInvisible();
                        disagree.setInvisible();
                        disagree.clicked = false;
                        this.clicked = false;                    }

                }


        }catch (Exception ex){ex.printStackTrace();}

        }

    @Override
    public void onClick() {
        super.onClick();
     //   System.exit(0);
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
