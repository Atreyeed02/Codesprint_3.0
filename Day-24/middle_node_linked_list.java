/*
Problem: Middle Node of a Linked List

Rahil is designing a treasure hunt game where clues are connected
one after another, forming a singly linked list.

The middle clue reveals the location of the hidden treasure chest.

Find the value of the middle node.
If there are two middle nodes, return the second middle node.

Input:
N
N space-separated integers representing node values.

Output:
Value of the middle node.

Example:
Input:
6
1 2 3 4 5 6

Output:
4

Explanation:
The linked list is:
1 -> 2 -> 3 -> 4 -> 5 -> 6

The two middle nodes are 3 and 4.
Return the second middle node: 4.

Approach:
Fast and Slow Pointer Technique

Time Complexity: O(N)
Space Complexity: O(1)
*/

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Node head = null;
        Node tail = null;

        for (int i = 0; i < N; i++) {
            int val = sc.nextInt();

            Node newNode = new Node(val);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println(slow.data);
    }
}
