/*
Problem: Infix to Postfix Conversion

Description:
Given a valid infix expression containing:
Operands: A-Z, a-z
Operators: +, -, *, /
Parentheses: (, )

Convert the infix expression into its equivalent postfix expression.

Example:
Input:
A+(B*C)

Output:
ABC*+

Explanation:
B*C has higher precedence than +
Therefore:
A + (B*C)
becomes:
ABC*+

Time Complexity: O(N)
Space Complexity: O(N)
*/

import java.util.*;

public class InfixToPostfixConversion {

    static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (Character.isLetter(ch)) {
                postfix.append(ch);
            }
            else if (ch == '(') {
                stack.push(ch);
            }
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            }
            else {
                while (!stack.isEmpty() &&
                        precedence(stack.peek()) >= precedence(ch)) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        System.out.println(postfix);
        sc.close();
    }
}
