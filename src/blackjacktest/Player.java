package blackjacktest;
import java.util.*;

public class Player {
    private String name;
    int stack;
    int count;
    ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        stack = 100;
        count = 0;
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
