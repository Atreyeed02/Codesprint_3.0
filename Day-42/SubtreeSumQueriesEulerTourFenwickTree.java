/*
Problem: Subtree Sum Queries

Approach:
1. Flatten the tree using Euler Tour.
2. Every subtree becomes a continuous range [tin, tout].
3. Store node values in a Fenwick Tree.
4. Update:
      Update only one position in BIT.
5. Query:
      Sum over [tin[node], tout[node]].

Time Complexity:
Euler Tour : O(N)
Update     : O(log N)
Query      : O(log N)

Space Complexity: O(N)
*/

import java.util.*;

class Main {

    static int N, Q, timer = 0;
    static ArrayList<Integer>[] graph;
    static int[] tin, tout;
    static long[] value, bit;

    static void dfs(int node, int parent) {
        tin[node] = ++timer;

        for (int child : graph[node])
            if (child != parent)
                dfs(child, node);

        tout[node] = timer;
    }

    static void update(int idx, long delta) {
        while (idx <= N) {
            bit[idx] += delta;
            idx += idx & -idx;
        }
    }

    static long prefixSum(int idx) {
        long sum = 0;

        while (idx > 0) {
            sum += bit[idx];
            idx -= idx & -idx;
        }

        return sum;
    }

    static long rangeSum(int l, int r) {
        return prefixSum(r) - prefixSum(l - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        Q = sc.nextInt();

        graph = new ArrayList[N + 1];
        tin = new int[N + 1];
        tout = new int[N + 1];
        value = new long[N + 1];
        bit = new long[N + 1];

        for (int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++)
            value[i] = sc.nextLong();

        for (int i = 0; i < N - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u].add(v);
            graph[v].add(u);
        }

        dfs(1, 0);

        for (int i = 1; i <= N; i++)
            update(tin[i], value[i]);

        while (Q-- > 0) {

            int type = sc.nextInt();

            if (type == 1) {
                int node = sc.nextInt();
                long newValue = sc.nextLong();

                update(tin[node], newValue - value[node]);
                value[node] = newValue;
            } else {
                int node = sc.nextInt();
                System.out.println(rangeSum(tin[node], tout[node]));
            }
        }
    }
}
