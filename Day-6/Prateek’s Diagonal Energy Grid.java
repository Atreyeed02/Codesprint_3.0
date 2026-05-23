// ===========================================
// Question 2: Prateek’s Diagonal Energy Grid
// ===========================================

// Problem Statement:
// Prateek discovered an ancient energy grid hidden beneath the CodeSprint 3.0 arena.
// The grid contains magical power values arranged in a square matrix.
//
// The grid is considered stable only if the sum of both diagonals is equal.
//
// Print "YES" if both diagonal sums are equal,
// otherwise print "NO".

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][n];

        int mainDiagonal = 0;
        int secondaryDiagonal = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();

                if (i == j)
                    mainDiagonal += arr[i][j];

                if (i + j == n - 1)
                    secondaryDiagonal += arr[i][j];
            }
        }

        if (mainDiagonal == secondaryDiagonal)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
