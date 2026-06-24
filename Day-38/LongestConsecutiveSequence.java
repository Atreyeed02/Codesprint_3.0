/*
Problem: Longest Consecutive Sequence

Mehak receives machinery with serial numbers in random order.
She needs to find the length of the longest sequence of
consecutive serial numbers.

The solution must run in O(N) time.

Input:
6
100 4 200 1 3 2

Output:
4

Explanation:
The longest consecutive sequence is:
1, 2, 3, 4

Approach:
- Store all numbers in a HashSet.
- A number starts a sequence if (num - 1) is absent.
- Count consecutive numbers from each starting point.
- Track the maximum length found.
*/

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        int longest = 0;

        for (int num : set) {

            if (!set.contains(num - 1)) {

                int curr = num;
                int len = 1;

                while (set.contains(curr + 1)) {
                    curr++;
                    len++;
                }

                longest = Math.max(longest, len);
            }
        }

        System.out.println(longest);

        sc.close();
    }
}
