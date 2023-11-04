package com.praveen.slidingwindow;

import java.util.*;

public class RepeatedDNASequence {

    public static Set<String> findRepeatedSequences(String s, int k) {

        Map<Character, Integer> charMap;
        int charVariations = 4;
        charMap = new HashMap<>();
        charMap.put('A', 1);
        charMap.put('C', 2);
        charMap.put('G', 3);
        charMap.put('T', 4);
        Set<Long> hashBuff = new HashSet<>();
        Set<String> repeatedSequence = new HashSet<>();
        if(s == null || s.length() < k) return repeatedSequence;
        long hash = 0;
        for(int i = 0; i <= s.length() - k -1; i++) {
            if(i == 0) { //We are at First element need to calculate initial hash
                for(int j = 0; j < k; j++) {
                    hash += charMap.get(s.charAt(j)) * (long)Math.pow(charVariations, k - 1 -j);
                }
            } else {
                long previousHash = hash;
                hash = ((previousHash - (charMap.get(s.charAt(i - 1)) * (long)Math.pow(charVariations, k - 1))) * charVariations) + charMap.get(s.charAt(i + k - 1));
//                System.out.println("Previous Hash Value: " + previousHash + " New Hash Value : " + hash);
            }
            if(!hashBuff.add(hash)) {
                String str = s.substring(i, i + k);
                repeatedSequence.add(str);
            }

        }
        return repeatedSequence;
    }

    public static void main(String[] args) {
        List<String> inputsString = Arrays.asList("ACGT", "AGACCTAGAC", "AAAAACCCCCAAAAACCCCCC",
                "GGGGGGGGGGGGGGGGGGGGGGGGG", "TTTTTCCCCCCCTTTTTTCCCCCCCTTTTTTT", "TTTTTGGGTTTTCCA",
                "AAAAAACCCCCCCAAAAAAAACCCCCCCTG", "ATATATATATATATAT");
        List<Integer> inputsK = Arrays.asList(3, 3, 8, 12, 10, 14, 10, 6);

        for (int i = 0; i < inputsK.size(); i++) {
            System.out.println((i + 1) + ".\tInput sequence: " + inputsString.get(i) +
                    "\n\tk: " + inputsK.get(i) + "\n");
            Set<String> repeatedSequences = findRepeatedSequences(inputsString.get(i), inputsK.get(i));
            System.out.println(repeatedSequences);
        }
    }
}
