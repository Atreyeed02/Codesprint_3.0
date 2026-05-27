import java.util.*;

/*
====================================================
Question 2: QuickBite Restaurant Recommendation Engine
====================================================

Problem Statement:
QuickBite wants to display restaurant names matching
a given prefix in lexicographical order.

Input Format:
- First line contains integer N
- Next N lines contain restaurant names
- Last line contains prefix

Output Format:
- Print all matching restaurant names in sorted order

Example Input:
7
pizzapalace
pizzahub
pizzaworld
burgervilla
pizzacity
pastahouse
pizzaexpress
pizza

Example Output:
pizzacity
pizzaexpress
pizzahub
pizzapalace
pizzaworld

----------------------------------------------------
Explanation:
----------------------------------------------------

1. Store all restaurant names in an array.

2. Sort the array using:
   Arrays.sort(arr);

3. Traverse every restaurant name.

4. Use:
   startsWith(prefix)

   to check whether the restaurant name starts
   with the given prefix.

5. Print matching restaurant names.

----------------------------------------------------
Time Complexity:
----------------------------------------------------

Sorting:
O(N log N)

Checking Prefix:
O(N)

Total:
O(N log N)

====================================================
*/

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of restaurants
        int n = sc.nextInt();

        // Array to store restaurant names
        String[] arr = new String[n];

        // Input restaurant names
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        // Input prefix
        String prefix = sc.next();

        // Sort names lexicographically
        Arrays.sort(arr);

        // Traverse and check prefix
        for (String s : arr) {

            // Check prefix
            if (s.startsWith(prefix)) {

                // Print matching restaurant
                System.out.println(s);
            }
        }
    }
}
