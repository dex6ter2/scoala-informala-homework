package com.company;

import java.util.Scanner;

/**
 * checks if the int number provided by user is a polindrome
 * @author Marius Cristea
 * @version 1
 */

public class PolidromeNumbers {
    String collection;

    public PolidromeNumbers(){
        collection = createString();
        System.out.println(checkPolindrome(collection));
    }

    public static void main(String[] args){

    }

    /**
     * checks if the string has a value that represents and polindrome and return as a string
     * @param a string that holds and int value
     * @return a string with the answers for the question "is this string as polindrome?"
     */

    public static String checkPolindrome(String a){
        String b = a;
        int len = b.length();
        int mid = (len - len % 2) / 2;
        int i = 0;
        int j = 0;
        int k;
        String c;
        while ((i < mid) && (j != 1)){
            if (b.charAt(i) != b.charAt(len - i - 1)){
                j++;
            }
            i++;
        }
        if (j > 0){
            c = "Number " + b + " is not a polindrome";
        }
        else {
            c = "Number " + b + " is a polindrome";
        }
        return c;
    }
    /**
     *return a string inserted by the user and checks if the string holds an int number
     * @return a string that has a value convertable to int
     */

    public static String createString() {
        String collection = "0";
        int i = -1;
        Scanner readNumber = new Scanner(System.in);
        while (i != 0) {
            System.out.println("Please insert the desired number!");
            collection = readNumber.nextLine();
            if (checkIfIntNumber(collection)) {
                i = 0;
            }
        }

        return collection;
    }
    /**
     * return true if the value of the string is a int number otherwise returns false
     * @param a string to be checked if its value may be converted to int
     * @return true or false depending if the string may be converted to int
     */

    public static boolean checkIfIntNumber(String a){
        try{
            Integer.parseInt(a);
            return true;
        }
        catch (NumberFormatException ex){
            return false;
        }
    }
}
