/*
Problem: Recover Binary Search Tree (Morris Traversal)

Approach:
1. Perform Morris Inorder Traversal (O(1) extra space).
2. Detect the two misplaced nodes by checking where inorder order is violated.
3. Swap their values.
4. Print the corrected tree in level-order.

Time Complexity: O(N)
Space Complexity: O(1) (excluding output queue)
*/

import java.util.*;

class Main {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    static TreeNode first, second, prev;

    static TreeNode build(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;

        while (!q.isEmpty() && i < arr.length) {
            TreeNode cur = q.poll();

            if (i < arr.length && arr[i] != -1) {
                cur.left = new TreeNode(arr[i]);
                q.offer(cur.left);
            }
            i++;

            if (i < arr.length && arr[i] != -1) {
                cur.right = new TreeNode(arr[i]);
                q.offer(cur.right);
            }
            i++;
        }
        return root;
    }

    static void check(TreeNode cur) {
        if (prev != null && prev.val > cur.val) {
            if (first == null) first = prev;
            second = cur;
        }
        prev = cur;
    }

    static void recover(TreeNode root) {
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left == null) {
                check(cur);
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;

                while (pre.right != null && pre.right != cur)
                    pre = pre.right;

                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    check(cur);
                    cur = cur.right;
                }
            }
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    static void print(TreeNode root, int n) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        for (int i = 0; i < n; i++) {
            TreeNode cur = q.poll();

            if (cur == null)
                System.out.print("-1");
            else {
                System.out.print(cur.val);
                q.offer(cur.left);
                q.offer(cur.right);
            }

            if (i != n - 1)
                System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        TreeNode root = build(arr);

        recover(root);

        print(root, n);
    }
}
