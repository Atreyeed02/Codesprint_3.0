/*
Problem: Boundary Traversal of Binary Tree (Anti-Clockwise)

Description:
Given the level-order traversal of a binary tree (-1 represents null),
print its boundary traversal in anti-clockwise order.

Boundary includes:
1. Root
2. Left boundary (excluding leaf nodes)
3. All leaf nodes (left to right)
4. Right boundary (excluding leaf nodes, in reverse)

Input:
First line: N
Second line: N integers (level-order traversal)

Output:
Print the anti-clockwise boundary traversal.

Example:
Input:
7
1 2 3 4 5 -1 -1

Output:
1 2 4 5 3

Time Complexity: O(N)
Space Complexity: O(N)
*/

import java.util.*;

class Node {
    int val;
    Node left, right;

    Node(int v) {
        val = v;
    }
}

public class Main {

    static boolean leaf(Node n) {
        return n != null && n.left == null && n.right == null;
    }

    static Node build(int[] a) {
        if (a.length == 0 || a[0] == -1)
            return null;

        Queue<Node> q = new LinkedList<>();
        Node root = new Node(a[0]);
        q.add(root);

        int i = 1;

        while (!q.isEmpty() && i < a.length) {
            Node cur = q.poll();

            if (i < a.length && a[i] != -1) {
                cur.left = new Node(a[i]);
                q.add(cur.left);
            }
            i++;

            if (i < a.length && a[i] != -1) {
                cur.right = new Node(a[i]);
                q.add(cur.right);
            }
            i++;
        }

        return root;
    }

    static void left(Node r, List<Integer> ans) {
        while (r != null) {
            if (!leaf(r))
                ans.add(r.val);
            r = (r.left != null) ? r.left : r.right;
        }
    }

    static void leaves(Node r, List<Integer> ans) {
        if (r == null)
            return;

        if (leaf(r)) {
            ans.add(r.val);
            return;
        }

        leaves(r.left, ans);
        leaves(r.right, ans);
    }

    static void right(Node r, List<Integer> ans) {
        Stack<Integer> st = new Stack<>();

        while (r != null) {
            if (!leaf(r))
                st.push(r.val);

            r = (r.right != null) ? r.right : r.left;
        }

        while (!st.isEmpty())
            ans.add(st.pop());
    }

    static List<Integer> boundaryTraversal(Node root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        if (!leaf(root))
            ans.add(root.val);

        left(root.left, ans);
        leaves(root, ans);
        right(root.right, ans);

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        Node root = build(a);

        List<Integer> ans = boundaryTraversal(root);

        for (int x : ans)
            System.out.print(x + " ");
    }
}
