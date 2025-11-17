package cards;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {
    private List<Card> cards;
    private int topIndex;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"♦", "♥", "♠", "♣"};
        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (String suit : suits) {
            for (String value : values) {
                cards.add(new Card(suit, value));
            }
        }
        topIndex = 0;
    }

    public void shuffle() {
        if (topIndex == 0) {
            Collections.shuffle(cards);
        }
    }

    public void cut(int index) {
        if (topIndex == 0 && index >= 0 && index <= 52) {
            List<Card> temp = new ArrayList<>(cards.subList(0, index));
            cards.subList(0, index).clear();
            cards.addAll(temp);
        }
    }

    public Card draw() {
        if (topIndex < cards.size()) {
            return cards.get(topIndex++);
        }
        return null;
    }

    public void print(int numCards) {
        StringBuilder sb = new StringBuilder();
        for (int i = topIndex; i < Math.min(topIndex + numCards, cards.size()); i++) {
            sb.append(cards.get(i)).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}