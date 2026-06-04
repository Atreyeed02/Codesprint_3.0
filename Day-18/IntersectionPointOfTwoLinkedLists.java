/*
Problem: Intersection Point of Two Linked Lists

Inside the college library, bookshelves were connected through hidden smart paths.
Some shelves also had shortcut portals connecting to distant shelves.

Two different library maps eventually merge into the same pathway.

Each library map is represented as a linked list, and both lists may intersect at a common shelf.

Your task is to find the first shelf where both paths intersect.

If the two paths do not intersect, print -1.

Input Format:
- First line contains N, the number of nodes in the first linked list.
- Second line contains N integers representing the first linked list.
- Third line contains M, the number of nodes in the second linked list.
- Fourth line contains M integers representing the second linked list.
- Fifth line contains X, the value where the intersection begins.
- If no intersection exists, X = -1.

Output Format:
- Print the value of the first common node where both linked lists intersect.
- If no intersection exists, print -1.

Example:
Input:
5
1 2 3 8 10
4
5 6 8 10
8

Output:
8

Approach:
- Build the first linked list and store its nodes in a HashMap.
- While building the second linked list, connect it to the node having value X.
- Use the two-pointer technique to find the intersection node.
- If pointers meet, return the node value; otherwise return -1.

Time Complexity: O(N + M)
Space Complexity: O(N)
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

    static int intersection(Node h1, Node h2){
        Node p1 = h1, p2 = h2;

        while(p1 != p2){
            p1 = (p1 == null) ? h2 : p1.next;
            p2 = (p2 == null) ? h1 : p2.next;
        }

        return p1 == null ? -1 : p1.data;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] b = new int[m];

        for(int i = 0; i < m; i++){
            b[i] = sc.nextInt();
        }

        int x = sc.nextInt();

        HashMap<Integer, Node> map = new HashMap<>();

        Node h1 = new Node(a[0]), t = h1;
        map.put(a[0], h1);

        for(int i = 1; i < n; i++){
            t.next = new Node(a[i]);
            t = t.next;
            map.put(a[i], t);
        }

        Node h2 = new Node(b[0]);
        t = h2;

        for(int i = 1; i < m; i++){
            if(b[i] == x && x != -1){
                t.next = map.get(x);
                break;
            }

            t.next = new Node(b[i]);
            t = t.next;
        }

        System.out.println(intersection(h1, h2));
    }
}
