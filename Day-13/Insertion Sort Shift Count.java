/*
Problem Statement
Apoorva receives an array that is already sorted except for a few misplaced elements.

She wants to choose a sorting algorithm that performs efficiently on such arrays.

Your task is to sort the array using the insertion process and determine how many shifts are performed during the sorting.

A shift occurs whenever an element moves one position to the right while inserting an element into its correct position.

Count every single-position right movement as one shift.

Input Format
First line contains integer N

Second line contains N integers

Output Format
Print the sorted array on the first line.

Print the total number of shifts performed on the second line.
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

        int shifts = 0;

        // Insertion Sort
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                shifts++;
                j--;
            }

            arr[j + 1] = key;
        }

        // Print sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        // Print total shifts
        System.out.println(shifts);
    }
}
```
