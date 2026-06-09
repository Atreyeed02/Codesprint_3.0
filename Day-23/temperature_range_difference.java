/*
Question: Temperature Range Difference

Problem Statement:
Anish is working on a weather monitoring system for his college research project.
Every day, temperature readings are recorded and stored in an array.

For each query [L, R], find:

    Highest Temperature - Lowest Temperature

within that range.

Input Format:
- First line contains N (number of temperature readings).
- Second line contains N space-separated integers.
- Third line contains Q (number of queries).
- Next Q lines contain L and R (0-indexed range).

Output Format:
For each query, print:
    maximum temperature in range - minimum temperature in range

Example:

Input:
8
15 20 10 25 18 30 12 22
3
1 4
2 6
0 7

Output:
15
20
20

------------------------------------------------------------
Solution 1: Brute Force
------------------------------------------------------------
For every query:
1. Traverse from L to R.
2. Find maximum and minimum element.
3. Print max - min.

Time Complexity:
O(Q × N)

------------------------------------------------------------
Solution 2: Segment Tree (Efficient)
------------------------------------------------------------
1. Build two segment trees:
   - Max Segment Tree
   - Min Segment Tree
2. For each query:
   - Get maximum in range using max tree.
   - Get minimum in range using min tree.
   - Print max - min.

Time Complexity:
Build: O(N)
Each Query: O(log N)

Since N ≤ 100, the brute-force solution is sufficient.
The code below implements the simple brute-force approach.
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

            int max = arr[L];
            int min = arr[L];

            for (int i = L; i <= R; i++) {
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i]);
            }

            System.out.println(max - min);
        }

        sc.close();
    }
}
