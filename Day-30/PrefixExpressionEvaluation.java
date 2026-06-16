/*
Problem: Prefix Expression Evaluation

Description:
Given a valid prefix expression containing:
Operands: Single-digit integers (0–9)
Operators: +, -, *, /

Evaluate the expression and print the result.

Example:
Input:
-*+2345

Output:
15

Explanation:
((2 + 3) * 4) - 5
= (5 * 4) - 5
= 20 - 5
= 15

Time Complexity: O(N)
Space Complexity: O(N)
*/

import java.util.*;

public class PrefixExpressionEvaluation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expr = sc.next();

        Stack<Integer> stack = new Stack<>();

        for (int i = expr.length() - 1; i >= 0; i--) {
            char ch = expr.charAt(i);

            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                int a = stack.pop();
                int b = stack.pop();

                int res = 0;

                switch (ch) {
                    case '+': res = a + b; break;
                    case '-': res = a - b; break;
                    case '*': res = a * b; break;
                    case '/': res = a / b; break;
                }

                stack.push(res);
            }
        }

        System.out.println(stack.pop());
        sc.close();
    }
}
