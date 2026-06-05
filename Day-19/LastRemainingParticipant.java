/*
Problem Statement:
Saptarshi is organizing a coding challenge where participants stand in a circle.
Each participant is assigned a unique ID, and the participants are arranged in
the form of a circular linked list.

Starting from the first participant, every K-th participant is eliminated from
the circle. After each elimination, counting resumes from the next participant
still in the game.

The process continues until only one participant remains.

Your task is to determine the ID of the participant who survives till the end.

Input Format:
The first line contains an integer N — the number of participants.
The second line contains N distinct integers representing the participant IDs.
The third line contains an integer K.

Output Format:
Print a single integer representing the ID of the last remaining participant.

Example:
Input:
7
10 20 30 40 50 60 70
3

Output:
40
*/

import java.util.*;

public class LastRemainingParticipant {

    static class Node {
        int id;
        Node next;

        Node(int id) {
            this.id = id;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        Node head = new Node(ids[0]);
        Node tail = head;

        for (int i = 1; i < n; i++) {
            tail.next = new Node(ids[i]);
            tail = tail.next;
        }

        tail.next = head; // make circular

        Node curr = head;
        Node prev = tail;

        int count = n;

        while (count > 1) {

            for (int i = 1; i < k; i++) {
                prev = curr;
                curr = curr.next;
            }

            // Remove K-th participant
            prev.next = curr.next;
            curr = curr.next;

            count--;
        }

        System.out.println(curr.id);

        sc.close();
    }
}
