/*
Problem: Maximum Banner Display Area

Ridhima wants to hang a giant fabric banner between any two banner stands.
The area formed depends on:
1. The shorter of the two stands.
2. The distance between them.

Area = min(height[i], height[j]) * (j - i)

Input:
N
N space-separated integers representing heights

Output:
Maximum possible area.

Example:
Input:
9
1 8 6 2 5 4 8 3 7

Output:
49

Explanation:
Choose heights 8 and 7.
Distance = 7
Area = min(8,7) * 7 = 49

Approach:
- Use two pointers:
  left = 0, right = N-1
- Calculate area at each step.
- Move the pointer with the smaller height inward.
- Keep track of the maximum area.

Time Complexity: O(N)
Space Complexity: O(1)
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] height = new int[n];

        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        int left = 0;
        int right = n - 1;
        long maxArea = 0;

        while (left < right) {
            long area = (long) Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(maxArea);
    }
}
