package cards;

public class Game {
    private Deck deck;
    private Hand hand;
    private int score;

    public Game(Deck deck) {
        this.deck = deck;
        this.hand = new Hand(5);
        this.score = 0;
        dealCards();
    }

    private void dealCards() {
        for (int i = 0; i < 2; i++) {
            hand.add(deck.draw());
        }
    }

    public void printRules() {
        System.out.println("Welcome to Blackjack!");
        System.out.println("Your hand is: " + hand);
        System.out.println("Your score is: " + calculateScore());
    }

    public void next() {
        System.out.println("Do you want to hit (h) or stand (s)?");
    }

    public boolean takeTurn(String command) {
        if (command.equals("h")) {
            hand.add(deck.draw());
            System.out.println("Your hand is: " + hand);
            System.out.println("Your score is: " + calculateScore());
            if (calculateScore() > 21) {
                System.out.println("You busted! Game over.");
                return false;
            }
        } else if (command.equals("s")) {
            System.out.println("You stood with a score of: " + calculateScore());
            return false;
        }
        return true;
    }

    private int calculateScore() {
        int score = 0;
        for (int i = 0; i < hand.length(); i++) {
            Card card = hand.get(i);
            if (card.toString().contains("A")) {
                score += 11;
            } else if (card.toString().contains("K") || card.toString().contains("Q") || card.toString().contains("J")) {
                score += 10;
            } else {
                try {
                    score += Integer.parseInt(card.toString().substring(1));
                } catch (NumberFormatException e) {
                    // Handle the exception
                }
            }
        }
        // Adjust score if there's an Ace and score is over 21
        for (int i = 0; i < hand.length(); i++) {
            Card card = hand.get(i);
            if (card.toString().contains("A") && score > 21) {
                score -= 10;
            }
        }
        return score;
    }
}