package cards;
import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;
    private int maxSize;

    public Hand(int maxSize) {
        this.maxSize = maxSize;
        cards = new ArrayList<>();
    }

    public boolean add(Card card) {
        if (cards.size() >= maxSize) {
            return false;
        }
        cards.add(card);
        return true;
    }

    public int length() {
        return cards.size();
    }

    public Card get(int index) {
        if (index >= 0 && index < cards.size()) {
            return cards.get(index);
        }
        return null;
    }

    public Card remove(int index) {
        if (index >= 0 && index < cards.size()) {
            return cards.remove(index);
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card).append(" ");
        }
        return sb.toString().trim();
    }
}