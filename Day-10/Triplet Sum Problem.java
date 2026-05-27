import java.util.*;

/*
====================================================
Question 1: Triplet Sum Problem
====================================================

Problem Statement:
Given an array of integers and an integer K,
check whether there exists a triplet whose sum
is equal to K.

Input Format:
- First line contains integer N
- Second line contains N integers
- Third line contains integer K

Output Format:
- Print "YES" if triplet exists
- Otherwise print "NO"

Example Input:
6
1 4 45 6 10 8
22

Example Output:
YES

----------------------------------------------------
Explanation:
----------------------------------------------------

1. Sort the array.

2. Fix one element using a loop.

3. Use two pointers:
   - left = i + 1
   - right = n - 1

4. Calculate:
   sum = arr[i] + arr[left] + arr[right]

5. If:
   - sum == k → triplet found
   - sum < k  → move left++
   - sum > k  → move right--

----------------------------------------------------
Time Complexity:
----------------------------------------------------

O(N²)

----------------------------------------------------
Space Complexity:
----------------------------------------------------

O(1)

====================================================
*/

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Target sum
        int k = sc.nextInt();

        // Sort array
        Arrays.sort(arr);

        boolean found = false;

        // Fix one element
        for (int i = 0; i < n - 2; i++) {

            int left = i + 1;
            int right = n - 1;

            // Two pointer approach
            while (left < right) {

                int sum = arr[i] + arr[left] + arr[right];

                if (sum == k) {
                    found = true;
                    break;
                }

                // Move left pointer
                if (sum < k) {
                    left++;
                }

                // Move right pointer
                else {
                    right--;
                }
            }

            if (found) {
                break;
            }
        }

        // Print result
        if (found) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
