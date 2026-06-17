/*
Problem: Lift Request Queue Using Stacks

Baibhavi manages a hostel lift system where floor requests
must be served in the exact order they are received.

Operations:
1. ADD X  -> Add a floor request X.
2. NEXT   -> Serve the oldest pending floor request.

If NEXT is called when no requests are pending, print -1.

Input:
Q (number of operations)
Followed by Q lines containing ADD X or NEXT.

Output:
For every NEXT operation, print the served floor number
or -1 if no request exists.

Approach:
- Use two stacks:
  s1 -> stores incoming requests.
  s2 -> serves requests in FIFO order.
- On NEXT:
  - If s2 is empty, move all elements from s1 to s2.
  - Pop from s2 and print.
  - If both stacks are empty, print -1.

Time Complexity:
ADD  -> O(1)
NEXT -> Amortized O(1)

Space Complexity:
O(Q)
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Q = sc.nextInt();
        sc.nextLine();

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        for (int i = 0; i < Q; i++) {
            String s = sc.nextLine().trim();

            if (s.startsWith("ADD")) {
                int x = Integer.parseInt(s.split(" ")[1]);
                s1.push(x);
            } else if (s.equals("NEXT")) {
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
