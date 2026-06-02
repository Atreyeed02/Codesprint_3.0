/*
Problem Statement
During his college fest, Aditya collected badges from various events held across the campus.

Some of these badges belonged to premium events organized by the college committee.

Each premium badge type is represented by a unique character in a string called jewels.

The complete collection of badges gathered by Aditya is represented by another string called stones.

Your task is to help Aditya determine how many badges in his collection are premium badges.

Note:
Characters are case-sensitive, which means 'a' and 'A' are considered different badge types.

Input Format
The first line contains a string jewels — representing the premium badge types.
The second line contains a string stones — representing all the badges collected by Aditya.

Output Format
Print a single integer — the total number of premium badges present in the collection.

Example
Input:
aA
aAAbbbb

Output:
3

Explanation
The premium badge types are 'a' and 'A'.

In the string "aAAbbbb":
'a' appears 1 time
'A' appears 2 times

Total premium badges = 3

Constraints
1 ≤ jewels.length, stones.length ≤ 50
jewels and stones contain only English letters.
All characters in jewels are unique.
*/

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String jewels = sc.next();
        String stones = sc.next();

        HashSet<Character> set = new HashSet<>();

        // Convert jewels string into char array
        char[] jarr = jewels.toCharArray();

        // Store jewels in HashSet
        for (char ch : jarr) {
            set.add(ch);
        }

        int c = 0;

        // Convert stones string into char array
        char[] sarr = stones.toCharArray();

        // Count matching characters
        for (char ch : sarr) {
            if (set.contains(ch)) {
                c++;
            }
        }

        System.out.println(c);
    }
}
