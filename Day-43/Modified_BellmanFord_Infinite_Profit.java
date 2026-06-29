/*
Problem Statement

Vedabetta is analyzing currency exchange opportunities between countries.

There are N currencies and M directed exchange routes.

Each route U V W changes the money by W units.

Positive W -> Profit
Negative W -> Loss

Vedabetta starts from currency 1 and wants to determine the maximum profit obtainable upon reaching currency N.

If there exists a positive-profit cycle that:
1. is reachable from currency 1, and
2. can also reach currency N,

print:
INFINITE PROFIT

If currency N is unreachable, print:
UNREACHABLE

Otherwise print the maximum profit.

Approach:
- Use Modified Bellman-Ford.
- profit[i] stores the maximum profit to reach i.
- Relax edges N-1 times.
- Perform one extra relaxation.
- Any node still getting updated belongs to or is affected by a profitable cycle.
- Run BFS/DFS from affected nodes.
- If destination N is reachable from any affected node,
  answer is INFINITE PROFIT.

Time Complexity:
O(N × M)

Space Complexity:
O(N + M)
*/
import java.util.*;

public class Main {

    static class Edge {
        int u, v;
        long w;

        Edge(int u, int v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            long w = sc.nextLong();

            edges.add(new Edge(u, v, w));
            graph[u].add(v);
        }

        long NEG_INF = Long.MIN_VALUE / 4;

        long[] profit = new long[n + 1];
        Arrays.fill(profit, NEG_INF);

        profit[1] = 0;

        for (int i = 1; i <= n - 1; i++) {

            boolean updated = false;

            for (Edge e : edges) {

                if (profit[e.u] == NEG_INF)
                    continue;

                if (profit[e.u] + e.w > profit[e.v]) {
                    profit[e.v] = profit[e.u] + e.w;
                    updated = true;
                }
            }

            if (!updated)
                break;
        }

        boolean[] affected = new boolean[n + 1];

        for (Edge e : edges) {

            if (profit[e.u] == NEG_INF)
                continue;

            if (profit[e.u] + e.w > profit[e.v]) {
                profit[e.v] = profit[e.u] + e.w;
                affected[e.v] = true;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (affected[i]) {
                q.add(i);
                vis[i] = true;
            }
        }

        while (!q.isEmpty()) {

            int node = q.poll();

            for (int nxt : graph[node]) {
                if (!vis[nxt]) {
                    vis[nxt] = true;
                    q.add(nxt);
                }
            }
        }

        if (vis[n]) {
            System.out.println("INFINITE PROFIT");
        } else if (profit[n] == NEG_INF) {
            System.out.println("UNREACHABLE");
        } else {
            System.out.println(profit[n]);
        }
    }
}
