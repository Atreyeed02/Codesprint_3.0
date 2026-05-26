/*
Question:
Abhishek’s Sorted Squares Challenge

Given a sorted array containing negative and positive integers,
square every number and print the resulting array in sorted order.

Input:
First line contains integer N.
Second line contains N sorted integers.

Example:
Input:
5
-7 -3 2 3 11

Output:
4 9 9 49 121
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

        int[] result = new int[n];

        int left = 0;
        int right = n - 1;
        int index = n - 1;

        while (left <= right) {

            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];

            if (leftSquare > rightSquare) {
                result[index] = leftSquare;
                left++;
            } else {
                result[index] = rightSquare;
                right--;
            }

            index--;
        }

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
