/*
Problem: K-th Largest Element in a Binary Search Tree

Problem Statement:
The Coding Club at Avirup's university maintains the rankings of all
participants in a Binary Search Tree (BST) based on their performance scores.

Every participant has a unique score, and the scores are inserted into the BST
in the given order.

Find the K-th largest score in the BST.

Input Format:
- First line: Integer N (number of nodes)
- Second line: N distinct integers (order of insertion into BST)
- Third line: Integer K

Output Format:
- Print the K-th largest element.

Example:
Input:
7
50 30 70 20 40 60 80
3

Output:
60

Explanation:
BST:
        50
       /  \
     30    70
    / \   / \
  20 40 60 80

Descending Order:
80 70 60 50 40 30 20

The 3rd largest element is 60.

Approach:
1. Construct the BST using the given insertion order.
2. Perform Reverse Inorder Traversal (Right → Root → Left).
3. Count visited nodes.
4. The K-th visited node is the K-th largest element.

Time Complexity:
- Average: O(N log N)
- Worst: O(N²) for skewed BST

Space Complexity:
- O(H), where H is the height of the BST.
*/

import java.util.*;

public class Main {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static int count = 0;
    static int ans = 0;

    static Node insert(Node root, int val) {
        if (root == null)
            return new Node(val);

        if (val < root.data)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }

    static void reverseInorder(Node root, int k) {
        if (root == null || count >= k)
            return;

        reverseInorder(root.right, k);

        count++;
        if (count == k) {
            ans = root.data;
            return;
        }

        reverseInorder(root.left, k);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Node root = null;

        for (int i = 0; i < N; i++) {
            int val = sc.nextInt();
            root = insert(root, val);
        }

        int K = sc.nextInt();

        reverseInorder(root, K);

        System.out.println(ans);

        sc.close();
    }
}
