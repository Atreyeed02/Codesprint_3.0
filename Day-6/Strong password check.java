// ==============================
// Question 1: Check!
// ==============================

// Problem Statement:
// Saptak is designing secure passwords for the participants of CodeSprint 3.0.
// A password is considered STRONG if:
// - it contains at least one uppercase letter
// - at least one lowercase letter
// - and at least one digit
//
// Print "STRONG" if all conditions are satisfied,
// otherwise print "WEAK".

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        boolean upper = false;
        boolean lower = false;
        boolean digit = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isUpperCase(ch))
                upper = true;
            else if (Character.isLowerCase(ch))
                lower = true;
            else if (Character.isDigit(ch))
                digit = true;
        }

        if (upper && lower && digit)
            System.out.println("STRONG");
        else
            System.out.println("WEAK");
    }
}
