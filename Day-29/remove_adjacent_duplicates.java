/*
Problem: Remove Adjacent Duplicate Characters

If two adjacent characters are identical,
remove both of them.

Continue until no such adjacent pair exists.

Example:
Input:
abbaca

Output:
ca
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int len = stack.length();

            if (len > 0 && stack.charAt(len - 1) == ch) {
                stack.deleteCharAt(len - 1);
            } else {
                stack.append(ch);
            }
        }

        if (stack.length() == 0) {
            System.out.println("EMPTY");
        } else {
            System.out.println(stack.toString());
        }
    }
}
