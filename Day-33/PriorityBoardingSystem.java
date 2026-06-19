/*
Problem: Airport Boarding Priority System

Passengers with higher priority board first.
If two passengers have the same priority,
the passenger who checked in earlier boards first.

Input:
4
101 2
102 5
103 3
104 5

Output:
102
104
103
101
*/

import java.util.*;

public class PriorityBoardingSystem {

    static class Passenger {
        long id;
        long priority;
        int order;

        Passenger(long id, long priority, int order) {
            this.id = id;
            this.priority = priority;
            this.order = order;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        PriorityQueue<Passenger> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.priority != b.priority) {
                    return Long.compare(b.priority, a.priority);
                }
                return Integer.compare(a.order, b.order);
            }
        );

        for (int i = 0; i < N; i++) {
            long id = sc.nextLong();
            long priority = sc.nextLong();

            pq.offer(new Passenger(id, priority, i));
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            sb.append(pq.poll().id).append("\n");
        }

        System.out.print(sb);
    }
}
