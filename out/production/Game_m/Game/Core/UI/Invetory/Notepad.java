package Game.Core.UI.Invetory;

import org.newdawn.slick.*;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Notepad extends AbstractComponent implements MouseListener {
    private boolean isTurning; //флаг находится ли страница в переворачивании

    private List<ArrayList<Image>> turnOverThePage;//массив массивов для хранения анимаций переворачивания страниц вправо
    private List<ArrayList<Image>> turnOverThePageReverse;//массив массивов для хранения анимаций переворачивания страниц влево
    private Image currentPage;//первая страница блокнота

    private List<Animation> toPage;//анимации для листания вправо
    private List<Animation> toPageReverse;//анимации для листания влево
    private Animation currentTurn;//текущаю анимация

    private List<Task> tasks;

    private int current, desired;//индекс текущей страницы и целевой
    private int i, pageSize;
    private int x, y;


    public Notepad(GUIContext container, int x, int y) {
        super(container);
        this.x = x;
        this.y = y;

        try{
            turnOverThePage = new ArrayList<ArrayList<Image>>(pageSize);
            Image[][] imgArr = new Image[turnOverThePage.size()][];
            Image[][] imgArrReverse = new Image[turnOverThePage.size()][];

            turnOverThePage.get(0).add(new Image("Game/res/img/TAB/note 1.png").getScaledCopy(600, 650));
            turnOverThePage.get(0).add(new Image("Game/res/img/TAB/note 2.png").getScaledCopy(600, 650));
            turnOverThePage.get(0).add(new Image("Game/res/img/TAB/note 3.png").getScaledCopy(600, 650));
            turnOverThePage.get(0).add(new Image("Game/res/img/TAB/note 4.png").getScaledCopy(600, 650));
            turnOverThePage.get(0).add(new Image("Game/res/img/TAB/note 5.png").getScaledCopy(600, 650));
            turnOverThePage.get(0).add(new Image("Game/res/img/TAB/note 6.png").getScaledCopy(600, 650));
            imgArr[0] = turnOverThePage.get(0).toArray(new Image[turnOverThePage.get(0).size()]);
            Collections.reverse(turnOverThePage.get(0));
            imgArrReverse[0] = turnOverThePage.get(0).toArray(new Image[turnOverThePage.get(0).size()]);

            turnOverThePage.get(1).add(new Image("Game/res/img/TAB/note 7.png").getScaledCopy(600, 650));
            turnOverThePage.get(1).add(new Image("Game/res/img/TAB/note 8.png").getScaledCopy(600, 650));
            turnOverThePage.get(1).add(new Image("Game/res/img/TAB/note 9.png").getScaledCopy(600, 650));
            turnOverThePage.get(1).add(new Image("Game/res/img/TAB/note 10.png").getScaledCopy(600, 650));
            imgArr[1] = turnOverThePage.get(1).toArray(new Image[turnOverThePage.get(1).size()]);
            Collections.reverse(turnOverThePage.get(0));
            imgArrReverse[0] = turnOverThePage.get(0).toArray(new Image[turnOverThePage.get(0).size()]);

            turnOverThePage.get(2).add(new Image("Game/res/img/TAB/note 11.png").getScaledCopy(600, 650));
            turnOverThePage.get(2).add(new Image("Game/res/img/TAB/note 12.png").getScaledCopy(600, 650));
            turnOverThePage.get(2).add(new Image("Game/res/img/TAB/note 13.png").getScaledCopy(600, 650));
            turnOverThePage.get(2).add(new Image("Game/res/img/TAB/note 14.png").getScaledCopy(600, 650));
            imgArr[2] = turnOverThePage.get(2).toArray(new Image[turnOverThePage.get(2).size()]);
            Collections.reverse(turnOverThePage.get(0));
            imgArrReverse[0] = turnOverThePage.get(0).toArray(new Image[turnOverThePage.get(0).size()]);

            turnOverThePage.get(3).add(new Image("Game/res/img/TAB/note 15.png").getScaledCopy(600, 650));
            turnOverThePage.get(3).add(new Image("Game/res/img/TAB/note 16.png").getScaledCopy(600, 650));
            turnOverThePage.get(3).add(new Image("Game/res/img/TAB/note 17.png").getScaledCopy(600, 650));
            turnOverThePage.get(3).add(new Image("Game/res/img/TAB/note 18.png").getScaledCopy(600, 650));
            imgArr[3] = turnOverThePage.get(3).toArray(new Image[turnOverThePage.get(3).size()]);
            Collections.reverse(turnOverThePage.get(0));
            imgArrReverse[0] = turnOverThePage.get(0).toArray(new Image[turnOverThePage.get(0).size()]);

            currentPage = turnOverThePage.get(0).get(0);

            toPage = new ArrayList<>(pageSize);
            for (i = 0; i < pageSize; i++) {
                toPage.add(new Animation(imgArr[i], 100, true));
                toPage.get(i).setLooping(false);

                toPageReverse.add(new Animation(imgArrReverse[i], 100, true));
                toPageReverse.get(i).setLooping(false);
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
        //Если активен флаг на движение рисуем анимацию, иначе статичный спрайт
        if(isTurning){
            toPage.get(desired).draw(x+300,y+20);
        }else{
            currentPage.draw(x + 300, y + 20);
            for(Task task : tasks) {
                g.drawString(task.getName(), task.getX(), task.getY());
            }
        }
    }

    public void update(GameContainer gameContainer, int t) throws SlickException {
        // todo останавливаем анимацию перелистывания в нужный момент
        if(currentTurn.isStopped()){
            isTurning = false;
        }
    }

    public void turnTo(int desired){
        this.desired = desired;

        if(desired > current){
            isTurning = true;
            this.currentTurn = toPage.get(desired);
            this.currentPage = turnOverThePage.get(desired).get(0);//так как фреймы для листания реверсятся в конструкторе
        }

        if(desired < current){
            isTurning = true;
            this.currentTurn = toPageReverse.get(desired);
            this.currentPage = turnOverThePageReverse.get(desired).get(0);//так как фреймы для листания реверсятся в конструкторе
        }

        current = desired;
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