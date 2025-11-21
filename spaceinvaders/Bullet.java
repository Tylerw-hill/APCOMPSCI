package spaceinvaders;

public class Bullet {
    private int x;
    private int y;
    private boolean active = true;

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public boolean isActive() { return active; }
    public void deactivate() { active = false; }

    public void moveUp() { y--; if (y < 0) active = false; }

    public void draw(Screen screen) {
        if (active) screen.set(x, y, '|');
    }
}
