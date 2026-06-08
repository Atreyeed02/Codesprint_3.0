/*
Question: Rat in a Maze

Deep beneath the KIIT campus lies a mysterious underground maze.
The maze is represented as an N x N binary matrix where:

1 -> Open path
0 -> Blocked path

Starting from (0,0), find all possible paths to reach (N-1,N-1).
A cell can be visited at most once in a path.

Moves:
D -> Down
L -> Left
R -> Right
U -> Up

Print all valid paths. If no path exists, print -1.

Approach:
- Use Recursion + Backtracking.
- Mark the current cell as visited.
- Explore all four directions in the order D, L, R, U.
- When the destination is reached, store the path.
- Backtrack by unmarking the cell after exploring all possibilities.

Time Complexity: Exponential (Worst Case)
Space Complexity: O(N²)

Solution:
*/

import java.util.*;

public class Main {
    static int N;
    static int[][] maze;
    static boolean[][] visited;
    static ArrayList<String> paths = new ArrayList<>();

    static void solve(int row, int col, String path) {
        if (row == N - 1 && col == N - 1) {
            paths.add(path);
            return;
        }

        visited[row][col] = true;

        if (isSafe(row + 1, col))
            solve(row + 1, col, path + "D");

        if (isSafe(row, col - 1))
            solve(row, col - 1, path + "L");

        if (isSafe(row, col + 1))
            solve(row, col + 1, path + "R");

        if (isSafe(row - 1, col))
            solve(row - 1, col, path + "U");

        visited[row][col] = false;
    }

    static boolean isSafe(int row, int col) {
        return row >= 0 &&
               row < N &&
               col >= 0 &&
               col < N &&
               maze[row][col] == 1 &&
               !visited[row][col];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        maze = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        if (maze[0][0] == 0 || maze[N - 1][N - 1] == 0) {
            System.out.println("-1");
            return;
        }

        solve(0, 0, "");

        if (paths.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(paths);
            for (String p : paths) {
                System.out.println(p);
            }
        }
    }
}
