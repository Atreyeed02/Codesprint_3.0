/*
Problem: Tower of Hanoi

Move N plates from Source (A) to Destination (C)
using Auxiliary (B).

Rules:
1. Only one plate can be moved at a time.
2. A larger plate cannot be placed on a smaller plate.
3. Use the auxiliary platform when needed.

Approach:
1. Move N-1 plates from Source to Auxiliary.
2. Move the largest plate to Destination.
3. Move N-1 plates from Auxiliary to Destination.

Time Complexity: O(2^N)
Space Complexity: O(N)
*/

import java.util.*;

public class Main {

    static int moves = 0;

    static void hanoi(int n, char src, char aux, char dest) {

        if (n == 1) {
            System.out.println(
                    "Move plate 1 from " + src + " to " + dest);
            moves++;
            return;
        }

        hanoi(n - 1, src, dest, aux);

        System.out.println(
                "Move plate " + n + " from " + src + " to " + dest);
        moves++;

        hanoi(n - 1, aux, src, dest);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        hanoi(n, 'A', 'B', 'C');

        System.out.println("Total Moves = " + moves);
    }
}
