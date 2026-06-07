/*
Problem: Flatten Sorted Linked Lists

Dwipayan stored his semester notes in a unique multi-level linked structure.
Some notes contained another complete sorted sub-list of related notes attached downward.

Help flatten the entire structure into a single sorted linked list.

Input:
N = Number of sorted sublists

Example:
3
1 4 7
2 5 8
3 6 9

Output:
1 2 3 4 5 6 7 8 9

Approach:
Use a Min Heap (Priority Queue) to merge K sorted lists efficiently.

Time Complexity: O(T log N)
Space Complexity: O(N)
*/

import java.util.*;

public class FlattenSortedLinkedLists {

    static class Node {
        int val;
        int listIdx;
        int eleIdx;

        Node(int val, int listIdx, int eleIdx) {
            this.val = val;
            this.listIdx = listIdx;
            this.eleIdx = eleIdx;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine().trim();

            List<Integer> curr = new ArrayList<>();

            if (!line.isEmpty()) {

                String[] parts = line.split("\\s+");

                for (String p : parts) {
                    curr.add(Integer.parseInt(p));
                }
            }

            lists.add(curr);
        }

        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for (int i = 0; i < n; i++) {
            if (!lists.get(i).isEmpty()) {
                pq.offer(new Node(lists.get(i).get(0), i, 0));
            }
        }

        StringBuilder res = new StringBuilder();

        while (!pq.isEmpty()) {

            Node curr = pq.poll();

            res.append(curr.val).append(" ");

            int nextIdx = curr.eleIdx + 1;

            if (nextIdx < lists.get(curr.listIdx).size()) {

                pq.offer(new Node(
                        lists.get(curr.listIdx).get(nextIdx),
                        curr.listIdx,
                        nextIdx
                ));
            }
        }

        System.out.println(res.toString().trim());
    }
}
