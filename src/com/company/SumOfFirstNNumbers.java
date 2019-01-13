package com.company;

/**
 * displays the sum of the numbers from 0 to a number provided by customer
 * @author Marius Cristea
 * @version 1
 */
public class SumOfFirstNNumbers {

    public SumOfFirstNNumbers(int upToNumber){
        System.out.println("Sum from 1 to " + upToNumber + " = " + calculateSum(upToNumber));
    }
    /**
     * returns the sum of all numbers from 0 to a given number
     * @param x given number
     * @return sum of all numbers from 0 to given number
     */
    public int calculateSum(int x) {
        int sum = x*(x + 1)/2;
        return sum;
    }


    public static void main( String[] args){
    }
}
