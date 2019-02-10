package TemaTicTacToe;

import java.util.*;

class Board {
    static Map<String, String> gameBoard = new HashMap<>();

    static void generateGameBoard() {
        String key;
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                key = i + "," + j;
                System.out.println(key);
                gameBoard.put(key, "   ");
            }

        }
    }


    static void displayBoard() {

        System.out.println(gameBoard.get("1,1") + "|" + gameBoard.get("1,2") + "|" + gameBoard.get("1,3"));
        System.out.println("-----------");
        System.out.println(gameBoard.get("2,1") + "|" + gameBoard.get("2,2") + "|" + gameBoard.get("2,3"));
        System.out.println("-----------");
        System.out.println(gameBoard.get("3,1") + "|" + gameBoard.get("3,2") + "|" + gameBoard.get("3,3"));
        System.out.println("-----------");
    }

    static void addToList(String key, String a) {
        System.out.println(gameBoard.get(key));
        if (gameBoard.get(key).equals("   ")) {
            gameBoard.put(key, a);
        } else {
            System.out.println("This move at (" + key + ") is not valid. Try again..");
            addToList(KeyboardScanner.convertString(a), a);
        }
    }
}
