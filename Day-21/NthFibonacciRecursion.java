/*
Problem: Nth Fibonacci Number Using Recursion

Aryan was preparing for a coding competition and wanted to calculate
the N-th Fibonacci number using recursion.

Fibonacci Sequence:

F(0) = 0
F(1) = 1
F(N) = F(N-1) + F(N-2)

Input:
7

Output:
13

Explanation:
Sequence:
0 1 1 2 3 5 8 13

The 7th Fibonacci number is 13.

Time Complexity: O(2^N)
Space Complexity: O(N)
*/

import java.util.*;

public class NthFibonacciRecursion {

    static int fibo(int n) {

        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        return fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(fibo(n));
    }
}
