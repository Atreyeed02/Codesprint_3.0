/*
Problem: Detect Loop in Linked List

Swastik is tracking the route of a campus shuttle bus. Each stop points to the next stop,
forming a linked list.

One day, due to a routing bug, the shuttle starts going back to a previously visited stop
instead of moving forward.

If this happens, the shuttle will keep circling forever.

Help Swastik determine whether the route contains a loop.

Input Format:
- First line contains N, the number of stops.
- Second line contains N integers representing the linked list nodes.
- Third line contains POS.
- If POS = -1, the last node points to NULL.
- Otherwise, the last node points to the node at index POS (0-indexed).

Output Format:
- Print "YES" if the linked list contains a loop.
- Otherwise print "NO".

Example:
Input:
5
10 20 30 40 50
1

Output:
YES

Explanation:
10 -> 20 -> 30 -> 40 -> 50
      ^              |
      |______________|

The last node points back to the node at index 1, creating a cycle.

Approach:
- Use Floyd's Cycle Detection Algorithm (Tortoise & Hare).
- Move slow pointer by 1 step and fast pointer by 2 steps.
- If they meet, a cycle exists.
- If fast reaches NULL, no cycle exists.

Time Complexity: O(N)
Space Complexity: O(1)
*/

import java.util.*;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
    }
}

public class Main{

    static boolean hasCycle(Node head){
        Node slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node[] nodes = new Node[n];

        for(int i = 0; i < n; i++){
            nodes[i] = new Node(sc.nextInt());
        }

        for(int i = 0; i < n - 1; i++){
            nodes[i].next = nodes[i + 1];
        }

        int pos = sc.nextInt();

        if(pos != -1){
            nodes[n - 1].next = nodes[pos];
        }

        System.out.println(hasCycle(nodes[0]) ? "YES" : "NO");
    }
}
