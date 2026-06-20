/*
Problem: Rotting Oranges

Problem Statement:
Atreyee is helping manage the fruit store in his hostel.

Some oranges have already become rotten. Every minute, a rotten orange
spreads the infection to all adjacent fresh oranges.

Cell Values:
0 -> Empty Cell
1 -> Fresh Orange
2 -> Rotten Orange

Two oranges are considered adjacent if they share a side
(up, down, left, right).

Find the minimum number of minutes required for all fresh oranges
to become rotten.

If it is impossible, print -1.

Input Format:
N M

grid[0][0] grid[0][1] ... grid[0][M-1]
...
grid[N-1][0] ... grid[N-1][M-1]

Example:
Input:
3 3

2 1 1
1 1 0
0 1 1

Output:
4

Explanation:
Initially one orange is rotten.

Minute 1:
2 2 1
2 1 0
0 1 1

Minute 2:
2 2 2
2 2 0
0 1 1

Minute 3:
2 2 2
2 2 0
0 2 1

Minute 4:
2 2 2
2 2 0
0 2 2

All oranges become rotten after 4 minutes.

Approach:
Use Multi-Source BFS.

1. Add all rotten oranges to the queue initially.
2. Count fresh oranges.
3. Perform BFS level by level.
4. Each BFS level represents one minute.
5. Rot adjacent fresh oranges and add them to the queue.
6. If all fresh oranges become rotten, return minutes.
7. Otherwise return -1.

Time Complexity: O(N * M)
Space Complexity: O(N * M)
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] grid = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();

                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            System.out.println(0);
            return;
        }

        int minutes = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < m &&
                        grid[nr][nc] == 1) {

                        grid[nr][nc] = 2;
                        fresh--;

                        q.offer(new int[]{nr, nc});
                    }
                }
            }

            minutes++;
        }

        System.out.println(fresh == 0 ? minutes : -1);
    }
}
