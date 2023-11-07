package com.praveen.slidingwindow;

import java.util.*;

class MinimumWindowSubstring {
    public static String minWindow(String str1, String str2) {
        Map<Character, Integer> reqFreqMap = new HashMap<>();
        Map<Character, Integer> windowFreqMap = new HashMap<>();
        int required = str2.length();
        int current = 0;
        int start = 0;
        int minWindowLength = Integer.MAX_VALUE;
        int minSeqStartIndex = -1;
        int minSeqEndIndex = -1;

        for(char ch : str2.toCharArray()) {
            reqFreqMap.put(ch, reqFreqMap.getOrDefault(ch, 0) + 1);
        }
        for(char ch: reqFreqMap.keySet()) { //Initialize window with all 0 occurences
            windowFreqMap.put(ch , 0);
        }
        for(int end = 0; end < str1.length(); end++) {
            char currChar = str1.charAt(end);
            if(reqFreqMap.get(currChar) != null) {
                windowFreqMap.put(currChar, windowFreqMap.get(currChar) + 1);
                //Check if this char is required or just an extra char
                if(windowFreqMap.get(currChar) <= reqFreqMap.get(currChar)) {//Required char
                    current++;
                }
            }

            while (current == required) {
                int windowLength = (end - start + 1);
                if(minWindowLength > windowLength) {
                    minWindowLength = windowLength;
                    minSeqStartIndex = start;
                    minSeqEndIndex = end;
                }
                char startChar = str1.charAt(start);
                if(windowFreqMap.get(startChar) != null) {
                    windowFreqMap.put(startChar, windowFreqMap.get(startChar) - 1);
                    if(windowFreqMap.get(startChar) < reqFreqMap.get(startChar)) { //This is required char
                        current--;
                    }
                }
                start++;
            }
        }
        return minWindowLength != Integer.MAX_VALUE ? str1.substring(minSeqStartIndex, minSeqEndIndex + 1) : "";
    }

    // Driver code
    public static void main(String[] args) {
        String[] s = {"PATTERN", "LIFE", "ABRACADABRA", "STRIKER", "DFFDFDFVD"};
        String[] t = {"TN", "I", "ABC", "RK", "VDD"};
        for (int i = 0; i < s.length; i++) {
            System.out.println((i + 1) + ".\ts: " + s[i] + "\n\tt: " + t[i] + "\n\tThe minimum substring containing " + t[i] + " is: " + minWindow(s[i], t[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}