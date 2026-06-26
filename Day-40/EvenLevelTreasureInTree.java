/*
While exploring the ruins of an ancient kingdom, Dipanshu discovered a magical
treasure tree consisting of N nodes. Each node contains a certain number of
gold coins.

The tree is rooted at node 1.

According to the kingdom's ancient rule, Dipanshu is allowed to collect treasure
only from nodes located at even levels of the tree.

The levels are defined as follows:
- Node 1 (the root) is at level 0.
- The children of a node at level L are at level L + 1.

Your task is to determine the total amount of treasure Dipanshu can collect.

Input Format:
- First line: Integer N
- Second line: N space-separated integers representing treasure at each node
- Next N-1 lines: Two integers u and v representing an undirected edge

Output Format:
Print the total treasure collected from nodes at even levels.

Example
Input:
7
5 3 8 2 4 6 1
1 2
1 3
2 4
2 5
3 6
3 7

Output:
18
*/
import java.util.*;

public class Main {

    static class Pair {
        int node, level;

        Pair(int node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long[] treasure = new long[N + 1];

        for (int i = 1; i <= N; i++)
            treasure[i] = sc.nextLong();

        ArrayList<Integer>[] adj = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj[u].add(v);
            adj[v].add(u);
        }

        boolean[] visited = new boolean[N + 1];
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(1, 0));
        visited[1] = true;

        long ans = 0;

        while (!queue.isEmpty()) {

            Pair curr = queue.poll();

            if (curr.level % 2 == 0)
                ans += treasure[curr.node];

            for (int next : adj[curr.node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new Pair(next, curr.level + 1));
                }
            }
        }

        System.out.println(ans);
        sc.close();
    }
}
