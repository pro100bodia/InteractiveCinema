package Game.Core.UI.Buttons;


import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;


import java.awt.Font;
import java.util.ResourceBundle;

public class Button extends MouseOverArea implements ButtonsAndControls {
    private boolean wasHere=true, singleClick=true;
    protected boolean clicked=false;
    protected int x,y;
    private String label;
    protected Image focusImage,image;
    private Sound sound;
    protected ResourceBundle bundle;
    protected String key;
    protected TrueTypeFont fontRus;
    private Font font;
    protected float scalex,scaley;

    public Button(GUIContext container, Image image, int x, int y) {
        super(container, image, x, y);
        this.x = x;
        this.y = y;
        this.image=image;
        this.scalex=0;
        this.scaley=0;
        try {
            sound=  new Sound("/src/Game/res/Sounds/buttonFocus.ogg");
            focusImage = new Image("/src/Game/res/img/UI/mainButtonOnFocus.png").getScaledCopy(103,125);
        } catch (SlickException e) {
            e.printStackTrace();
        }
        super.setMouseOverImage(focusImage);
        createFont();

        render(container,new Graphics(1366,768));
    }

    public Button (GUIContext container, Image image, Image fImage, int x, int y){
        super(container, image, x, y);
        this.focusImage=fImage;
        try {
            sound = new Sound("/src/Game/res/Sounds/buttonFocus.ogg");
        }
        catch (SlickException e){e.printStackTrace();}
        super.setMouseOverImage(fImage);
        createFont();
    }


    public void setScale(float xF, float yF){
        this.scalex = xF;
        this.scaley = yF;
        //       this.x = (int)(this.x*(1/xF));
//        this.y = (int)(this.y*(1/yF));
    }

    private void update(){
        this.x = (int)(this.x/(1/scalex)*0);
        this.y = (int)(this.y/(1/scaley));
    }


    public Button(GUIContext container, Image image, int x, int y, String key, ResourceBundle bundle){
        this(container, image, x, y);
        try {
            this.bundle= bundle;
            label = bundle.getString(key);
            this.key=key;
        }
        catch (NullPointerException e){}
    }

    @Override
    public void render(GUIContext container, Graphics g) {

        try {
            setCharset_Russian(g);
            label = bundle.getString(key);
        }
        catch (NullPointerException e){}
        if (isMouseOver()&&wasHere){ //���� ������������������ setMouseOverSound() �� ������������ ������ �� MouseOverArea ���������� updateImage
            wasHere=false;          // �� �������������� �������������������� ������������������������������ ���������� ���������������������� ������ ������������ render(),
            onFocus();              //�������������������� ����������������, �� ���� ������������������ ������������������������������ ����������
        }
        if (!isMouseOver()){
            wasHere=true;
        }
        if (scalex!=0)
        {
            super.setNormalImage(image.getScaledCopy((int)(image.getWidth()*scalex),(int)(image.getHeight()*scaley)));
            super.setMouseOverImage(this.focusImage.getScaledCopy((int)(focusImage.getWidth()*scalex),(int)(focusImage.getHeight()*scaley)));


            // g.scale(scalex,scaley);
        }
        super.render(container, g);


        if(label!=null){
            g.setColor(Color.white);
            g.drawString(label,this.x+20,this.y+25);
        }
        if(isMouseOver()&& Mouse.isButtonDown(Input.MOUSE_LEFT_BUTTON)){
            if (singleClick)
            {
                onClick();
                wasHere=false;
                singleClick=false;
            }
        }
        else if (!Mouse.isButtonDown(Input.MOUSE_LEFT_BUTTON)){
            singleClick=true;
        }
    }

    protected void drawText(Graphics g){

    }

    @Override
    public boolean isMouseOver() {
        return super.isMouseOver();
    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
        super.mouseClicked(button, x, y, clickCount);

    }

    public void setInvisible(){
        super.setX(-1000);
        super.setY(-1000);
    }

    public void setVisible(){
        super.setX(this.x);
        super.setY(this.y);
    }


    public void onClick() {
        clicked=true;
    }

    public void onFocus(){
        sound.play();
    }

    public boolean isClicked(){return clicked;}

    public void redraw(GUIContext container, Graphics g, ResourceBundle freshBundle){
        bundle=freshBundle;
        render(container,g);
    }

    private void setCharset_Russian(Graphics g) {
        if(!g.getFont().equals(fontRus)) {
            g.setFont(fontRus);
        }
    }

    private void createFont(){
        this.font = new Font("Game/res/Fonts/font.otf",Font.PLAIN,14);
        this.fontRus = new TrueTypeFont(font, true,("йцукенгшщзхъфывапролджэячсмитьбюё".toUpperCase()+"йцукенгшщзхъфывапролджэячсмитьбюё").toCharArray());
    }

}