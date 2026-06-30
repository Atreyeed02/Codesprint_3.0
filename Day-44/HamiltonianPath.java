/*
Problem:
A health department manager needs to determine whether a vaccination carrier can
visit every village exactly once using the given two-way roads.
The carrier may start and end at any village.

Input:
N M
u1 v1
u2 v2
...
uM vM

Output:
MISSION POSSIBLE  -> If a route exists that visits every village exactly once.
MISSION FAILED    -> Otherwise.

Approach:
- Model villages as an undirected graph.
- Try starting DFS from every village.
- Use backtracking:
    * Mark current village as visited.
    * Recursively visit every unvisited neighbor.
    * If all N villages are visited, a Hamiltonian Path exists.
    * Otherwise, backtrack.

Time Complexity: O(N!)
Space Complexity: O(N + M)
*/

import java.util.*;

public class Main {
    static ArrayList<Integer>[] g;
    static boolean[] vis;
    static int n;

    static boolean dfs(int u, int cnt) {
        vis[u] = true;
        if (cnt == n) return true;

        for (int v : g[u])
            if (!vis[v] && dfs(v, cnt + 1))
                return true;

        vis[u] = false;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();

        g = new ArrayList[n + 1];
        vis = new boolean[n + 1];

        for (int i = 1; i <= n; i++)
            g[i] = new ArrayList<>();

        while (m-- > 0) {
            int u = sc.nextInt(), v = sc.nextInt();
            g[u].add(v);
            g[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            if (dfs(i, 1)) {
                System.out.println("MISSION POSSIBLE");
                return;
            }
        }

        System.out.println("MISSION FAILED");
    }
}
