/*
Problem: Sliding Window Maximum

Given N recorded values and a window size K,
find the maximum value in every contiguous window of size K.

Input:
8 3
750 820 900 780 910 860 880 790

Output:
900 900 910 910 910 880
*/

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }

        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {

            while (!dq.isEmpty() && dq.peekFirst() <= i - K) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            if (i >= K - 1) {
                sb.append(arr[dq.peekFirst()]);
                if (i != N - 1) sb.append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
