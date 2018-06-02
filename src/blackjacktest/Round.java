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
        String action = "start";
        initialDeal(table);
        printRound(table);
        while(!action.equalsIgnoreCase("stand")){
            System.out.println("Hit or Stand?");
            action = in.next();
            if(action.equalsIgnoreCase("Hit")){
                System.out.println("hit");
            }
        }  
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
    
    public void printRound(Player[] table){
        for(int i = 0; i < numPlayers; i++){
            System.out.println(table[i].getName());
            System.out.print("["+table[i].hand.get(table[i].hand.size() - 2).getMyGraphic()+"]"+" ");
            System.out.println("["+table[i].hand.get(table[i].hand.size() - 1).getMyGraphic()+"]");
        }
    }
}
