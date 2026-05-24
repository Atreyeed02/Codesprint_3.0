/*
========================================================
Question 2: Marutwan and the Signal Decoder
========================================================

Problem Statement:
Marutwan was working on a secret communication system
for CodeSprint 3.0.

During transmission, some signals were repeated
continuously because of a network glitch.

As a result, the received message contained many
consecutive repeating characters.

To make the message shorter and easier to process,
Marutwan decided to compress the signal using this rule:

Replace consecutive repeating characters with:
character + count

Help Marutwan generate the compressed signal.

--------------------------------------------------------
Input Format:
- A single string S containing lowercase English letters

Output Format:
- Print the compressed string

Example:
Input:
aaabbcccc

Output:
a3b2c4
========================================================
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Taking input
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        // Edge Case 1:
        // Empty string
        if (s.length() == 0) {
            System.out.println("");
            return;
        }

        StringBuilder ans = new StringBuilder();

        int count = 1;

        // Traverse string
        for (int i = 0; i < s.length() - 1; i++) {

            // Consecutive characters match
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {

                // Add character + count
                ans.append(s.charAt(i));
                ans.append(count);

                // Reset count
                count = 1;
            }
        }

        // Edge Case 2:
        // Add last character/group
        ans.append(s.charAt(s.length() - 1));
        ans.append(count);

        // Print answer
        System.out.println(ans);
    }
}
