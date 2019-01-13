package com.company;
import java.util.Scanner;

/**
 * displays the area and perimeter of a rectangle with the lenght and width provided by user
 * @author Marius Cristea
 * @version 1
 */

public class RectangleAreaAndPerimeter {
    String rectangleLenght;
    String rectangleWidth;

    public RectangleAreaAndPerimeter(){
        System.out.println("Please insert the desired lenght of the rectangle:");
        rectangleLenght = createString();
        System.out.println("Please insert the desired width of the rectangle:");
        rectangleWidth = createString();
        calculateRectangleAreaAndPerimeter(rectangleLenght,rectangleWidth);
    }

    public static void main (String[] args){

    }

    /**
     * diplays the area and perimeter using 2 string values
     * @param lenght string with value that may be converted to float
     * @param width string with value that may be converted to float
     */
    public static void calculateRectangleAreaAndPerimeter(String lenght, String width){
        float len = Float.parseFloat(lenght);
        float wid = Float.parseFloat(width);
        System.out.println("Area is: " + (len * wid));
        System.out.println("Perimeter is: " + (2 * len + 2 * wid));
        if ((len < 0) || (wid < 0)){
            System.out.println("In real life the values of width and lenght may not be negative!");
        }
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
