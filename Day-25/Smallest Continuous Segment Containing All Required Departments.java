/*
Problem: Smallest Continuous Segment Containing All Required Departments

Given:
- String S (attendance sheet)
- String T (required departments)

Find the smallest substring of S that contains all characters of T.
If no such substring exists, print -1.

Example:
Input:
ADOBECODEBANC
ABC

Output:
BANC

Approach:
- Store frequency of characters in T.
- Expand the right pointer until all required characters are present.
- Then shrink the window from the left while maintaining validity.
- Track the minimum valid window.

Time Complexity: O(N)
Space Complexity: O(1) (English alphabet)
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();

        if (s.length() < t.length()) {
            System.out.println(-1);
            return;
        }

        Map<Character, Integer> need = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int required = need.size();
        int formed = 0;

        Map<Character, Integer> window = new HashMap<>();

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if (need.containsKey(ch) &&
                window.get(ch).intValue() == need.get(ch).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                window.put(leftChar, window.get(leftChar) - 1);

                if (need.containsKey(leftChar) &&
                    window.get(leftChar) < need.get(leftChar)) {
                    formed--;
                }

                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(s.substring(start, start + minLen));
        }
    }
}
