/*
Problem Statement
Aroosa is preparing for placements and tracks the number of hours she spends studying every day.

She believes she is entering a burnout zone if there exists a continuous streak
of exactly K consecutive days such that:
1. The total study hours during those K days is at least X.
2. She studied on every day of that streak (no day has 0 hours).

Help Aroosa determine whether such a streak exists.

Input Format
The first line contains three integers:
N → number of days
K → required streak length
X → minimum total study hours

The second line contains N integers representing study hours for each day.

Output Format
Print:
YES -> if such a streak exists
NO  -> otherwise

Example
Input:
7 3 15
4 5 7 2 8 1 9

Output:
YES

Explanation:
The first streak of 3 consecutive days is:
4 5 7

Total = 4 + 5 + 7 = 16

Since 16 >= 15 and all days are non-zero,
a valid burnout streak exists.

Constraints
1 ≤ N ≤ 10^5
1 ≤ K ≤ N
0 ≤ arr[i] ≤ 10^4
1 ≤ X ≤ 10^9
*/

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int X = sc.nextInt();

        int[] arr = new int[N];

        // Input array
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;

        // First window sum
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }

        boolean found = true;

        // Check zero in first window
        for (int i = 0; i < K; i++) {
            if (arr[i] == 0) {
                found = false;
                break;
            }
        }

        // Check first window
        if (sum >= X && found) {
            System.out.println("YES");
            return;
        }

        // Sliding window
        for (int i = K; i < N; i++) {

            // Update window sum
            sum = sum - arr[i - K] + arr[i];

            found = true;

            // Check if current window contains 0
            for (int j = i - K + 1; j <= i; j++) {
                if (arr[j] == 0) {
                    found = false;
                    break;
                }
            }

            // Valid streak found
            if (sum >= X && found) {
                System.out.println("YES");
                return;
            }
        }

        // No valid streak
        System.out.println("NO");
    }
}
