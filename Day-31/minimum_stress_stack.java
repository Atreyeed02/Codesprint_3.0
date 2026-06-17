/*
Problem: Minimum Stress Level Stack

Juhi tracks her daily stress levels using a stack-based system.

Operations:
1. PUSH X -> Add stress level X.
2. POP    -> Remove the most recently added stress level.
3. MIN    -> Print the minimum stress level currently present.

Rules:
- If MIN is called on an empty stack, print -1.
- If POP is called on an empty stack, ignore the operation.

Approach:
- Use two stacks:
  1. stack    -> Stores all stress levels.
  2. minstack -> Stores the minimum value up to each position.
- For every PUSH:
  - Push X into stack.
  - Push min(X, current minimum) into minstack.
- For every POP:
  - Pop from both stacks.
- For every MIN:
  - Top of minstack gives the minimum element in O(1).

Time Complexity:
PUSH -> O(1)
POP  -> O(1)
MIN  -> O(1)

Space Complexity:
O(N)
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Q = sc.nextInt();
        sc.nextLine();

        Stack<Long> stack = new Stack<>();
        Stack<Long> minstack = new Stack<>();

        for (int i = 0; i < Q; i++) {
            String line = sc.nextLine().trim();

            if (line.startsWith("PUSH")) {
                long x = Long.parseLong(line.split(" ")[1]);

                stack.push(x);

                if (minstack.isEmpty()) {
                    minstack.push(x);
                } else {
                    minstack.push(Math.min(x, minstack.peek()));
                }
            } 
            else if (line.equals("POP")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                    minstack.pop();
                }
            } 
            else if (line.equals("MIN")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(minstack.peek());
                }
            }
        }

        sc.close();
    }
}
