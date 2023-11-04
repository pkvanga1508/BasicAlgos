package com.praveen.slidingwindow;

import java.util.*;
import java.util.stream.*;

class SlidingWindowMaximum {
    // function to clean up the window
   public static int[] findMaxSlidingWindow(int[] nums, int k) {
       if(nums == null || nums.length < k) {
           int[] EMPTY = {};
           return EMPTY;
       }
       Deque<Integer> cw = new ArrayDeque<>();
       int[] result = new int[nums.length - k + 1];
       //Process first k Numbers
       for(int i = 0; i < k; i++) {
           cleanUP(i, cw, nums);
           cw.addLast(i);
       }
       result[0] = nums[cw.getFirst()];
       for(int i = k; i < nums.length; i++) {
           cleanUP(i, cw, nums);
           cw.addLast(i);
           if(cw.getFirst() <= (i - k)) { //The maximum is outside the operating window
               cw.removeFirst();
           }
           result[i - k + 1] = nums[cw.getFirst()];
       }

       return result;
   }

    private static void cleanUP(int index, Deque<Integer> cw, int[] nums) {
       //All values in cw > nums[index]
       //Since values in CW in decending order of indexes do from Last
       while (!cw.isEmpty() && nums[cw.getLast()] < nums[index]) {
           cw.removeLast();
       }
    }

    // driver code
    public static void main(String args[]) {
        int windowSizes [] = {3, 3, 3, 3, 2, 4, 3, 2, 3, 18};
        int [][] numLists = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
                {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                {1, 5, 8, 10, 10, 10, 12, 14, 15, 19, 19, 19, 17, 14, 13, 12, 12, 12, 14, 18, 22, 26, 26, 26, 28, 29, 30},
                {10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67},
                {4, 5, 6, 1, 2, 3},
                {9, 5, 3, 1, 6, 3},
                {2, 4, 6, 8, 10, 12, 14, 16},
                {-1, -1, -2, -4, -6, -7},
                {4, 4, 4, 4, 4, 4}
        };

        for (int i = 0; i < numLists.length; i++) {
            System.out.println(i + 1 + ".\tInput array:\t" + Arrays.toString(numLists[i]));
            System.out.println("\tWindow size:\t" + windowSizes[i]);
            System.out.println("\n\tMaximum in each sliding window:\t" + Arrays.toString(findMaxSlidingWindow(numLists[i], windowSizes[i])));
            Stream.generate(() -> "-").limit(100).forEach(System.out::print);
            System.out.println();
        }
    }
}