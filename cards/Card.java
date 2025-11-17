package cards;

public class Card {
private int value;
private String suit;
private static String[] SUITS = {"♦","♣","♥","♠"};
private static String[] VALUES = {"A", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}; 
    public Card (int value, String suit){
        this.value = value;
        this.suit = suit;
    }
public int getValue(){
    return value;
}
public String toString(){
    return "" + SUITS[suit] + VALUES[value];
}

}
