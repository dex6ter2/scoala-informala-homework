package tema.hour;

import java.util.Scanner;

public class TimeDisplay {
    public static void main(String[] args) {
        int hour, minutes;
        hour = getNumber("hour");
        minutes = getNumber("minutes");
        System.out.println("The time is: "+ modifyFormat(Integer.toString(hour)) + ":" + modifyFormat(Integer.toString(minutes)));
    }

    private static String modifyFormat(String a){
        if(a.length() == 1){
            return 0+a;
        }
        return a;
    }

    /**
     * returns an integer value inserted by the customer
     * @param a counter in order to request the correct number from customer
     * @return interger value inserted by customer
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

    private static boolean validateHour(String b){
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

    private static boolean validateMinutes(String b){
        boolean check = false;
        if (checkIfIntNumber(b)==false){
            check = true;
            return check;
        }
        int minutes = Integer.parseInt(b);
        if (minutes < 0 || minutes >60){
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
