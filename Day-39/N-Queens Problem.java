/*
Problem Statement:
Aarohi has been invited to solve the Royal Chessboard Challenge. The king presents
her with an N × N chessboard and asks her to place N queens on it.

Rule:
No two queens can attack each other.
A queen attacks another queen if they are in the same:
1. Row
2. Column
3. Diagonal

Input:
A single integer N.

Output:
Print all valid arrangements.
'Q' -> Queen
'.' -> Empty Cell
If no arrangement exists, print -1.

Approach:
- Use Backtracking.
- Place one queen in each row.
- Keep track of occupied columns and diagonals using boolean arrays.
- If all rows are processed, store the solution.
*/

import java.util.*;

public class Main {

    static int n;
    static List<List<String>> solutions = new ArrayList<>();
    static char[][] board;
    static boolean[] col;
    static boolean[] diag1;
    static boolean[] diag2;

    static void solve(int row) {

        if (row == n) {
            List<String> ans = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                ans.add(new String(board[i]));
            }

            solutions.add(ans);
            return;
        }

        for (int c = 0; c < n; c++) {

            int d1 = row - c + n - 1;
            int d2 = row + c;

            if (col[c] || diag1[d1] || diag2[d2])
                continue;

            board[row][c] = 'Q';
            col[c] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            solve(row + 1);

            board[row][c] = '.';
            col[c] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        col = new boolean[n];
        diag1 = new boolean[2 * n - 1];
        diag2 = new boolean[2 * n - 1];

        solve(0);

        if (solutions.isEmpty()) {
            System.out.println(-1);
        } else {
            for (List<String> sol : solutions) {
                for (String row : sol) {
                    System.out.println(row);
                }
            }
        }

        sc.close();
    }
}
