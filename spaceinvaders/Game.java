package spaceinvaders;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Screen screen;
    private Player player;
    private List<Alien> aliens = new ArrayList<>();
    private List<Bullet> bullets = new ArrayList<>();

    private int alienDir = 1; // 1=right, -1=left
    private int tick = 0;
    private boolean running = true;

    public Game() {
        screen = new Screen(20, 15);
        player = new Player(screen);

        // Spawn aliens
        for (int y = 0; y < 3; y++)
            for (int x = 3; x < screen.getWidth() - 3; x += 2)
                aliens.add(new Alien(x, y));
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (running) {
            tick++;

            handleInput(scanner);
            updateGame();
            render();

            try { Thread.sleep(200); } catch (InterruptedException e) {}
        }

        System.out.println("Game Over!");
    }

    private void handleInput(Scanner scanner) {
        try {
            if (System.in.available() > 0) {
                String input = scanner.nextLine();
                for (char c : input.toCharArray()) {
                    if (c == 'a') player.moveLeft();
                    if (c == 'd') player.moveRight();
                    if (c == 'w') bullets.add(new Bullet(player.getX(), player.getY() - 1));
                }
            }
        } catch (Exception e) {}
    }

    private void updateGame() {
        // Move bullets
        for (Bullet b : bullets) b.moveUp();
        bullets.removeIf(b -> !b.isActive());

        // Move aliens every 5 ticks
        if (tick % 5 == 0) {
            boolean edge = false;
            for (Alien a : aliens) {
                if ((alienDir == 1 && a.getX() >= screen.getWidth() - 1) ||
                    (alienDir == -1 && a.getX() <= 0)) edge = true;
            }

            if (edge) {
                for (Alien a : aliens) a.moveDown();
                alienDir *= -1;
            } else {
                for (Alien a : aliens) {
                    if (alienDir == 1) a.moveRight(); else a.moveLeft();
                }
            }
        }

        // Check collisions
        for (Bullet b : bullets) {
            for (Alien a : aliens) {
                if (b.getX() == a.getX() && b.getY() == a.getY()) {
                    b.deactivate();
                    aliens.remove(a);
                    break;
                }
            }
        }

        // Check game over
        for (Alien a : aliens) {
            if (a.getY() >= player.getY()) running = false;
        }

        if (aliens.isEmpty()) {
            running = false;
            System.out.println("You win!");
        }
    }

    private void render() {
        screen.clear();
        player.draw();
        for (Alien a : aliens) a.draw(screen);
        for (Bullet b : bullets) b.draw(screen);
        screen.render();
        System.out.println("Controls: a=left, d=right, w=shoot");
    }

    public static void main(String[] args) {
        new Game().run();
    }
}
