/*
Problem Statement:
In a secret coding lab, Rishav was experimenting with a special data structure
called an XOR Linked List to reduce memory usage.

Instead of storing separate next and previous pointers,
each node stores the XOR of both addresses.

One day, the traversal system failed, and Rishav could no longer verify
whether the list was being traversed correctly.

Your task is to help Rishav print all the nodes of the XOR Linked List
from left to right.

Input Format:
The first line contains an integer N — the number of nodes in the XOR Linked List.
The second line contains N integers representing the values stored in the nodes.

Output Format:
Print all node values in their traversal order from left to right.
Values should be separated by a single space.

Example:
Input:
5
11 22 33 44 55

Output:
11 22 33 44 55

Explanation:
The XOR Linked List contains the nodes:
11 ↔ 22 ↔ 33 ↔ 44 ↔ 55

Traversing from the head node to the tail node visits the values in the order:
11 22 33 44 55.
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print(sc.nextInt());

            if (i < n - 1) {
                System.out.print(" ");
            }
        }

        sc.close();
    }
}
