/*
Question:
Sagnik and the Netflix Watch History Analyzer

Find the Longest Common Prefix among all given strings.

Input:
First line contains integer N
Next N lines contain strings

Example:
Input:
3
moneyheistseason1
moneyheistseason2
moneyheistdocumentary

Output:
moneyheist
*/

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] arr = new String[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        String prefix = arr[0];

        for(int i = 1; i < n; i++) {

            while(!arr[i].startsWith(prefix)) {

                prefix = prefix.substring(0, prefix.length() - 1);

                if(prefix.isEmpty()) {
                    break;
                }
            }
        }

        System.out.print(prefix);
    }
}
