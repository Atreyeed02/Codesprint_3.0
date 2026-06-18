/*
Problem: Parcel Pickup Counter (Circular Queue)

Operations:
1. ENQUEUE X -> Add parcel token X
2. DEQUEUE   -> Remove front parcel token
3. FRONT     -> Print front parcel token

Rules:
- If queue is full during ENQUEUE, print "FULL"
- If queue is empty during DEQUEUE, print "EMPTY"
- If queue is empty during FRONT, print -1

Input:
K Q
Operations...

Output:
For each FRONT operation, print the front token.
For invalid ENQUEUE/DEQUEUE operations, print FULL/EMPTY.
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int Q = sc.nextInt();
        sc.nextLine();

        long[] queue = new long[K];

        int front = 0;
        int rear = 0;
        int size = 0;

        for (int i = 0; i < Q; i++) {
            String line = sc.nextLine().trim();

            if (line.startsWith("ENQUEUE")) {
                String[] parts = line.split(" ");
                long x = Long.parseLong(parts[1]);

                if (size == K) {
                    System.out.println("FULL");
                } else {
                    queue[rear] = x;
                    rear = (rear + 1) % K;
                    size++;
                }
            }
            else if (line.equals("DEQUEUE")) {
                if (size == 0) {
                    System.out.println("EMPTY");
                } else {
                    front = (front + 1) % K;
                    size--;
                }
            }
            else if (line.equals("FRONT")) {
                if (size == 0) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue[front]);
                }
            }
        }

        sc.close();
    }
}
