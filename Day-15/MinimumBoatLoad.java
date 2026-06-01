/*
Problem: Minimum Possible Maximum Boat Load

A rescue team wants to evacuate people using boats.
Each boat carries exactly 2 people.

Goal:
Minimize the maximum boat load among all boats.

Input:
6
70 50 80 60 40 90

Output:
130

Explanation:
Sorted Array:
40 50 60 70 80 90

Pairs:
40 + 90 = 130
50 + 80 = 130
60 + 70 = 130

Maximum boat load = 130
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

        // Sort the array
        Arrays.sort(arr);

        int i = 0;
        int j = n - 1;

        int max = 0;

        // Pair smallest with largest
        while (i < j) {

            int sum = arr[i] + arr[j];

            max = Math.max(max, sum);

            i++;
            j--;
        }

        System.out.println(max);
    }
}
