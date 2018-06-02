package blackjacktest;
import java.util.*;

public class BlackJackTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String playerName;
        
        System.out.println("\u2665\u2660-BLACKJACK-\u2666\u2663");
        System.out.println("Please enter number of players: ");
        int numPlayers = in.nextInt();
        
        Player[] table = new Player[numPlayers];
        Game newGame = new Game(numPlayers);     
        
        for(int i = 0; i < numPlayers; i++){
            System.out.println("Please enter player "+ (i+1) +"'s name:");
            playerName = in.next();
            System.out.println("Welcome "+playerName+"\n");
            Player newPlayer = new Player(playerName);
            table[i] = newPlayer;          
        }
        newGame.setTable(table);
        newGame.gameStart();
        }
}   
