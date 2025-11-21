package cards;

public class Game {
    private Deck deck;
    private Hand hand;
    private int score;

    private boolean roundActive = true;

    public Game(Deck deck) {
        this.deck = deck;
        this.hand = new Hand(5);
        this.score = 0;
        dealInitialCards();
    }

    private void dealInitialCards() {
        for (int i = 0; i < 2; i++) {
            hand.add(deck.draw());
        }
    }

    public void printRules() {
        System.out.println("Your hand is: " + hand);
        System.out.println("Your score is: " + calculateScore());
    }

    // Now ONLY displays the prompt — does not deal cards
    public void next() {
        roundActive = true;
        System.out.println("Hit (h) or stand (s)?");
    }

    public boolean takeTurn(String command) {

        // Prevent actions after stand/bust
        if (!roundActive) {
            System.out.println("Round over! Press 'r' to start a new round.");
            return false;
        }

        if (command.equals("h")) {
            hand.add(deck.draw());
            System.out.println("Your hand is: " + hand);
            System.out.println("Your score is: " + calculateScore());

            if (calculateScore() > 21) {
                System.out.println("You busted! Game over.");
                roundActive = false;
                return false;
            }

            if (calculateScore() == 21) {
                System.out.println("You hit 21! You win!");
                roundActive = false;
                return false;
            }

            return true;
        }

        if (command.equals("s")) {
            System.out.println("You stand with: " + calculateScore());
            roundActive = false;
            return false;
        }

        System.out.println("Invalid command.");
        return true;
    }

    private int calculateScore() {
        int score = 0;

        for (int i = 0; i < hand.length(); i++) {
            Card card = hand.get(i);
            String value = card.toString();

            if (value.contains("A")) {
                score += 11;
            } else if (value.contains("K") || value.contains("Q") || value.contains("J")) {
                score += 10;
            } else {
                score += Integer.parseInt(value.substring(1));
            }
        }

        // Ace adjustment
        for (int i = 0; i < hand.length(); i++) {
            if (hand.get(i).toString().contains("A") && score > 21) {
                score -= 10;
            }
        }

        return score;
    }
}
