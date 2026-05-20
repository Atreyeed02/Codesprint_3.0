import java.util.*;

/*
Problem Statement

Rohan is designing a smart alarm system where each alarm code is represented by a sequence of integers.

The system considers a code VALID if no two adjacent elements are equal.

Otherwise, the code becomes INVALID and the system should report the first index (0-indexed) where consecutive repetition occurs.

Help Rohan validate the alarm code.

Input Format
- The first line contains an integer N — number of alarm codes.
- The second line contains N space-separated integers.

Output Format
- Print "VALID" if no two adjacent elements are equal.
- Otherwise, print "INVALID index"

where index is the first position (0-indexed) where repetition occurs.

Example

Input:
5
1 2 2 3 4

Output:
INVALID 2
*/

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] codes = new int[n];

        for(int i = 0; i < n; i++) {
            codes[i] = sc.nextInt();
        }

        for(int i = 1; i < n; i++) {

            if(codes[i] == codes[i - 1]) {

                System.out.println("INVALID " + i);
                return;
            }
        }

        System.out.println("VALID");
    }
}
