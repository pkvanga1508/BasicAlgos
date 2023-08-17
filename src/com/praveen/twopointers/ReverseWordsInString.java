package com.praveen.twopointers;

//input: "Hello Friend"
//output: "Friend Hello"
public class ReverseWordsInString {

    public static String reverseWords(String sentence) {

        int slowPointer =0;
        int fastPointer = 0;
        char[] sentanceArr = sentence.toCharArray();
        reverse(sentanceArr, slowPointer, sentanceArr.length - 1); //Reverse whole string
        while (slowPointer < sentence.length())  { //Loop until slow pointer reaches the end of string
            while (fastPointer < sentence.length() && sentanceArr[fastPointer] != ' ') {
                fastPointer++;
            }
            reverse(sentanceArr, slowPointer, fastPointer - 1);

            //Move all the spaces!!
            while (fastPointer < sentence.length() && sentanceArr[fastPointer] == ' ') {
                fastPointer++;
            }
            slowPointer = fastPointer;
        }
        return new String(sentanceArr);
    }

    private static void reverse(char[] sentanceArr, int startIndex, int endIndex) {

        while (startIndex <= endIndex) {
            char temp = sentanceArr[startIndex];
            sentanceArr[startIndex] = sentanceArr[endIndex];
            sentanceArr[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }

    public static void main(String[] args) {

        System.out.println(ReverseWordsInString.reverseWords("Hello Friend"));

    }
}
