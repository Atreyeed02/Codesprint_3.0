#include <bits/stdc++.h>
using namespace std;

/*
Problem Statement

During an adventure in an ancient kingdom, Jagrit discovered a magical pathway filled with glowing energy stones. Each stone had a number written on it.

However, some stones had lost their power and showed the number 0.

The kingdom’s wizard gave Jagrit a task:

“Move all the powerless stones (0s) to the end of the pathway while keeping the order of the active stones exactly the same.”

Help Jagrit rearrange the stones correctly.

Input Format
- The first line contains an integer N — the number of stones.
- The second line contains N space-separated integers representing the stones.

Output Format
Print the updated arrangement after moving all zeroes to the end.

Constraints
1 ≤ N ≤ 10^5
-10^9 ≤ elements ≤ 10^9
*/

int main() {

    int n;
    cin >> n;

    vector<int> arr(n);

    for(int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    int j = 0;

    for(int i = 0; i < n; i++) {

        if(arr[i] != 0) {

            swap(arr[i], arr[j]);

            j++;
        }
    }

    for(int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }

    return 0;
}
