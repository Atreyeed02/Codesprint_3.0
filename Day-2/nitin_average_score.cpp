#include <bits/stdc++.h>
using namespace std;

/*
Problem Statement

Nitin recently received the scores of all students in his class test.

He became curious to know:
“How many students scored strictly greater than the average score of the class?”

Help Nitin find the count of students whose marks are greater than the average.

Input Format
- The first line contains an integer N — number of students.
- The second line contains N space-separated integers representing the scores.

Output Format
Print the count of scores strictly greater than the average.

Constraints
1 ≤ N ≤ 10^5
0 ≤ scores ≤ 10^9
*/

int main() {

    int n;
    cin >> n;

    vector<int> arr(n);

    int sum = 0;

    for(int i = 0; i < n; i++) {
        cin >> arr[i];
        sum += arr[i];
    }

    double avg = (double)sum / n;

    int count = 0;

    for(int i = 0; i < n; i++) {

        if(arr[i] > avg) {
            count++;
        }
    }

    cout << count;

    return 0;
}
