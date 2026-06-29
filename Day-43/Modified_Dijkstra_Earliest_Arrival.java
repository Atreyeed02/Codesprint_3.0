/*
Problem Statement

Anurag is managing a transportation network between cities.

The network consists of N cities numbered from 1 to N and M directed roads.

Each road has:
1. Travel Time (T)
2. Expiry Time (E)

A road can only be used if Anurag reaches its starting city strictly before the road expires.
If he arrives at or after the expiry time, that road becomes unavailable.

Anurag starts from city 1 at time 0 and wants to reach every other city as quickly as possible.

Print the earliest arrival time for every city.
If a city cannot be reached, print -1.

Approach:
- Use Modified Dijkstra's Algorithm.
- dist[i] stores the earliest arrival time at city i.
- While relaxing an edge, first check:
      currentTime < expiry
- If the road is still valid, relax normally.

Time Complexity:
O((N + M) log N)

Space Complexity:
O(N + M)
*/
import java.util.*;

public class Main {

    static class Edge {
        int to;
        int travel;
        int expiry;

        Edge(int to, int travel, int expiry) {
            this.to = to;
            this.travel = travel;
            this.expiry = expiry;
        }
    }

    static class Pair implements Comparable<Pair> {
        int node;
        long time;

        Pair(int node, long time) {
            this.node = node;
            this.time = time;
        }

        public int compareTo(Pair other) {
            return Long.compare(this.time, other.time);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<Edge>[] graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int t = sc.nextInt();
            int e = sc.nextInt();

            graph[u].add(new Edge(v, t, e));
        }

        long INF = Long.MAX_VALUE;

        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        dist[1] = 0;
        pq.add(new Pair(1, 0));

        while (!pq.isEmpty()) {

            Pair cur = pq.poll();

            if (cur.time != dist[cur.node])
                continue;

            for (Edge edge : graph[cur.node]) {

                if (cur.time < edge.expiry) {

                    long newTime = cur.time + edge.travel;

                    if (newTime < dist[edge.to]) {
                        dist[edge.to] = newTime;
                        pq.add(new Pair(edge.to, newTime));
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (dist[i] == INF)
                System.out.print(-1 + " ");
            else
                System.out.print(dist[i] + " ");
        }
    }
}
