/*
Problem: Maximum Consecutive Tokens Under Memory Limit

Supriyo is developing a local AI chat plugin for his note-taking application.
The notes are represented as a sequence of encrypted tokens, where each token
has a memory weight.

The AI model can process only a continuous sequence of tokens whose total
memory weight does not exceed a limit W.

Find the maximum number of consecutive tokens that can be processed in a
single batch without exceeding the memory limit.

Input:
N W
N space-separated integers representing token weights.

Output:
Length of the longest continuous subarray whose sum does not exceed W.

Example:
Input:
6 10
3 1 2 4 5 1

Output:
4

Approach:
Sliding Window (Two Pointers)
Time Complexity: O(N)
Space Complexity: O(1)
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long W = sc.nextLong();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int maxLen = 0;
        long sum = 0;

        for (int right = 0; right < N; right++) {
            sum += arr[right];

            while (sum > W) {
                sum -= arr[left];
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        System.out.println(maxLen);
    }
}
