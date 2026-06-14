/*
Problem: Attendance Log Validation

Given a string containing:
() [] {} <>

Check whether:
1. Every opening symbol has a matching closing symbol.
2. Symbols close in the correct order.
3. No closing symbol appears before its opening symbol.

Approach:
- Use Stack.
- Push opening symbols.
- For closing symbols:
  - Check stack is not empty.
  - Verify top matches.
  - Pop if matched.
- String is valid if stack is empty at the end.

Time Complexity: O(N)
Space Complexity: O(N)
*/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Stack<Character> stack = new Stack<>();
        boolean valid = true;

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{' || ch == '<') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    valid = false;
                    break;
                }

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == ']' && top != '[') ||
                    (ch == '}' && top != '{') ||
                    (ch == '>' && top != '<')) {
                    valid = false;
                    break;
                }
            }
        }

        if (!stack.isEmpty()) {
            valid = false;
        }

        System.out.println(valid ? "VALID" : "INVALID");
    }
}
