package com.company;

import java.util.*;

/**
 * displays the smallest number from a number given by customer
 * @author Marius Cristea
 * @version 1
 */
public class SmallestNumberFromCollection {
    int [] collection;

    /**
     * displays  the smollest number
     * @param collection predefined collection
     */

    public SmallestNumberFromCollection(int[] collection){
        System.out.println("Cel mai mic numar din colectie 1, 2, -3 este: " + sortare(collection));
    }

    public static void main(String[] args){
    }

    /**
     * sorts a collection of int and returns the smallest number from the collection
     * @param a collection that has at least a number
     * @return smallest number from the collection provided
     */

    public static int sortare(int [] a){
        int [] collection = a;
        Arrays.sort(collection);
        int b = collection[0];
        return b;
    }
}

