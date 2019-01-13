package com.company;
import java.util.Scanner;

/**
 * diplays a menu for the classes and runs them.
 * @see BiggestNumber
 * @see DisplayBiggestDigit
 * @see NumbersFromNumberAToNumberB
 * @see PolidromeNumbers
 * @see PrimeNumbers
 * @see RectangleAreaAndPerimeter
 * @see SmallestNumberFromCollection
 * @see SquareArea
 * @see SumOfFirstNNumbers
 * @author Marius Cristea
 * @version 1
 */
public class Main {

    public static void main(String []args){
        System.out.println("Selections available:");
        availableSelection();
        runningSelection();

    }
    /**
     * displays the menu with details about what the selected class will do
     */
    public static void availableSelection(){
        System.out.println("1. Calculate the sum of the first 100 numbers higher than 0. ");
        System.out.println("2. Display the smallest number from a collection of numbers.");
        System.out.println("3. Display the max digit from a number. Read the number from keyboard.");
        System.out.println("4. Check if a number is a palindrome (e.g. 1221, 34143).");
        System.out.println("5. Display all the prime numbers lower than a given number.");
        System.out.println("6. Input the dimensions of a rectangle and display area and perimeter.");
        System.out.println("7. Input the length of the side of a square, and display its area.  Produce an error message if the length is negative.");
        System.out.println("8. Input 3 numbers, and display the biggest.");
        System.out.println("9. Input 2 values: start and finish, then display the numbers from start to finish.");
        System.out.println("0. Exit ");
    }

    /**
     * runs the class based on the selection made
     */
    public static void runningSelection(){
        String i = "-1";
        Scanner getNumber = new Scanner(System.in);
        while( i != "0") {
            System.out.println("Please make a selection by typing the number assigned to the selection: ");
            String selection = getNumber.nextLine();

            switch (selection) {
                case "0":
                    i = "0";
                    break;
                case "1":
                    System.out.println("1. Calculate the sum of the first 100 numbers higher than 0.");
                    SumOfFirstNNumbers myNumber = new SumOfFirstNNumbers(100);
                    break;
                case "2":
                    System.out.println("2. Display the smallest number from a collection of numbers.");
                    int[] b = {1, 2, -3};
                    SmallestNumberFromCollection myCollection = new SmallestNumberFromCollection(b);
                    break;
                case "3":
                    System.out.println("3. Display the max digit from a number. Read the number from keyboard.");
                    DisplayBiggestDigit bigNumber = new DisplayBiggestDigit();
                    break;
                case "4":
                    System.out.println("4. Check if a number is a palindrome (e.g. 1221, 34143).");
                    PolidromeNumbers polindrome = new PolidromeNumbers();
                    break;
                case "5":
                    System.out.println("5. Display all the prime numbers lower than a given number.");
                    PrimeNumbers primeValue = new PrimeNumbers();
                    break;
                case "6":
                    System.out.println("6. Input the dimensions of a rectangle and display area and perimeter.");
                    RectangleAreaAndPerimeter rectangle = new RectangleAreaAndPerimeter();
                    break;
                case "7":
                    System.out.println("7. Input the length of the side of a square, and display its area.  Produce an error message if the length is negative.");
                    SquareArea sqrArea = new SquareArea();
                    break;
                case "8":
                    System.out.println("8. Input 3 numbers, and display the biggest.");
                    BiggestNumber bigestNum = new BiggestNumber();
                    break;
                case "9":
                    System.out.println("9. Input 2 values: start and finish, then display the numbers from start to finish.");
                    NumbersFromNumberAToNumberB displayNumbers = new NumbersFromNumberAToNumberB();
                    break;
                default:
                    System.out.println("Selection not valid");
            }
        }
    }
}
