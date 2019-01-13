package com.company;

import java.util.Scanner;

/**
 * displays the number between A in B starting from A
 * @author Marius Cristea
 * @version 1
 */

public class NumbersFromNumberAToNumberB {

    String firstNumber;
    String secondNumber;

    public NumbersFromNumberAToNumberB(){
        System.out.println("Please insert the first number");
        firstNumber = createString();
        System.out.println("Please insert the second number");
        secondNumber = createString();
        getNumberInBetween(firstNumber,secondNumber);
    }

    public static void main (String[] args){

    }

    /**
     * prints all the number between 2 strings starting at the first string
     * @param a first string that has a value that may be converted to float
     * @param b second string that has a value that may be converted to float
     */

    public static void getNumberInBetween(String a, String b){
        float firstNumber = Float.parseFloat(a);
        float secondNumber = Float.parseFloat(b);
        if (firstNumber > secondNumber) {
            while (firstNumber >= secondNumber) {
                System.out.println(firstNumber);
                firstNumber--;
            }
        }
         else{
             while (firstNumber <= secondNumber){
                 System.out.println(firstNumber);
                 firstNumber++;
             }
         }

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
    /**
     *return a string inserted by the user and checks if the string holds a float number,
     * @return a string that has a value convertable to float
     */

    public static String createString() {
        String collection = "0";
        int i = -1;
        Scanner readNumber = new Scanner(System.in);
        while (i != 0) {
            collection = readNumber.nextLine();
            if (checkIfFloatNumber(collection)) {
                i = 0;
            }
        }
        return collection;
    }
}
