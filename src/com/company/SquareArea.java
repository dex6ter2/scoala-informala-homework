package com.company;

import java.util.Scanner;

/**
 * displayes the area of a square with the lenght provided by customer
 * @author Marius Cristea
 * @version 1
 */
public class SquareArea {
    String squareLen;

    public SquareArea(){
        squareLen = createString();
        calculateSquareArea(squareLen);
    }

    public static void main (String[] args){

    }

    /**
     * displays the area of a square
     * @param a lenght of the square
     */
    public static void calculateSquareArea(String a){
        float len = Float.parseFloat(a);
        if (len < 0){
          System.out.println("In real life the square length may not be negative value!");
        }
        System.out.println("Square area with length " + len + " is = " + (len * len));
    }
    /**
     *return a string inserted by the user and checks if the string holds an float number
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
