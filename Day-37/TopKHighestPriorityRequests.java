/*
Problem: Top K Highest Priority Requests

Given N request priorities, find the K highest
priority values and print them in increasing order.

Input:
8 3
12 5 78 100 34 90 11 67

Output:
78 90 100

Approach:
- Maintain a Min Heap of size K
- Remove the smallest element whenever size exceeds K
- Heap finally contains the K largest elements
- Sort and print them

Time Complexity: O(N log K)
Space Complexity: O(K)
*/

import java.util.*;

public class TopKHighestPriorityRequests {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();

            minHeap.offer(x);

            if (minHeap.size() > K) {
                minHeap.poll();
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll());
        }

        Collections.sort(res);

        for (int num : res) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
