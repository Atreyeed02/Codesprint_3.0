/*
Problem: Task Pipeline Assignment (CodeSprint 3.0 Finale)

Problem Statement:
After 45 incredible days, CodeSprint 3.0 has reached its finale.

The organizers need to assign N verification tasks to two UiPath automation
pipelines. Some pairs of tasks have conflicts, meaning they cannot be assigned
to the same pipeline.

Given N tasks and M conflict pairs, determine whether it is possible to assign
every task to one of the two pipelines such that no conflicting tasks are
assigned to the same pipeline.

If possible:
- Print "YES"
- Print the assigned pipeline (1 or 2) for every task.

Otherwise:
- Print "NO"

Approach:
- Model the tasks and conflicts as an undirected graph.
- A valid assignment exists iff the graph is Bipartite.
- Perform BFS on every connected component.
- Color each node with one of two colors (1 and 2).
- If two adjacent nodes receive the same color, the graph is not bipartite.

Time Complexity: O(N + M)
Space Complexity: O(N + M)
*/

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u].add(v);
            graph[v].add(u);
        }

        int[] color = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (color[i] != 0) continue;

            color[i] = 1;
            q.offer(i);

            while (!q.isEmpty()) {
                int node = q.poll();

                for (int nei : graph[node]) {
                    if (color[nei] == 0) {
                        color[nei] = 3 - color[node];
                        q.offer(nei);
                    } else if (color[nei] == color[node]) {
                        System.out.println("NO");
                        return;
                    }
                }
            }
        }

        System.out.println("YES");

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(color[i]).append(" ");
        }

        System.out.println(sb);
    }
}
