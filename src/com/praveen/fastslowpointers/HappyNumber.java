package com.praveen.fastslowpointers;

//Sum of squares of numbers converge to 1

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static boolean isHappyNumber(int n) {

        Set<Integer> set = new HashSet<>();
        set.add(n);
        while(true) {
            n = getNumberSquares(n);
            if(n == 1) {
                return true;
            }
            if(!set.add(n)) {
                return false;
            } //Adding returns false if the value is present in the set.
        }
    }

    private static int getNumberSquares(int number) {
        if(number <= 1) return number;
        int sum = 0;
        while(number > 0) {
            int rem = number % 10;
            sum += rem * rem;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {

        System.out.println("Is Happy Number 2147483646: " + isHappyNumber(2147483646));
        System.out.println("Is Happy Number 1: " + isHappyNumber(1));
        System.out.println("Is Happy Number 19: " + isHappyNumber(19));
        System.out.println("Is Happy Number 8: " + isHappyNumber(8));
        System.out.println("Is Happy Number 7: " + isHappyNumber(7));
    }
}
