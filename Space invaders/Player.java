package spaceinvaders;

public class Player {
    private int x;
    private int y;
    private Screen screen;

    public Player(Screen screen) {
        this.screen = screen;
        this.x = screen.getWidth() / 2;
        this.y = screen.getHeight() - 1;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public void moveLeft() {
        if (x > 0) x--;
    }

    public void moveRight() {
        if (x < screen.getWidth() - 1) x++;
    }

    public void draw() {
        screen.set(x, y, 'A');
    }
}
