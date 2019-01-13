package com.company;

import java.util.Scanner;

/**
 * displays all the prime numbers from 2 to a number provided by user
 * @author Marius Cristea
 * @version 1
 */
public class PrimeNumbers {
    String collection;

    public PrimeNumbers(){
        collection = createString();
        returnPrimeNumbers(collection);
    }

    public static void main(String[] args){

    }

    /**
     * displays all the prime numbers from 2 to a number from a string
     * @param a string with a value that may be converted to int
     */

    public static void returnPrimeNumbers(String a){
        int n = Integer.parseInt(a);
        int i =2;
        int j = 0;
        int b = 0;
        System.out.println("Prime numbers lower then " + n + " are: ");
        while (n > 2){
            n--;
            i = 2;
            j = 0;
//            System.out.println("n="+ n);
            while (i <= ((n - n % 2) / 2)){
                if (n % i == 0){
                    j++;
                }
                i++;
            }
            if (j == 0){
                System.out.println(n);
            }
        }
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
