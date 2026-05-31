/*
Problem Statement
Sanchita is sorting a list of encrypted server IDs. However, swapping two elements is extremely expensive in her system, so she wants a sorting method that uses as few swaps as possible.

Your task is to sort the array using the selection process and determine the total number of swaps performed during sorting.

In each step, select the minimum element from the unsorted portion of the array and place it in its correct position.

A swap is counted only when two different positions exchange their values. If an element is already in its correct position, no swap is counted.

Print the sorted array and the total number of swaps performed.

Input Format
First line contains integer N
Second line contains N integers

Output Format
Print the sorted array on the first line.
Print the total number of swaps performed on the second line.

Example
Input:
5
64 25 12 22 11

Output:
11 12 22 25 64
3
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int swaps = 0;

        // Selection Sort
        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            // Find minimum element
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap only if needed
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;

                swaps++;
            }
        }

        // Print sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        // Print total swaps
        System.out.println(swaps);

        sc.close();
    }
}
