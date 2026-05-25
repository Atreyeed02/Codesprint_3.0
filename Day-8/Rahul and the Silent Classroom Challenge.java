/*
Question: Rahul and the Silent Classroom Challenge

Problem Statement:
Rahul’s professor has a very strange attendance rule during coding lectures.
Every student’s roll number is checked in binary form before class begins.

Rules:
- If the binary representation of a roll number contains an odd number of ON bits (1s),
  the student must answer questions in class today.
- Otherwise, the student is considered SAFE.

Print:
- "ANSWER" if count of set bits is odd
- "SAFE" if count of set bits is even

Input Format:
- First line contains integer N
- Second line contains N space-separated integers

Output Format:
For every roll number print:
- ANSWER
or
- SAFE

Example:

Input:
4
3 5 8 7

Output:
SAFE
SAFE
ANSWER
ANSWER

Explanation:
3  -> 11   -> 2 ON bits -> SAFE
5  -> 101  -> 2 ON bits -> SAFE
8  -> 1000 -> 1 ON bit  -> ANSWER
7  -> 111  -> 3 ON bits -> ANSWER
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            int count = Integer.bitCount(num);

            if (count % 2 == 1) {
                System.out.println("ANSWER");
            } else {
                System.out.println("SAFE");
            }
        }

        sc.close();
    }
}
