package com.praveen.twopointers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//input: "Hello   Friend"
//output: "Friend Hello"
public class ReverseWordsInStringIgnoreAllWhiteSpaces {

    public static String reverseWords(String sentence) {

        int slowPointer = 0;
        int fastPointer = 0;
        List<String> wordsReversed = new ArrayList<>();

        sentence = reverse(sentence); //Reverse whole string
        while (slowPointer < sentence.length())  { //Loop until slow pointer reaches the end of string
            while (fastPointer < sentence.length() && sentence.charAt(fastPointer) != ' ') {
                fastPointer++;
            }
            wordsReversed.add(reverse(sentence.substring(slowPointer, fastPointer)));
            //Move all the spaces!!
            while (fastPointer < sentence.length() && sentence.charAt(fastPointer) == ' ') {
                fastPointer++;
            }
            slowPointer = fastPointer;
        }
        return wordsReversed.stream().collect(Collectors.joining(" "));
    }

    private static String reverse(String sentence) {

        int startIndex = 0;
        int endIndex = sentence.length() - 1;
        char[] arr = sentence.toCharArray();
        while (startIndex <= endIndex) {
            char temp = sentence.charAt(startIndex);
            arr[startIndex] = sentence.charAt(endIndex);
            arr[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
        return new String(arr);
    }

    public static void main(String[] args) {

        System.out.println(ReverseWordsInStringIgnoreAllWhiteSpaces.reverseWords("Hello Friend"));

    }
}
