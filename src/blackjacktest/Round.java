package blackjacktest;
import java.util.*;

public class Round {    
    Random rand = new Random();
    private int numPlayers;
    Scanner in = new Scanner(System.in);
    
    public Round(int numPlayers){
        this.numPlayers = numPlayers;
    }
    
    public void action(Player[] table){
        initialDeal(table);
        print(table);
        hit(table);

    }     
    
    public void initialDeal(Player[] table){
        Card downCard = new Card (rand.nextInt(53), false);
        Card upCard = new Card (rand.nextInt(53), true);
        
        for(int i = 0; i < numPlayers; i++){
            table[i].setHand(downCard);
        }
        for(int j = 0; j < numPlayers; j++){
            table[j].setHand(upCard);
        }
    }
    
    public void hit(Player[] table){
        for(int i=0; i<table.length; i++){
                String action = "Start";
                System.out.println("Hit or stand?");
                action = in.next();
                while(!action.equalsIgnoreCase("stand")){
                    Card freshCard = new Card(rand.nextInt(53), true);
                    table[i].setHand(freshCard);
                    print(table);
                    System.out.println("Hit or stand?");
                    action = in.next();
            }
        }
    }

    public void print(Player[] table){
        for(int i = 0; i < numPlayers; i++){
            System.out.println(table[i].getName());
                for(int c = 0; c < table[i].hand.size(); c++){
                    System.out.println("["+table[i].hand.get(c).getMyGraphic()+"]");
                }
        }
    }
}
