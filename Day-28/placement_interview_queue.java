/*
Problem: Placement Interview Queue Management

Operations:
1. REGISTER X -> Add student X to the queue.
2. WITHDRAW   -> Remove the student at the front.
3. NEXT       -> Call the next student for interview.

Approach:
- Use Queue (FIFO).
- REGISTER -> offer()
- WITHDRAW -> poll()
- NEXT -> print and poll()
- If queue is empty during NEXT, print -1.

Time Complexity: O(Q)
Space Complexity: O(Q)
*/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Q = sc.nextInt();
        sc.nextLine();

        Queue<Long> queue = new LinkedList<>();

        for (int i = 0; i < Q; i++) {
            String line = sc.nextLine().trim();

            if (line.startsWith("REGISTER")) {
                String[] parts = line.split(" ");
                long id = Long.parseLong(parts[1]);
                queue.offer(id);
            }
            else if (line.equals("WITHDRAW")) {
                if (!queue.isEmpty()) {
                    queue.poll();
                }
            }
            else if (line.equals("NEXT")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue.poll());
                }
            }
        }

        sc.close();
    }
}
