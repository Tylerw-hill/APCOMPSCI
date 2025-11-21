package cards;

public class Hand {
    private Card[] cards;
    private int numCards;

    public Hand(int maxSize) {
        cards = new Card[maxSize];
        numCards = 0;
    }

    public void add(Card card) {
        if (numCards < cards.length) {
            cards[numCards++] = card;
        }
    }

    public int length() {
        return numCards;
    }

    public Card get(int index) {
        if (index >= 0 && index < numCards) {
            return cards[index];
        }
        return null;
    }

    public Card remove(int index) {
        if (index >= 0 && index < numCards) {
            Card removed = cards[index];
            for (int i = index; i < numCards - 1; i++) {
                cards[i] = cards[i + 1];
            }
            cards[numCards - 1] = null;
            numCards--;
            return removed;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numCards; i++) {
            sb.append(cards[i]);
            if (i < numCards - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
