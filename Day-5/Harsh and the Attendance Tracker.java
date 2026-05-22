// Harsh and the Attendance Tracker
//
// Problem Statement:
// Harsh is helping his professor track attendance during a workshop.
//
// Students enter the seminar hall batch by batch.
// arr[i] represents the number of students entering in batch i.
//
// The hall becomes full once the total number of students
// becomes strictly greater than X.
//
// Find the first batch index where the hall becomes full.
// If it never becomes full, print -1.
//
// Input Format:
// First line contains N and X
// Second line contains N space-separated integers
//
// Output Format:
// Print the first batch index where total students exceed X,
// otherwise print -1.

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int sum = 0;
        int ans = -1;

        for(int i = 0; i < n; i++) {

            sum += sc.nextInt();

            if(sum > x && ans == -1) {
                ans = i;
            }
        }

        System.out.println(ans);
    }
}
