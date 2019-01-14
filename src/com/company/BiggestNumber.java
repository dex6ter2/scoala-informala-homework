package com.company;

import java.util.Scanner;

/**
 * from the 3 numbers provided by user returns the biggest number of the 3
 * @author Marius Cristea
 * @version 1
 */
public class BiggestNumber {
    String firstNumber;
    String secondNumber;
    String thirdNumber;

    /**
     * contructor of the class
     */

    public BiggestNumber(){
        System.out.println("Insert first number");
        firstNumber = createString();
        System.out.println("Insert second number");
        secondNumber = createString();
        System.out.println("Insert third number");
        thirdNumber = createString();
        returnBiggestNumber(firstNumber,secondNumber,thirdNumber);
    }

    public static void main (String[] args){

    }

    /**
     * prints the biggest number from the 3 strings provided and converts them to float
     * @param a first string that helds a float number
     * @param b second string that helds a float number
     * @param c third string that helds a float number
     */
    public static void returnBiggestNumber(String a, String b, String c){
        float firstNumber = Float.parseFloat(a);
        float secondNumber = Float.parseFloat(b);
        float thirdNumber = Float.parseFloat(c);
        float max = 0;
        if (firstNumber > secondNumber){
            max = firstNumber;
        }
        else {
            max = secondNumber;
        }
        if (max < thirdNumber){
            max = thirdNumber;
        }
        System.out.println("The biggest number from " + firstNumber + " " + secondNumber + " and " + thirdNumber + " is " + max);
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
     *return a string inserted by the user and checks if the string holds a float number
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
            }else {
                System.out.println("the number provided is not a valid float number, please try again!");
            }
        }
        return collection;
    }
}
