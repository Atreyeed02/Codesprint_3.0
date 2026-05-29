/*
Problem Statement:
Hritika was working in her college science lab on a special
temperature balancing machine.

The machine recorded both:
- negative temperatures
- positive temperatures

To stabilize the system, Hritika needed to find:
Two temperature values whose sum is closest to zero.

Input:
6
-8 -4 -1 2 10 6

Output:
-1 2
*/

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int ans1 = 0;
        int ans2 = 0;

        int min = Integer.MAX_VALUE;

        int l = 0, r = n - 1;

        while (l < r) {

            int sum = arr[l] + arr[r];

            if (Math.abs(sum) < min) {

                min = Math.abs(sum);

                ans1 = arr[l];
                ans2 = arr[r];
            }

            if (sum < 0) {
                l++;
            } else {
                r--;
            }
        }

        System.out.println(ans1 + " " + ans2);
    }
}
