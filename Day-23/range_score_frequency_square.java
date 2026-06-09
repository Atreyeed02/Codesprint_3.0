/*
Question: Range Score of a Subarray

Problem Statement:
Ayush is participating in a cybersecurity competition.

The Range Score of a subarray is defined as:

Σ (frequency of each distinct number)^2

For every query [L, R]:
1. Count frequency of each distinct element.
2. Square each frequency.
3. Sum all squared frequencies.

Print the Range Score for each query.

Example:

Input:
5
1 2 1 3 2
3
0 4
0 2
1 3

Output:
9
5
3

Explanation:

Query [0,4]:
1 -> 2 times
2 -> 2 times
3 -> 1 time

Score = 2² + 2² + 1²
      = 4 + 4 + 1
      = 9

Approach:
1. Use a HashMap to store frequencies.
2. Traverse from L to R.
3. Compute Σ(freq²).

Time Complexity:
O(Q × N)

Space Complexity:
O(N)
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int Q = sc.nextInt();

        while (Q-- > 0) {
            int L = sc.nextInt();
            int R = sc.nextInt();

            HashMap<Integer, Integer> freq = new HashMap<>();

            for (int i = L; i <= R; i++) {
                freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            }

            long rangeScore = 0;

            for (int count : freq.values()) {
                rangeScore += (long) count * count;
            }

            System.out.println(rangeScore);
        }

        sc.close();
    }
}
