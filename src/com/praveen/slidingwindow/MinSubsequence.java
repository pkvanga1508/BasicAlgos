package com.praveen.slidingwindow;

class MinSubsequence {

    public static String minWindow(String str1, String str2) {

        int index1 = 0;
        int index2 = 0;
        int startIndex = -1;
        int endIndex = -1;
        int seqLength = Integer.MAX_VALUE;
        String sequence = "";
        while(index1 < str1.length()) {
            if(str1.charAt(index1) == str2.charAt(index2)) {
                if(startIndex == -1) { //matched first charecter
                    startIndex = index1;
                }
                index2++;
                if(index2 == str2.length()) { //Reached end of string 2
                    endIndex = index1;
                    if(seqLength > (endIndex - startIndex + 1)) {
                        seqLength = endIndex - startIndex + 1;
                        System.out.println("Sequence length : " + seqLength);
                        sequence = str1.substring(startIndex, endIndex + 1); //to index not included
                        //Reset the values
                        index2 = 0;
                        //This is to solve some edge cases
                        index1 = startIndex; //start fotm startIndex + 1 but the index1 is already incremented below
                        startIndex = -1;
                        endIndex = -1;
                    }
                }
            }
            index1++;
        }
        return sequence;
    }

    public static void main(String[] args) {
        // Driver code
        String[] str1 = {
          "abcdedeaqdweq", "fgrqsqsnodwmxzkzxwqegkndaa", "zxcvnhss", "alpha", "beta"
        };
        String[] str2 = {
          "adeq", "kzed", "css", "la", "ab"
        };
        for (int i = 0; i < str1.length; i++) {
          System.out.println(i + 1 + ".\tInput String: " + "(" + str1[i] + ", " + str2[i] + ")");
          System.out.println("\tSubsequence string: " + minWindow(str1[i], str2[i]));
          System.out.println(new String(new char[100]).replace('\0', '-'));
        }
      }
}