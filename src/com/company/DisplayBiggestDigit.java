package com.company;

import java.util.Scanner;

/**
 * the class return the biggest digit from a number provided by customer
 * @author Marius Cristea
 * @version 1
 */

public class DisplayBiggestDigit {
    String collection;

    public DisplayBiggestDigit(){
        collection = createString();
        System.out.println("The Biggest number from " + collection + " is " + maximumNumber(collection));
    }

    public static void main(String[] args){
    }

    /**
     * returns the bigest number from a string
     * @param a string that has as value a number
     * @return the biggest number
     */
    public static int maximumNumber (String a) {
        String b = a;
        int i = 1;
        int len = b.length();
        int max = Character.getNumericValue(b.charAt(0));
        while (i < len) {
                if (Character.getNumericValue(b.charAt(i)) > max) {
                    max = Character.getNumericValue(b.charAt(i));
                }
                if (max == 9){
                    break;
                }
            i++;

        }
            return max;
    }

    /**
     *return a string inserted by the user and checks if the string holds a float number,
     * @return a string that has a value convertable to float
     */
    public static String createString(){
        String collection ="0";
        int i = -1;
        Scanner readNumber = new Scanner(System.in);
        while (i != 0) {
            System.out.println("Please insert the desired number!");
            collection = readNumber.nextLine();
            if (checkIfFloatNumber(collection)){
                i = 0;
            }
        }

        return collection;
    }

    /**
     * return true if the value of the string is a float number otherwise returns false
     * @param a string to be checked if its value may be converted to flat
     * @return true or false depending if the string may be converted to float
     */

     public static boolean checkIfFloatNumber(String a){
        try{
            Float.parseFloat(a);
            return true;
        }
        catch (NumberFormatException ex){
            return false;
        }
    }
}
