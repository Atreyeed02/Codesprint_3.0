/*
Problem Statement:
A biotechnologist Shreyansh is working in a company named GenomeShield.
It is researching dangerous virus mutations using long DNA sequences.

Shreyansh observed that certain highly stable virus structures form
perfectly symmetrical genetic patterns.

These patterns read exactly the same from left to right and right to left.

Your task is to find the longest palindromic substring.

Input:
aacxyzyxdef

Output:
xyzyx
*/

import java.util.*;

public class Main {

    public static String longest(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {

            int len1 = expand(s, i, i);

            int len2 = expand(s, i, i + 1);

            int len = Math.max(len1, len2);

            if (len > end - start) {

                start = i - (len - 1) / 2;

                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    public static int expand(String s, int l, int r) {

        while (l >= 0 && r < s.length()
                && s.charAt(l) == s.charAt(r)) {

            l--;
            r++;
        }

        return r - l - 1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(longest(s));
    }
}
