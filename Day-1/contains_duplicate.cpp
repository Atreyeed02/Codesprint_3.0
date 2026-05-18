#include <bits/stdc++.h>
using namespace std;

/*
Problem Statement

After the final exams were over, Ritrisha received her marks for all subjects.

While checking the report card, she became curious to know something interesting.

She wondered:
“Did I score the same marks in any two subjects?”

Your task is to help Ritrisha determine whether there are any duplicate marks in her report card.

Input Format
- The first line contains an integer N — the number of subjects.
- The second line contains N space-separated integers representing the marks obtained in each subject.

Output Format
- Print "YES" if any duplicate marks exist.
- Otherwise, print "NO".

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

    sort(arr.begin(), arr.end());

    bool found = false;

    for(int i = 1; i < n; i++) {

        if(arr[i] == arr[i - 1]) {
            found = true;
            break;
        }
    }

    if(found) {
        cout << "YES";
    }
    else {
        cout << "NO";
    }

    return 0;
}
