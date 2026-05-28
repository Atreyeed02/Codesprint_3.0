/*
Problem: Sitanshu and the College Club Lineup

During the annual fest, students belong to:
0 -> Music Club
1 -> Dance Club
2 -> Photography Club

The students are standing randomly.

Arrange them so that:
- all 0s come first
- then all 1s
- then all 2s

Solve it in linear time using Two Pointers
(Dutch National Flag Algorithm).

Input Format:
- First line contains integer N
- Second line contains N integers (0, 1, 2)

Output Format:
Print the sorted array.

Example Input:
6
2 0 2 1 1 0

Example Output:
0 0 1 1 2 2
*/
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        int zero = 0;
        int one = 0;
        int two = 0;

        // Input + Count
        for (int i = 0; i < n; i++) {

            arr[i] = sc.nextInt();

            if (arr[i] == 0)
                zero++;

            else if (arr[i] == 1)
                one++;

            else
                two++;
        }

        int index = 0;

        // Fill 0s
        while (zero-- > 0) {
            arr[index++] = 0;
        }

        // Fill 1s
        while (one-- > 0) {
            arr[index++] = 1;
        }

        // Fill 2s
        while (two-- > 0) {
            arr[index++] = 2;
        }

        // Output
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
