/*
Problem: Username Leaderboard Ranking

Shalini is developing a leaderboard system for CodeSprint 3.0.

Sorting Rules:
1. Usernames with more vowels should come first
2. If vowels are same, shorter username should come first
3. If still same, lexicographically smaller username should come first

Input:
5
alex
asish
aaron
john
elena

Output:
aaron
elena
alex
asish
john
*/

import java.util.*;

public class Main {

    static int count(String s) {

        int c = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u') {

                c++;
            }
        }

        return c;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        Arrays.sort(arr, (a, b) -> {

            int va = count(a);
            int vb = count(b);

            // More vowels first
            if (va != vb) {
                return vb - va;
            }

            // Shorter string first
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }

            // Lexicographical order
            return a.compareTo(b);
        });

        for (String s : arr) {
            System.out.println(s);
        }
    }
}
