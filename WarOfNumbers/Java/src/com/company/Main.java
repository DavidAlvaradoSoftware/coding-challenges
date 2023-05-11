package com.company;


/* The idea of the solution is the following:
*       - The sampleInput array is looped through only once.
*       - A modulus operation refers to the division of 2 numbers, but the remainder is returned.
*       - As each element of the array is passed, a modulus of 2 ("num % 2")
*         operation is conducted. If the number is even, then the modulus
*         value will be 0. If its odd, then a modulus value is 1.
*       - Depending on the modulus value, the current num is added to evenTotal or oddTotal.
*       - Based on prompt, a positive value must be returned. I used Math.abs() which will always return
*         a positive difference value.
* */
public class Main {

    public static void main(String[] args) {
	// Update customInput with desired array.
        Integer[] promptInputOne = new Integer[]{12, 90, 75};
        Integer[] promptInputTwo = new Integer[]{5, 9, 45, 6, 2, 7, 34, 8, 6, 90, 5, 243};
        Integer[] customInput = new Integer[]{56, 69, 343, 372, 474};

        System.out.println(warOfNumbers(promptInputOne));
        System.out.println(warOfNumbers(promptInputTwo));
        System.out.println(warOfNumbers(customInput));

    }
    private static int warOfNumbers(Integer[] integers){
        int evenTotal = 0;
        int oddTotal = 0;

        for(int num : integers){
            if(num % 2 == 0){
                evenTotal += num;
            }else {
                oddTotal += num;
            }
        }

        return Math.abs(evenTotal-oddTotal);
    }
}
