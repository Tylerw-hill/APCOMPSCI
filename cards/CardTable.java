package cards;

import java.util.Scanner;

public class CardTable {

    Deck deck;

    public CardTable() {
        deck = new Deck();
    }

    public void startPlaying() {
        deck.shuffle();
        deck.shuffle();
        Scanner keyboard = new Scanner(System.in);

        // Start initial game
        Game game = new Game(deck);
        game.printRules();
        game.next();

        String input;
        boolean play = true;

        while (play) {

            System.out.println("Enter a command: (h=hit, s=stand, r=reset, q=quit)");
            input = keyboard.nextLine();

            if (input.length() > 0) {
                String command = input.substring(0, 1);

                if (command.equals("q")) {
                    play = false;
                    continue;
                }

                if (command.equals("r")) {
                    game = new Game(deck);  // deals new hand
                    System.out.println("\n--- New Round Started ---");
                    game.printRules();      // show cards
                    game.next();            // start prompt ONLY
                    continue;
                }

                boolean result = game.takeTurn(command);

                if (!result) {
                    System.out.println("Round over. Press 'r' for a new round.");
                }
            }
        }
        keyboard.close();
    }
}
