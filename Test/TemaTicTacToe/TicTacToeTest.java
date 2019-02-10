package TemaTicTacToe;

import org.junit.jupiter.api.Test;

import java.util.*;

class TicTacToeTest {
    static Set<String> testList = new HashSet<>();
    static List<String> gameList = new ArrayList<>();

    @Test
    /**
     * runs the game until all win conditions are met (winner X, O and draw)
     */
    void run() {
        gameList = new ArrayList<>();
        Board.generateGameBoard();

        int i = 0;
        do {
            String x =randomString();
            if (i % 2 == 0) {
                Board.addToList(x, TicTacToe.getNAMEX());
                Board.displayBoard();
                i++;
            } else {
                Board.addToList(x, TicTacToe.getNAMEO());
                Board.displayBoard();
                i++;
            }

        } while (TicTacToe.winCondition(Board.gameBoard).equals("continue"));
        System.out.println(TicTacToe.winCondition(Board.gameBoard));
        if (endTest(TicTacToe.winCondition(Board.gameBoard))){
            run();
        }
    }

    /**
     * stores the results in a set
     * @param a result of the game
     * @return false if all possible outcome of the game were met.
     */

    public static boolean endTest(String a){
        int i = 0;
        testList.add(a);
        for (String x : testList){
            if (x.equals("Winner Player X")){
                i = i + 1;
            }
            if (x.equals("Winner Player O")){
                i = i + 2;
            }
            if (x.equals("Draw")){
                i = i + 3;
            }
        }
        if (i == 6){
            return false;
        }
        return true;
    }

    /**
     * generates a randomString type a,b were a and b have integer values from 1 to 3
     * @return
     */

    public static String randomString(){
        int max = 3;
        int min = 1;
        Random rand = new Random();
        int i = 0;
        int var1 = min + rand.nextInt(max);
        int var2 = min + rand.nextInt(max);
        String x = var1 + "," + var2;
        for (String a : gameList){
            if (a.equals(x)){
                i = 1;
            }
        }
        if (i == 1){
            x =randomString();
        }
        gameList.add(x);
        return x;
    }

}