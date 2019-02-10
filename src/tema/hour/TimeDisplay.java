package tema.hour;

import java.util.Scanner;

/**
 * the class  gets the imput for hour and minutes from user and returns the time based on his imput
 * @author Marius Cristea
 * @version 1
 */
public class TimeDisplay {
    /**
     * displays the time with the hour and minutes received from the user
     * validates the values making sure the hour is betweem 0 and 23 and the minutes between 0 and 59
     * the format is HH:MM
     * @param args
     */
    public static void main(String[] args) {
        int hour, minutes;
        hour = getNumber("hour");
        minutes = getNumber("minutes");
        System.out.println("The time is: "+ modifyFormat(Integer.toString(hour)) + ":" + modifyFormat(Integer.toString(minutes)));
    }

    /**
     * modifies the string is the lenght is 1 by adding in front a 0
     * @param a
     * @return a string with the first character 0 if the length of the string is 1 else returns the same string
     */
    private static String modifyFormat(String a){
        if(a.length() == 1){
            return 0+a;
        }
        return a;
    }

    /**
     * returns an integer value inserted by the customer based on the string value may return hour or minutes
     * @param a counter in order to request the correct number from customer
     * @return interger value for hour or minutes inserted by customer
     */
    private static int getNumber(String a){
        int finalNumber;
        String number;
        int j = 0;
        Scanner keyboard = new Scanner(System.in);
        if (a == "hour"){
            do {
                if (j == 0) {
                    System.out.println("Please insert the " + a);
                }else{
                    System.out.println("Previous value inserted was not valid!Please insert the " + a);
                }
                number = keyboard.nextLine();
                j++;
            }while (validateHour(number));
        }
        else {
            j=0;
            do {
                if (j == 0) {
                    System.out.println("Please insert the " + a);
                }else{
                    System.out.println("Previous value inserted was not valid!Please insert the " + a);
                }
                number = keyboard.nextLine();
                j++;
            }while (validateMinutes(number));
        }
        finalNumber = Integer.parseInt(number);
        return finalNumber;
    }
    /**
     * returns true if the value of the string is an int and it is between 0 - 23 for hours
     * @param b string with value of int
     * @return true if a valid hour value was received
     */

    public static boolean validateHour(String b){
        boolean check = false;
        if (checkIfIntNumber(b)==false){
            check = true;
            System.out.println("cant convert int");
            return check;
        }
        int hour = Integer.parseInt(b);
        if (hour < 0 || hour >23){
            System.out.println("wrong  023");
            check = true;
        }
        System.out.println("surprize");
        return check;
    }

    /**
     * returns true if the value of the string is an int and it is between 0 - 59 for minutes
     * @param b string with value of int
     * @return true if a valid minutes value was received
     */

    public static boolean validateMinutes(String b){
        boolean check = false;
        if (checkIfIntNumber(b)==false){
            check = true;
            return check;
        }
        int minutes = Integer.parseInt(b);
        if (minutes < 0 || minutes >=60){
            check = true;
        }
        return check;
    }

    /**
     * returns true if the string received holds an integer value, otherwise returns false
     * @param a the string to be evaluated
     * @return true or false
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
