/*
Problem Statement
Mounit's company, ChatClean, is a popular messaging platform that processes millions of user messages every day.

Many users accidentally type extra spaces at the beginning, end, or between words.
Before displaying messages in a clean format, ChatClean applies the following rules:

1. Reverse the order of the words.
2. Remove unnecessary spaces.
3. Keep exactly one space between consecutive words.
4. Remove leading and trailing spaces.

Given a string S, help Mounit format the message correctly.

Input Format
A single line containing the string S.

Output Format
Print the formatted string after reversing the order of the words.
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        // Remove leading and trailing spaces
        s = s.trim();

        // Split words using one or more spaces
        String[] words = s.split("\\s+");

        StringBuilder ans = new StringBuilder();

        // Reverse words
        for (int i = words.length - 1; i >= 0; i--) {
            ans.append(words[i]);

            if (i != 0) {
                ans.append(" ");
            }
        }

        System.out.println(ans.toString());
    }
}
```
