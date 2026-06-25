/*
Problem Statement:
Tamanna discovers a grid of letters and wants to know whether a given word
exists in the grid.

Rules:
- Start from any cell.
- Move only Up, Down, Left or Right.
- A cell cannot be used more than once.

Input:
N M
Grid
Word

Output:
YES -> Word exists
NO -> Word does not exist

Approach:
- Try starting from every cell matching the first character.
- Use DFS + Backtracking.
- Mark a cell as visited while exploring.
- Unmark it when backtracking.
*/

import java.util.*;

public class Main {

    static int n, m;
    static char[][] board;
    static String word;
    static boolean[][] visited;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static boolean dfs(int r, int c, int idx) {

        if (idx == word.length())
            return true;

        if (r < 0 || r >= n || c < 0 || c >= m
                || visited[r][c]
                || board[r][c] != word.charAt(idx))
            return false;

        visited[r][c] = true;

        for (int k = 0; k < 4; k++) {

            int nr = r + dr[k];
            int nc = c + dc[k];

            if (dfs(nr, nc, idx + 1)) {
                visited[r][c] = false;
                return true;
            }
        }

        visited[r][c] = false;
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.next().charAt(0);
            }
        }

        word = sc.next();

        visited = new boolean[n][m];

        boolean found = false;

        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < m && !found; j++) {

                if (board[i][j] == word.charAt(0)) {

                    if (dfs(i, j, 0)) {
                        found = true;
                    }
                }
            }
        }

        System.out.println(found ? "YES" : "NO");

        sc.close();
    }
}
