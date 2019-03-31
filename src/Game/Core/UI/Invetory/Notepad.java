package Game.Core.UI.Invetory;

import org.newdawn.slick.*;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Notepad extends AbstractComponent implements MouseListener {
    private boolean isTurning; //флаг, обозначающий происходит ли переворачивание

    private Image currentFrame;//открытая страница блокнота

    private List<Animation> toPage;//анимации для листания вправо
    private List<Animation> toPageReverse;//анимации для листания влево
    private Animation currentTurn;//текущая анимация

    private Image[][] imgArr;//массив для хранения изображений анимации листания влево
    private Image[][] imgArrReverse;//массив для хранения изображений анимации листания вправо
    private List<Task> tasks;//задания

    private int current, desired;//индекс текущей страницы и целевой
    private int pageSize;//количество страниц
    private int x, y;


    Notepad(GUIContext container, int x, int y) {
        super(container);
        this.x = x;
        this.y = y;

        pageSize = 4;
        current = -1;

        try{
            List<ArrayList<Image>> turnOverThePage;//массив массивов для хранения анимаций переворачивания страниц вправо

            turnOverThePage = new ArrayList<ArrayList<Image>>(pageSize);


            turnOverThePage.add(new ArrayList<Image>());
            turnOverThePage.get(0).add(new Image("Game/res/img/TAB/note 1.png").getScaledCopy(600, 650));
            turnOverThePage.get(0).add(new Image("Game/res/img/TAB/note 2.png").getScaledCopy(600, 650));
            turnOverThePage.get(0).add(new Image("Game/res/img/TAB/note 3.png").getScaledCopy(600, 650));
            turnOverThePage.get(0).add(new Image("Game/res/img/TAB/note 4.png").getScaledCopy(600, 650));
            turnOverThePage.get(0).add(new Image("Game/res/img/TAB/note 5.png").getScaledCopy(600, 650));
            turnOverThePage.get(0).add(new Image("Game/res/img/TAB/note 6.png").getScaledCopy(600, 650));


            turnOverThePage.add(new ArrayList<Image>());
            turnOverThePage.get(1).add(new Image("Game/res/img/TAB/note 6.png").getScaledCopy(600, 650));
            turnOverThePage.get(1).add(new Image("Game/res/img/TAB/note 7.png").getScaledCopy(600, 650));
            turnOverThePage.get(1).add(new Image("Game/res/img/TAB/note 8.png").getScaledCopy(600, 650));
            turnOverThePage.get(1).add(new Image("Game/res/img/TAB/note 9.png").getScaledCopy(600, 650));
            turnOverThePage.get(1).add(new Image("Game/res/img/TAB/note 10.png").getScaledCopy(600, 650));

            turnOverThePage.add(new ArrayList<Image>());
            turnOverThePage.get(2).add(new Image("Game/res/img/TAB/note 10.png").getScaledCopy(600, 650));
            turnOverThePage.get(2).add(new Image("Game/res/img/TAB/note 11.png").getScaledCopy(600, 650));
            turnOverThePage.get(2).add(new Image("Game/res/img/TAB/note 12.png").getScaledCopy(600, 650));
            turnOverThePage.get(2).add(new Image("Game/res/img/TAB/note 13.png").getScaledCopy(600, 650));
            turnOverThePage.get(2).add(new Image("Game/res/img/TAB/note 14.png").getScaledCopy(600, 650));

            turnOverThePage.add(new ArrayList<Image>());
            turnOverThePage.get(3).add(new Image("Game/res/img/TAB/note 14.png").getScaledCopy(600, 650));
            turnOverThePage.get(3).add(new Image("Game/res/img/TAB/note 15.png").getScaledCopy(600, 650));
            turnOverThePage.get(3).add(new Image("Game/res/img/TAB/note 16.png").getScaledCopy(600, 650));
            turnOverThePage.get(3).add(new Image("Game/res/img/TAB/note 17.png").getScaledCopy(600, 650));
            turnOverThePage.get(3).add(new Image("Game/res/img/TAB/note 18.png").getScaledCopy(600, 650));

            currentFrame = turnOverThePage.get(0).get(0);

            int i;
            imgArr = new Image[turnOverThePage.size()][];
            imgArrReverse = new Image[turnOverThePage.size()][];
            for(i = 0; i < turnOverThePage.size(); i++)
            {
                imgArr[i] = turnOverThePage.get(i).toArray(new Image[turnOverThePage.get(i).size()]);
                Collections.reverse(turnOverThePage.get(i));
                imgArrReverse[i] = turnOverThePage.get(i).toArray(new Image[turnOverThePage.get(i).size()]);
            }
            turnOverThePage.clear();

            toPage = new ArrayList<>(pageSize);
            toPageReverse = new ArrayList<>(pageSize);
            for (i = 0; i < pageSize; i++) {
                toPage.add(new Animation(imgArr[i], 100, true));
                toPageReverse.add(new Animation(imgArrReverse[i], 100, true));
            }
        }catch(SlickException e) {
            e.printStackTrace();
        }

        tasks = new ArrayList<Task>();
        tasks.add(new Task ("Убить шерифа", false,490,140));
        tasks.add(new Task ("Оживить шерифа", true,490,180));

        isTurning = false;
    }

    public void render(GUIContext context, Graphics g) throws SlickException {

        if(currentTurn.getCurrentFrame().equals(currentFrame)){
            currentTurn.setCurrentFrame(0);
            isTurning = false;
        }

        //Если активен флаг на движение рисуем анимацию, иначе статичный спрайт
        if(isTurning){
            currentTurn.draw(x+300,y+20);
        }else{
            currentFrame.draw(x + 300, y + 20);
            g.setColor(Color.red);
            for(Task task : tasks) {
                System.out.println("TASK: name: " + task.getName() + " x: " + task.getX() + " y: " + task.getY());
                g.drawString(task.getName(), task.getX(), task.getY());
            }
        }
    }

    public void turnTo(int desired){
        System.out.println("turn to page #" + desired);
        this.desired = desired;
        int i;

        if(desired < pageSize) {
            if (desired > current) {
                isTurning = true;
                this.currentTurn = toPage.get(desired);
                this.currentFrame = imgArr[desired][imgArr[desired].length - 1];
            }

            if (desired < current) {
                isTurning = true;
                this.currentTurn = toPageReverse.get(desired + 1);
                this.currentFrame = imgArrReverse[desired + 1][imgArrReverse[desired + 1].length - 1];
            }

           current = desired;
        }
    }

    public int getCurrent() {
        return current;
    }

    public void mouseWheelMoved(int var1){}

    public void mouseClicked(int var1, int var2, int var3, int var4){}

    public void mousePressed(int var1, int var2, int var3){}

    public void mouseReleased(int var1, int var2, int var3){}

    public void mouseMoved(int var1, int var2, int var3, int var4){}

    public void mouseDragged(int var1, int var2, int var3, int var4){}

    public void setLocation(int var1, int var2){}

    public int getX(){return 0;}

    public int getY(){return 0;}

    public int getWidth(){return 0;}

    public int getHeight(){return  0;}

}