/*
Problem Statement

Riya is preparing the merit list of a national scholarship exam.

The student marks arrive in random order.
She first sorts all marks in descending order to create the rank list.
After that, several students ask for their rank based on their score.

Help Riya find the rank of each queried score.
If the score does not exist, print "No Rank".

Input Format
First line contains integer N.
Second line contains N student marks.
Third line contains integer Q.
Next Q lines contain a score to search.

Output Format
For every query print:
Rank R
or
No Rank

Example

Input:
6
450 390 500 470 420 350
3
470
350
480

Output:
Rank 2
Rank 6
No Rank
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Integer[] marks = new Integer[n];

        for (int i = 0; i < n; i++) {
            marks[i] = sc.nextInt();
        }

        Arrays.sort(marks, Collections.reverseOrder());

        HashMap<Integer, Integer> rankMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!rankMap.containsKey(marks[i])) {
                rankMap.put(marks[i], i + 1);
            }
        }

        int q = sc.nextInt();

        while (q-- > 0) {
            int score = sc.nextInt();

            if (rankMap.containsKey(score)) {
                System.out.println("Rank " + rankMap.get(score));
            } else {
                System.out.println("No Rank");
            }
        }

        sc.close();
    }
}
