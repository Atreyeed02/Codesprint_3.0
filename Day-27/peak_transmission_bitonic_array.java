/*
Problem: Peak Transmission in a Bitonic Array

A bitonic array first strictly increases and then strictly decreases.
Find the maximum element (peak transmission) in O(log N) time.

Input:
7
1 3 8 12 9 5 2

Output:
12
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        int l = 0, r = n - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] < arr[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        System.out.println(arr[l]);
    }
}
