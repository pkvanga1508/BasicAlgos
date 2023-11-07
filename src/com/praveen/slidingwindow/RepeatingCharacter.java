package com.praveen.slidingwindow;

import java.util.*;

public class RepeatingCharacter {
    public static int longestRepeatingCharacterReplacement(String str, int k) {

        int start = 0;
        int end = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxOccurenceFreq = 0;
        int seqLength = 0;

        while(end < str.length()) {
            char currentChar = str.charAt(end);
            freqMap.put(currentChar, freqMap.getOrDefault(currentChar, 0) + 1);
            maxOccurenceFreq = Math.max(maxOccurenceFreq, freqMap.get(currentChar));

            if(((end - start + 1) - maxOccurenceFreq) > k) {
                freqMap.put(str.charAt(start), freqMap.get(str.charAt(start)) - 1);
                start++;
            }
            seqLength = Math.max(seqLength, (end - start + 1));
            end++;
        }
        return seqLength;
    }

    // Driver code
    public static void main(String[] args) {
        List<String> inputStrings = Arrays.asList("aabccbb", "abbcb", "abccde", "abbcab", "bbbbbbbbb");
        List<Integer> k = Arrays.asList(2, 1, 1, 2, 4);

        for (int i = 0; i < inputStrings.size(); ++i) {
            System.out.println((i + 1) + ".\tInput String: '" + inputStrings.get(i) + "'");
            System.out.println("\tk: " + k.get(i));
            System.out.println("\tLength of the longest substring with repeating characters: "
                    + longestRepeatingCharacterReplacement(inputStrings.get(i), k.get(i)));
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }
}