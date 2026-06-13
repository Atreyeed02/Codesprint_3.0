/*
Problem: Treasure Vault Search

An N x M matrix is sorted such that:
1. Each row is sorted in increasing order.
2. First element of a row is greater than the last element of the previous row.

Determine whether a target value X exists in the matrix.

Input:
3 4
1 3 5 7
10 11 16 20
23 30 34 60
16

Output:
FOUND
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        long[][] matrix = new long[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextLong();
            }
        }

        long x = sc.nextLong();

        int low = 0;
        int high = n * m - 1;

        boolean found = false;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int row = mid / m;
            int col = mid % m;

            if (matrix[row][col] == x) {
                found = true;
                break;
            } else if (matrix[row][col] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(found ? "FOUND" : "NOT FOUND");
    }
}
