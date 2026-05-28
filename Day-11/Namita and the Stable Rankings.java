/*
Problem: Namita and the Stable Rankings

Namita is managing a leaderboard for her college coding contest.
Each participant has:
- a name
- a score

The leaderboard must be sorted in increasing order of scores.

Important Rule:
If two participants have the same score,
their original relative order must remain unchanged.

Namita uses a stable sorting technique:
- compare adjacent participants
- swap only if leftScore > rightScore

Input Format:
- First line contains integer N
- Next N lines contain: Name Score

Output Format:
Print the stable sorted leaderboard.

Example Input:
5
Aman 50
Riya 30
Kabir 50
Neha 20
Aryan 30

Example Output:
Neha 20
Riya 30
Aryan 30
Aman 50
Kabir 50
*/

import java.util.*;

public class Main {

    static class Participant {
        String name;
        int score;

        Participant(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Participant[] arr = new Participant[n];

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score = sc.nextInt();

            arr[i] = new Participant(name, score);
        }

        // Stable Bubble Sort
        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                // Swap only when left score is greater
                if (arr[j].score > arr[j + 1].score) {

                    Participant temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // Output
        for (Participant p : arr) {
            System.out.println(p.name + " " + p.score);
        }
    }
}
