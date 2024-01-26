package Algorithms_Tests;

import java.util.Arrays;

public class AnagramProblem {

    public static boolean areAnagrams(String str1, String str2) {
        // Remove white spaces and convert to lowercase
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        // Sort and compare the character arrays
        return Arrays.equals(str1.toCharArray(), str2.toCharArray());
    }

    public static void main(String[] args) {
        String str1 = "Desperation";
        String str2 = "A Rope Ends It";

        if (areAnagrams(str1, str2)) {
            System.out.println(str1 + " and " + str2 + " are anagrams.");
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams.");
        }
    }
}