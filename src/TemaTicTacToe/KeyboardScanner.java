package TemaTicTacToe;

import java.util.Scanner;

class KeyboardScanner {

    private static boolean validate1To3Values(String a) {
        return a.equals("1") || a.equals("2") || a.equals("3");
    }

    static String convertString(String b) {
        System.out.println("Player '" + b + "', enter your move (row[1-3] column[1-3])");
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        string = string.replaceAll("\\s", "");
        String row = Character.toString(string.charAt(0));
        String col = Character.toString(string.charAt(1));
        if (validate1To3Values(row) && validate1To3Values(col)) {
            return row + "," + col;
        } else {
            System.out.println("Wrong values added please enter a value (row[1-3] column[1-3]) for example: 1 2");
        }
        return convertString(b);
    }

}
