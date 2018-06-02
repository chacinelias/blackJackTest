package blackjacktest;

import java.util.Scanner;

public class Game {

    Scanner in = new Scanner(System.in);
    private int numPlayers;
    private static int numRounds;
    private Player[] table;

    Game(int numPlayers) {
        this.numPlayers = numPlayers;
        numRounds = 0;
        table = new Player[numPlayers];
    }

    public void gameStart() {

        char keepPlaying = 'y';

        while (keepPlaying == 'y') {
            numRounds++;
            System.out.printf("\nRound %d...\n", numRounds);
            Round newRound = new Round(numPlayers);

            newRound.action(table);

            System.out.println("Would you like to play again? (y for yes, n for no): ");
            keepPlaying = in.next().charAt(0);
        }
    }

    public void setTable(Player[] table) {
        this.table = table;
    }

}
