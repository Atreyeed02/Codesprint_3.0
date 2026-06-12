/*
Problem: Clone Linked List with Random Pointer

A linked list contains:
1. data
2. next pointer
3. random pointer

Create a deep copy of the linked list such that:
- New nodes are created.
- next and random relationships are preserved.
- No cloned node points to an original node.

Approach:
1. Create clone nodes using a HashMap.
2. Map each original node to its clone.
3. Set next and random pointers using the map.

Time Complexity: O(N)
Space Complexity: O(N)
*/

import java.util.*;

class Node {
    int data;
    Node next, random;

    Node(int data) {
        this.data = data;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node[] org = new Node[n];

        for (int i = 0; i < n; i++)
            org[i] = new Node(sc.nextInt());

        int[] rand = new int[n];
        for (int i = 0; i < n; i++)
            rand[i] = sc.nextInt();

        for (int i = 0; i < n - 1; i++)
            org[i].next = org[i + 1];

        for (int i = 0; i < n; i++)
            if (rand[i] != -1)
                org[i].random = org[rand[i]];

        HashMap<Node, Node> map = new HashMap<>();

        for (Node node : org)
            map.put(node, new Node(node.data));

        for (Node node : org) {
            map.get(node).next =
                    node.next == null ? null : map.get(node.next);
            map.get(node).random =
                    node.random == null ? null : map.get(node.random);
        }

        Node[] clone = new Node[n];
        for (int i = 0; i < n; i++)
            clone[i] = map.get(org[i]);

        HashMap<Node, Integer> idx = new HashMap<>();
        for (int i = 0; i < n; i++)
            idx.put(clone[i], i);

        for (Node node : clone)
            System.out.println(node.data + " " +
                    (node.random == null ? -1 : idx.get(node.random)));
    }
}
