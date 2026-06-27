/*
Problem: Diagonal Zigzag Traversal of a Matrix

Description:
Given an M x N matrix, print its elements in a zigzag diagonal order.
Elements on the same diagonal have the same value of (row + column).

Traversal:
• Even diagonals → traverse in reverse order (up-right direction)
• Odd diagonals → traverse in normal order (down-left direction)

Input:
First line: M N
Next M lines: N integers each

Output:
Print the zigzag diagonal traversal.

Example:
Input:
3 3
1 2 3
4 5 6
7 8 9

Output:
1 2 4 7 5 3 6 8 9

Time Complexity: O(M × N)
Space Complexity: O(M × N)
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        ArrayList<Integer>[] diag = new ArrayList[M + N - 1];
        for (int i = 0; i < diag.length; i++)
            diag[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                diag[i + j].add(sc.nextInt());
            }
        }

        boolean first = true;

        for (int d = 0; d < diag.length; d++) {
            if (d % 2 == 0) {
                for (int i = diag[d].size() - 1; i >= 0; i--) {
                    if (!first) System.out.print(" ");
                    System.out.print(diag[d].get(i));
                    first = false;
                }
            } else {
                for (int x : diag[d]) {
                    if (!first) System.out.print(" ");
                    System.out.print(x);
                    first = false;
                }
            }
        }
    }
}
