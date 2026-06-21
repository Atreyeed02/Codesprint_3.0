/*
Problem: Scholarship Eligibility

A student qualifies for a scholarship only if the sum of all scores
strictly smaller than their score is at least K.

Input:
N K
N scores

Output:
Number of students who qualify.

Approach:
1. Sort the scores.
2. Build prefix sums.
3. For each group of equal scores:
   - prefix[i] gives the sum of all strictly smaller scores.
   - If prefix[i] >= K, all students in that group qualify.
4. Count eligible students.

Time Complexity: O(N log N)
Space Complexity: O(N)
*/

import java.util.*;

public class ScholarshipEligibility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long K = sc.nextLong();

        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);

        long[] prefix = new long[N + 1];

        for (int i = 0; i < N; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        int count = 0;
        int i = 0;

        while (i < N) {
            int j = i;

            while (j < N && arr[j] == arr[i]) {
                j++;
            }

            long smallerSum = prefix[i];

            if (smallerSum >= K) {
                count += (j - i);
            }

            i = j;
        }

        System.out.println(count);
    }
}
