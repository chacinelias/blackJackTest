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
        hit(table);
    }     
    
    public void initialDeal(Player[] table){
        Card downCard = new Card (rand.nextInt(53), false);
        Card upCard = new Card (rand.nextInt(53), true);
        
        for(int i = 0; i < numPlayers; i++){
            table[i].setHand(downCard);
            table[i].count = downCard.rank;
        }
        for(int j = 0; j < numPlayers; j++){
            table[j].setHand(upCard);
            table[j].count = table[j].count + upCard.rank;
        }
        print(table);
    }
    
    public void hit(Player[] table){
        for(int i=0; i<table.length; i++){
            boolean flagBust = false;
            String action;
            System.out.println("Count: "+ table[i].count +". Hit or stand?");
            action = in.next();
            while(!action.equalsIgnoreCase("stand") && !flagBust){
                Card freshCard = new Card(rand.nextInt(53), true);
                if(table[i].count + freshCard.rank > 21){
                    System.out.println("You have busted!");
                    flagBust = true;
                }else{
                    table[i].count = table[i].count + freshCard.rank;
                    table[i].setHand(freshCard);
                    print(table);
                    System.out.println("Count is "+table[i].count+". Hit or stand?");
                    action = in.next();
                }
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
