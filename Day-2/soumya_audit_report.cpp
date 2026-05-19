#include <bits/stdc++.h>
using namespace std;

/*
Problem Statement

Soumya is reviewing an audit report containing several financial figures.

To identify important trends, she needs to find the second largest distinct value from the report.

Help Soumya determine the second largest distinct element in the list.

Input Format
- The first line contains an integer N — number of elements.
- The second line contains N space-separated integers.

Output Format
Print the second largest distinct element.

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

    int largest = INT_MIN;
    int secondLargest = INT_MIN;

    for(int i = 0; i < n; i++) {

        if(arr[i] > largest) {

            secondLargest = largest;
            largest = arr[i];
        }

        else if(arr[i] > secondLargest && arr[i] != largest) {

            secondLargest = arr[i];
        }
    }

    cout << secondLargest;

    return 0;
}
