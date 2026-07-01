/*
Problem: Research Station Shortest Path (CodeSprint 3.0 Finale)

Problem Statement:
Shiva is transported to an alien research colony consisting of N research
stations connected by one-way wormholes. Each wormhole requires a certain
amount of energy to travel.

You are given Q queries asking for the minimum energy required to travel
between different pairs of stations.

If no path exists between two stations, print -1.

Approach:
- Since the graph remains unchanged and there are many shortest path queries,
  precompute the shortest distance between every pair of stations.
- Use the Floyd-Warshall algorithm.
- Initialize the distance matrix.
- Update distances using every node as an intermediate vertex.
- Answer each query in O(1).

Time Complexity: O(N³ + Q)
Space Complexity: O(N²)
*/

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        long INF = (long) 1e18;
        long[][] dist = new long[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            long w = sc.nextLong();

            dist[u][v] = Math.min(dist[u][v], w);
        }

        // Floyd-Warshall Algorithm
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (dist[i][k] == INF) continue;

                for (int j = 1; j <= n; j++) {
                    if (dist[k][j] == INF) continue;

                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int q = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (dist[a][b] == INF) {
                sb.append(-1).append("\n");
            } else {
                sb.append(dist[a][b]).append("\n");
            }
        }

        System.out.print(sb);
    }
}
