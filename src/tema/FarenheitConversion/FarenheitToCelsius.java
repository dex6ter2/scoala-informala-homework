package tema.FarenheitConversion;

import java.util.Scanner;

/**
 * Diplays the body temperature in celsius and if you are ill will inform the customer
 */
public class FarenheitToCelsius {
    /**
     * gets from user the temperature in fahrenheit, convets it to celsius and diplays the value to customer,
     * if the temperature in celsius is greater then 37 it will also display that you are ill
     * @param args
     */
    public static void main(String[] args) {
        float farenheitTemp;
        farenheitTemp = getNumber();
        System.out.println("Your body temperature in Celsius degrees is " + convertToCelsius(farenheitTemp));
        if (convertToCelsius(farenheitTemp) > 37){
            System.out.println("You are ill!");
        }
    }

    /**
     * transforms the fahrenheit to celsius
     * @param fahrenheitTemp value to be converted
     * @return value is celsius
     */
    public static float convertToCelsius(float fahrenheitTemp){
        float celsius = (fahrenheitTemp - 32) * 5 / 9;
        return celsius;
    }
    /**
     * returns a float value inserted by the customer
     * @return float value inserted by customer
     */
    public static float getNumber(){
        float finalNumber;
        String number;
        int j = 0;
        Scanner keyboard = new Scanner(System.in);
        do {
            if (j == 0) {
                System.out.println("Please insert your body temperature in Farenheit: ");
            }else{
                System.out.println("Previous value inserted was not a number!Please insert your body temperature in Farenheit: ");
            }
            number = keyboard.nextLine();
            j++;
        }while (checkIfFloatNumber(number)==false);
        finalNumber = Integer.parseInt(number);
        return finalNumber;
    }

    /**
     * returns true if the string received holds an integer value, otherwise returns false
     * @param a the string to be evaluated
     * @return true or false
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
