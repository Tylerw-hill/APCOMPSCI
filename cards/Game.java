package cards;

public class Game {
    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;

    private boolean roundActive = true;

    public Game(Deck deck) {
        this.deck = deck;

        this.playerHand = new Hand(5);
        this.dealerHand = new Hand(5);

        dealInitialCards();
    }

    private void dealInitialCards() {
        // Player gets 2 cards
        playerHand.add(deck.draw());
        playerHand.add(deck.draw());

        // Dealer gets 2 cards
        dealerHand.add(deck.draw());
        dealerHand.add(deck.draw());
    }

    public void printRules() {
        System.out.println("Your hand: " + playerHand + "  (Score: " + calculateScore(playerHand) + ")");
        System.out.println("Dealer shows: [" + dealerHand.get(0) + ", ?]");
    }

    // Next = prompt, not new cards
    public void next() {
        roundActive = true;
        System.out.println("Hit (h) or Stand (s)?");
    }

    public boolean takeTurn(String command) {

        if (!roundActive) {
            System.out.println("Round over! Press 'r' to start a new round.");
            return false;
        }

        if (command.equals("h")) {
            playerHand.add(deck.draw());
            System.out.println("\nYour hand: " + playerHand + "  (Score: " + calculateScore(playerHand) + ")");

            int score = calculateScore(playerHand);

            if (score > 21) {
                System.out.println("You busted!");
                roundActive = false;
                dealerReveal();   // dealer auto wins
                return false;
            }

            if (score == 21) {
                System.out.println("You hit 21!");
                roundActive = false;
                dealerTurn();
                return false;
            }

            return true;
        }

        if (command.equals("s")) {
            System.out.println("\nYou stand with: " + calculateScore(playerHand));
            roundActive = false;
            dealerTurn();
            return false;
        }

        System.out.println("Invalid command.");
        return true;
    }

    // DEALER 


    private void dealerReveal() {
        System.out.println("Dealer's hand: " + dealerHand +
                           "  (Score: " + calculateScore(dealerHand) + ")");
    }

    private void dealerTurn() {
        System.out.println("\n--- Dealer's Turn ---");

        dealerReveal();

        // Dealer hits until score >= 17
        while (calculateScore(dealerHand) < 17) {
            System.out.println("Dealer hits...");
            dealerHand.add(deck.draw());
            dealerReveal();

            if (calculateScore(dealerHand) > 21) {
                System.out.println("Dealer busts! YOU WIN!");
                return;
            }
        }

        // results
        endRound();
    }

    private void endRound() {
        int player = calculateScore(playerHand);
        int dealer = calculateScore(dealerHand);

        System.out.println("\n--- Final Results ---");
        System.out.println("Your score: " + player);
        System.out.println("Dealer score: " + dealer);

        if (player > dealer) {
            System.out.println("YOU WIN!");
        } else if (dealer > player) {
            System.out.println("DEALER WINS.");
        } else {
            System.out.println("It's a TIE!");
        }
    }


    // score calc part of it

    private int calculateScore(Hand hand) {
        int score = 0;

        for (int i = 0; i < hand.length(); i++) {
            Card card = hand.get(i);
            String value = card.toString();

            if (value.contains("A")) score += 11;
            else if (value.contains("K") || value.contains("Q") || value.contains("J")) score += 10;
            else score += Integer.parseInt(value.substring(1));
        }

        // Adjust ace values
        for (int i = 0; i < hand.length(); i++) {
            if (hand.get(i).toString().contains("A") && score > 21) {
                score -= 10;
            }
        }

        return score;
    }
}
