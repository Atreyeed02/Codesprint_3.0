/*
Problem Statement:
In the futuristic kingdom of Nexora, Zara discovered a magical memory chain
storing encrypted data blocks. Each block is connected to both its next and
previous blocks using a doubly linked structure.

During a system reboot, the chain must be rotated to the right by K positions.

A right rotation means:
- The last node becomes the new head.
- Remaining nodes shift one position ahead.
- Both next and prev links must be maintained.

Input Format:
N K
N space-separated integers

Output Format:
Print the doubly linked list after rotation.

Example:
Input:
5 2
1 2 3 4 5

Output:
4 5 1 2 3
*/

import java.util.*;

public class RotateDoublyLinkedList {

    static class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long k = sc.nextLong();

        Node head = null;
        Node tail = null;

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();

            Node newNode = new Node(val);

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }

        if (n == 0 || n == 1 || k == 0) {
            printList(head);
            return;
        }

        k %= n;

        if (k == 0) {
            printList(head);
            return;
        }

        // Make list circular
        tail.next = head;
        head.prev = tail;

        int steps = n - (int) k;

        Node newTail = head;
        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }

        Node newHead = newTail.next;

        // Break circular links
        newTail.next = null;
        newHead.prev = null;

        printList(newHead);

        sc.close();
    }

    static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" ");
            }
            temp = temp.next;
        }
    }
}
