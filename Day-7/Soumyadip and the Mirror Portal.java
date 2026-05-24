/*
========================================================
Question 1: Soumyadip and the Mirror Portal
========================================================

Problem Statement:
Soumyadip discovered an ancient magical portal hidden
inside a forgotten temple.

The portal activates only when two secret words are
perfectly balanced.

According to the ancient rule:

Two strings are considered compatible if they are
anagrams of each other.

Two strings are called anagrams if:
1. they contain the same characters
2. each character appears the same number of times

Help Soumyadip determine whether the magical portal
will activate.

--------------------------------------------------------
Input Format:
- First line contains string S1
- Second line contains string S2

Output Format:
- Print "YES" if strings are anagrams
- Otherwise print "NO"
========================================================
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Taking input
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        // Edge Case 1:
        // Different lengths can never be anagrams
        if (s1.length() != s2.length()) {
            System.out.println("NO");
            return;
        }

        // Convert strings to character arrays
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        // HashMap to store character frequencies
        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency of first string
        for (char ch : arr1) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Reduce frequency using second string
        for (char ch : arr2) {

            // Edge Case 2:
            // Character not found
            if (!map.containsKey(ch)) {
                System.out.println("NO");
                return;
            }

            // Decrease frequency
            map.put(ch, map.get(ch) - 1);

            // Remove character if frequency becomes 0
            if (map.get(ch) == 0) {
                map.remove(ch);
            }
        }

        // Edge Case 3:
        // If map becomes empty -> valid anagram
        if (map.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
