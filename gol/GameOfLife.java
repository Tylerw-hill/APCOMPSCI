package gol;

public class GameOfLife implements Board {

    // Integers: 0 or 1 for alive or dead
    private int[][] board;

    public GameOfLife(int x, int y)
    {
        board = new int[y][x];   // Create the board correctly
    }

    // Set values on the board
    public void set(int x, int y, int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                board[x + i][y + j] = data[i][j];
            }
        }
    }

    // Run the simulation for a number of turns
    public void run(int turns) {
        for (int i = 0; i < turns; i++) {
            step();
        }
    }

    // Step the simulation forward one turn.
    public void step()
    {
        print();

        int[][] next = new int[board.length][board[0].length];

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {

                int neighbors = countNeighbors(x, y);
                int cell = board[x][y];

                if (cell == 1) {
                    // live cell rules
                    if (neighbors == 2 || neighbors == 3)
                        next[x][y] = 1;
                    else
                        next[x][y] = 0;
                } else {
                    // dead cell rule
                    if (neighbors == 3)
                        next[x][y] = 1;
                    else
                        next[x][y] = 0;
                }
            }
        }

        board = next;
    }


    public int countNeighbors(int x, int y) {
        int count = 0;

        // All 8 directions
        int[] dx = {-1,-1,-1, 0, 0, 1,1,1};
        int[] dy = {-1, 0, 1,-1, 1,-1,0,1};

        for (int i = 0; i < 8; i++) {
            count += get(x + dx[i], y + dy[i]);
        }

        return count;
    }

    // Get a value from the board with wrap-around
    public int get(int x, int y) {
        int rows = board.length;
        int cols = board[0].length;

        int wrappedX = (x + rows) % rows;
        int wrappedY = (y + cols) % cols;

        return board[wrappedX][wrappedY];
    }

    // Test helper to get the whole board state
    public int[][] get()
    {
        return board;
    }

    // Test helper to print the current state
    public void print(){
        // Print the header
        System.out.print("\n ");
        for (int y = 0; y < board[0].length; y++) {
            System.out.print(y%10 + " ");
        }

        for (int x = 0; x < board.length; x++) {
            System.out.print("\n" + x%10);
            for (int y=0; y<board[x].length; y++)
            {
                if (board[x][y] == 1)
                {
                    System.out.print("⬛");
                }
                else
                {
                    System.out.print("⬜");
                }
            }
        }
        System.out.println();
    }
}
