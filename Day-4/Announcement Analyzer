// ======================================================
// Question 2: Announcement Analyzer
// ======================================================

/*

Problem Statement:
During the annual college fest, Shristi was given the responsibility
of managing hundreds of event announcements sent by different student clubs.

To organize the announcements better, she decided to create a smart
text analyzer for the fest committee.

The analyzer should:

1. Count the total number of vowels (a, e, i, o, u)
   irrespective of case.

2. Count the total number of consonants.

3. Count the total number of words in the sentence.

However, spaces, digits, and punctuation marks should not be counted
as vowels or consonants.

Help Shristi analyze the announcements correctly.

Input Format:
A single line of text
(may contain letters, spaces, and punctuation)

Output Format:
Line 1: Total vowels
Line 2: Total consonants
Line 3: Total words

Example Input:
Welcome to KIIT Fest 2026!

Example Output:
Total Vowels: 7
Total Consonants: 10
Total Words: 5

*/

// ======================================================
// Solution
// ======================================================

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int vowels = 0;
        int consonants = 0;
        int words = 0;

        // Count vowels and consonants
        for (int i = 0; i < str.length(); i++) {

            char ch = Character.toLowerCase(str.charAt(i));

            if (Character.isLetter(ch)) {

                // Check vowels
                if (ch == 'a' || ch == 'e' || ch == 'i'
                        || ch == 'o' || ch == 'u') {

                    vowels++;

                } else {

                    consonants++;
                }
            }
        }

        // Count words
        String arr[] = str.trim().split("\\s+");

        if (str.trim().length() == 0) {
            words = 0;
        } else {
            words = arr.length;
        }

        System.out.println("Total Vowels: " + vowels);
        System.out.println("Total Consonants: " + consonants);
        System.out.println("Total Words: " + words);
    }
}
