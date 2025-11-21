package spaceinvaders;

public class Alien {
    private int x;
    private int y;

    public Alien(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public void moveDown() { y++; }
    public void moveLeft() { x--; }
    public void moveRight() { x++; }

    public void draw(Screen screen) {
        screen.set(x, y, '#');
    }
}
