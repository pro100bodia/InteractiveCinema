package Game.Core.UI.Camera;

import Game.Core.Main;
import Game.Core.UI.GG.Blacke;
import org.newdawn.slick.Graphics;


public class Camera {
    private int x, y;
    private int mapWidth, mapHeight;

    private float playerX;

    private Blacke blacke;

    public Camera(int mapWidth, int mapHeight, Blacke blacke) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;

        this.blacke = blacke;
        this.playerX = blacke.getX();
    }

    public void translate(Graphics g) {
        if (blacke.getX() - Main.WIDTH / 2 < 0) {
            x = 0;
        } else if (blacke.getX() + Main.WIDTH / 2 > mapWidth) {
            x = -mapWidth + Main.WIDTH;
        } else {
            x -= blacke.getX() - playerX;
        }

        playerX = blacke.getX();

        g.translate(x, y);
    }

    public int getX() {
        return x;
    }
}
