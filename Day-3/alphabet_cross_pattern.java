import java.util.*;

/*
Problem Statement

Kavya loves designing creative alphabet patterns.

She wants to print a stylish alphabet cross pattern using characters.

Help Kavya print this pattern.

Input Format
- A single integer N — size of the pattern.

Output Format
Print the required alphabet pattern.

Example

Input:
5

Output:
A * * * A
* B * B *
* * C * *
* D * D *
E * * * E
*/

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {

            for(int j = 0; j < n; j++) {

                if(j == i || j == n - i - 1) {

                    System.out.print((char)('A' + i) + " ");
                }

                else {

                    System.out.print("* ");
                }
            }

            System.out.println();
        }
    }
}
