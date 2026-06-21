/*
Problem: Balanced Package Pairs

A pair of packages is balanced if their weights sum to X.

Count the number of UNIQUE pairs.
Two pairs are considered the same if they contain
the same pair of weights regardless of positions.

Input:
N X
N package weights

Output:
Number of unique balanced pairs.

Approach:
1. Sort the array.
2. Use two pointers:
   - left at beginning
   - right at end
3. If sum == X:
   - Count the pair.
   - Skip all duplicates of both values.
4. If sum < X, move left.
5. If sum > X, move right.

Time Complexity: O(N log N)
Space Complexity: O(1)
*/

import java.util.*;

public class BalancedPackagePairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long X = sc.nextLong();

        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;
        int count = 0;

        while (left < right) {
            long sum = arr[left] + arr[right];

            if (sum == X) {
                count++;

                long leftVal = arr[left];
                long rightVal = arr[right];

                while (left < right && arr[left] == leftVal) {
                    left++;
                }

                while (left < right && arr[right] == rightVal) {
                    right--;
                }
            } else if (sum < X) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(count);
    }
}
