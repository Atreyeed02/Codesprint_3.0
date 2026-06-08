/*
Question: Merge Sort using Divide & Conquer

Ankita created a magical coding screen that automatically split
a problem into smaller parts and combined them recursively.

Given an array of N integers, sort the array in ascending order
using the Divide & Conquer approach.

Approach:
- Recursively divide the array into two halves.
- Continue until each subarray contains one element.
- Merge the sorted halves while maintaining order.
- Repeat until the complete array becomes sorted.

Time Complexity: O(N log N)
Space Complexity: O(N)

Solution:
*/

import java.util.*;

public class Main {

    static void mergeSort(long[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    static void merge(long[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        long[] L = new long[n1];
        long[] R = new long[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) {
            arr[k++] = L[i++];
        }

        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }

        mergeSort(arr, 0, N - 1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(arr[i]);
            if (i < N - 1) {
                sb.append(" ");
            }
        }

        System.out.print(sb);
    }
}
