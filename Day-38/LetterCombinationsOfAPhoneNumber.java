/*
Problem: Letter Combinations of a Phone Number

Dwiti discovers a keypad where each digit maps to a set of letters
just like a traditional mobile phone keypad.

Given a string of digits (2-9), generate all possible letter
combinations that the number could represent.

Input:
23

Output:
ad ae af bd be bf cd ce cf

Approach:
- Use Backtracking.
- For each digit, try every possible mapped letter.
- Build combinations one character at a time.
*/

import java.util.*;

public class Main {

    static String[] map = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    static List<String> res = new ArrayList<>();

    static void solve(String digits, int idx, StringBuilder curr) {
        if (idx == digits.length()) {
            res.add(curr.toString());
            return;
        }

        String letters = map[digits.charAt(idx) - '0'];

        for (char ch : letters.toCharArray()) {
            curr.append(ch);
            solve(digits, idx + 1, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String digits = sc.next();

        solve(digits, 0, new StringBuilder());

        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
            if (i < res.size() - 1) {
                System.out.print(" ");
            }
        }

        sc.close();
    }
}
