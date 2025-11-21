package spaceinvaders;

public class Screen {
    private char[][] grid;
    private int width;
    private int height;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new char[height][width];
        clear();
    }

    public void clear() {
        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++)
                grid[y][x] = ' ';
    }

    public void set(int x, int y, char c) {
        if (x >= 0 && x < width && y >= 0 && y < height)
            grid[y][x] = c;
    }

    public void render() {
        System.out.print("\033[H\033[2J"); // Clear terminal
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(grid[y][x]);
            }
            System.out.println();
        }
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
}
