/*
Problem: Count Subarrays With Sum K

Given an array of integers and a target sum K,
find the total number of continuous subarrays
whose sum is exactly K.

Input:
5 3
1 -1 5 -2 3

Output:
3

Approach:
- Use Prefix Sum + HashMap
- Store frequency of prefix sums
- If (prefixSum - K) exists, add its frequency to count

Time Complexity: O(N)
Space Complexity: O(N)
*/

import java.util.*;

public class CountSubarraysWithSumK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int presum = 0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            presum += arr[i];

            count += map.getOrDefault(presum - K, 0);

            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }

        System.out.println(count);

        sc.close();
    }
}
