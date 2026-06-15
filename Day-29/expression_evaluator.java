/*
Problem: Calculator Expression Evaluation

Given a valid mathematical expression containing:
+ , - , * , /

Evaluate it according to standard operator precedence.
Division should truncate toward zero.

Example:
Input:
3+2*2

Output:
7
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char op = '+';

        for (int i = 0; i <= s.length(); i++) {
            char ch = (i < s.length()) ? s.charAt(i) : '+';

            if (i < s.length() && Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else {
                if (op == '+') {
                    stack.push(num);
                } else if (op == '-') {
                    stack.push(-num);
                } else if (op == '*') {
                    stack.push(stack.pop() * num);
                } else if (op == '/') {
                    stack.push(stack.pop() / num);
                }

                op = ch;
                num = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        System.out.println(result);
    }
}
