// ======================================================
// Question 1: Firewall Pattern
// ======================================================

/*

Problem Statement:
Souvik is building a secure digital firewall for CodeSprint 3.0.
To test the firewall strength, he designed a special numeric pattern.

The firewall follows these rules:

1. Numbers increase from 1 on the left side.
2. Numbers decrease on the right side.
3. The middle section is filled with @ symbols.
4. As the rows increase:
   - the number section grows
   - the @ section shrinks

Help Souvik generate the firewall pattern.

Input Format:
A single integer N

Output Format:
Print the required firewall pattern.

Example Input:
5

Example Output:
1@@@@@@@@1
12@@@@@@21
123@@@@321
1234@@4321
1234554321

*/

// ======================================================
// Solution
// ======================================================

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            // Left increasing numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            // Middle @ symbols
            int atCount = 2 * (n - i);

            for (int j = 1; j <= atCount; j++) {
                System.out.print("@");
            }

            // Right decreasing numbers
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }

            System.out.println();
        }
    }
}
