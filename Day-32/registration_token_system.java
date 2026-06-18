/*
Problem: Registration Token System (Queue using Stacks)

Hundreds of students are registering for CodeSprint 3.0.

Operations:
1. REGISTER X -> Add registration token X.
2. NEXT       -> Process the next registration token.

If no registration is pending when NEXT is called, print -1.

Input:
Q
Operations...

Output:
For every NEXT operation, print the registration token being processed.

Example:
Input:
6
REGISTER 101
REGISTER 205
NEXT
REGISTER 309
NEXT
NEXT

Output:
101
205
309
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Q = Integer.parseInt(sc.nextLine());

        Stack<Long> s1 = new Stack<>();
        Stack<Long> s2 = new Stack<>();

        for (int i = 0; i < Q; i++) {
            String line = sc.nextLine().trim();

            if (line.startsWith("REGISTER")) {
                String[] parts = line.split(" ");
                long token = Long.parseLong(parts[1]);
                s1.push(token);
            } else if (line.equals("NEXT")) {

                if (s2.isEmpty()) {
                    while (!s1.isEmpty()) {
                        s2.push(s1.pop());
                    }
                }

                if (s2.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(s2.pop());
                }
            }
        }

        sc.close();
    }
}
