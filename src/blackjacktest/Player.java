package blackjacktest;
import java.util.*;

public class Player {
    private String name;
    private int stack;
    ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        stack = 100;
        hand = new ArrayList<Card>();
    }   

    public String getName() {
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(Card freshCard) {
        hand.add(freshCard);
    }
}
