package tema.BiggestNumber;

import java.util.Scanner;

/**
 * displays the biggest number out of 3 numbers provided by customer
 * @author Marius Cristea
 * @version 1
 */
public class BiggestNumberOutOfThree {
    /**
     * displays the biggest number out of 3 numbers provided by customer
     * @param args
     */
    public static void main(String[] args) {
        int firstNumber;
        int secondNumber;
        int thirdNumber;
        firstNumber = getNumber("first");
        secondNumber = getNumber("second");
        thirdNumber = getNumber("third");
        System.out.println("The biggest number is "+ getMax(getMax(firstNumber,secondNumber),thirdNumber));
    }

    /**
     * returns the biggest value of of 2 integers
     * @param firstNumber number to be evaluated
     * @param secondNumber number to be evaluated
     * @return the biggest number out of the 2 values inserted as parameters
     */
    public static int getMax (int firstNumber, int secondNumber){
        int max;
        if (firstNumber >= secondNumber){
            max = firstNumber;
        }else{
            max = secondNumber;
        }
        return max;
    }

    /**
     * returns an integer value inserted by the customer
     * @param a counter in order to request the correct number from customer
     * @return interger value inserted by customer
     */
    public static int getNumber(String a){
        int finalNumber;
        String number;
        int j = 0;
        Scanner keyboard = new Scanner(System.in);
        do {
            if (j == 0) {
                System.out.println("Please insert the " + a + " integer number: ");
            }else{
                System.out.println("Previous value inserted was not an integer!Please insert the " + a + " integer number: ");
            }
            number = keyboard.nextLine();
            j++;
        }while (checkIfIntNumber(number)==false);
            finalNumber = Integer.parseInt(number);
        return finalNumber;
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
