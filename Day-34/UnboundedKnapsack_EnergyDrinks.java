/*
Problem: Maximum Energy Drinks (Unbounded Knapsack)

Problem Statement:
Govind is preparing for a marathon gaming tournament. To stay energized,
he can buy different types of energy drinks.

He has X coins to spend.

There are N types of energy drinks:
- cost[i]   -> cost of the drink
- energy[i] -> energy gained from the drink

The store has an unlimited supply of every drink, so each drink can be
purchased any number of times.

Find the maximum energy Govind can obtain using at most X coins.

Input Format:
N X

cost[0] energy[0]
cost[1] energy[1]
...
cost[N-1] energy[N-1]

Example:
Input:
3 7
2 10
3 14
5 25

Output:
35

Explanation:
Choose Drink 3 (cost=5, energy=25)
and Drink 1 (cost=2, energy=10)

Total Cost = 7
Total Energy = 35

Approach:
This is an Unbounded Knapsack problem because each drink can be chosen
multiple times.

Let:
dp[i] = maximum energy obtainable using exactly i coins

Transition:
dp[i] = max(dp[i], dp[i - cost[j]] + energy[j])

Time Complexity: O(N * X)
Space Complexity: O(X)
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] cost = new int[n];
        int[] energy = new int[n];

        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
            energy[i] = sc.nextInt();
        }

        int[] dp = new int[x + 1];

        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < n; j++) {
                if (cost[j] <= i) {
                    dp[i] = Math.max(dp[i],
                                     dp[i - cost[j]] + energy[j]);
                }
            }
        }

        System.out.println(dp[x]);
    }
}
