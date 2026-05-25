/*
Question: Prema and the Fest Bracelet Scanner

Problem Statement:
During the annual college fest, every student entering the concert arena
receives a digital bracelet with a unique numeric code.

Prema is managing a smart scanner system that continuously combines
all scanned bracelet IDs using XOR operation.

Rules:
- If the final XOR value becomes 0, the crowd is considered BALANCED.
- Otherwise, the crowd is considered UNBALANCED.

Whenever two identical bracelet IDs are scanned,
they cancel each other out because:
x ^ x = 0

Input Format:
- First line contains integer N
- Second line contains N space-separated integers

Output Format:
Print:
- BALANCED
or
- UNBALANCED

Example:

Input:
6
4 1 1 7 7 4

Output:
BALANCED

Explanation:
4 ^ 1 ^ 1 ^ 7 ^ 7 ^ 4 = 0
All duplicate bracelet IDs cancel each other out.
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int xor = 0;

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            xor = xor ^ num;
        }

        if (xor == 0) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }

        sc.close();
    }
}
