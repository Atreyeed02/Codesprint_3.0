/*
Problem:
A craft shop owner has several ribbon pieces.
Each ribbon has a starting color and an ending color.
Two ribbons can be joined if the ending color of one matches the starting color of the next.

Determine whether all ribbon pieces can be arranged into one continuous ribbon,
using every ribbon exactly once. The ribbon may start and end at different colors.

Input:
P
StartColor EndColor   (P lines)

Output:
ASSEMBLY POSSIBLE   -> If such an arrangement exists.
ASSEMBLY IMPOSSIBLE -> Otherwise.

Approach:
- Model each color as a vertex and each ribbon as a directed edge.
- The problem becomes checking whether a Directed Euler Path exists.
- Conditions:
  1. Degree Condition:
     - All vertices have indegree = outdegree, OR
     - Exactly one vertex has outdegree = indegree + 1 (start)
     - Exactly one vertex has indegree = outdegree + 1 (end)
  2. Connectivity:
     - All vertices having at least one edge must belong to a single connected
       component (checked using an undirected graph).

Time Complexity: O(P)
Space Complexity: O(P)
*/

import java.util.*;

public class Main {
    static Map<String,Integer> map = new HashMap<>();
    static List<List<Integer>> g = new ArrayList<>();
    static List<Integer> in = new ArrayList<>(), out = new ArrayList<>();

    static int id(String s){
        if(!map.containsKey(s)){
            map.put(s,map.size());
            g.add(new ArrayList<>());
            in.add(0);
            out.add(0);
        }
        return map.get(s);
    }

    static void dfs(int u, boolean[] vis){
        vis[u] = true;
        for(int v : g.get(u))
            if(!vis[v]) dfs(v, vis);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();

        while(p-- > 0){
            int u = id(sc.next()), v = id(sc.next());
            out.set(u, out.get(u) + 1);
            in.set(v, in.get(v) + 1);
            g.get(u).add(v);
            g.get(v).add(u);
        }

        int n = map.size(), s = 0, e = 0, st = -1;

        for(int i = 0; i < n; i++)
            if(in.get(i) + out.get(i) > 0){
                st = i;
                break;
            }

        boolean[] vis = new boolean[n];
        if(st != -1) dfs(st, vis);

        for(int i = 0; i < n; i++){
            if(in.get(i) + out.get(i) > 0 && !vis[i]){
                System.out.println("ASSEMBLY IMPOSSIBLE");
                return;
            }

            int d = out.get(i) - in.get(i);
            if(d == 1) s++;
            else if(d == -1) e++;
            else if(d != 0){
                System.out.println("ASSEMBLY IMPOSSIBLE");
                return;
            }
        }

        System.out.println((s == 1 && e == 1) || (s == 0 && e == 0)
                ? "ASSEMBLY POSSIBLE"
                : "ASSEMBLY IMPOSSIBLE");
    }
}
