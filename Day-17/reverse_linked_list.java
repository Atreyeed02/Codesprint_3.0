/*
========================================
PROBLEM: REVERSE LINKED LIST
========================================

Problem Statement:
Lovely is the coordinator of a college technical club and maintains
the attendance record of members using a linked sequence, where each
member's entry points to the next member.

For an upcoming club report, she wants to view the attendance records
in reverse order.

Help Lovely reverse the linked list and print the resulting sequence.

----------------------------------------
Sample Input
5
10 20 30 40 50

Sample Output
50 40 30 20 10
----------------------------------------
*/

import java.util.*;

class Node{
    int data;
    Node next;

    Node(int d){
        data=d;
    }
}

public class Main{

    static Node reverse(Node head){

        Node prev=null;

        while(head!=null){

            Node next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }

        return prev;
    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        Node head=null,tail=null;

        for(int i=0;i<n;i++){

            Node node=new Node(sc.nextInt());

            if(head==null)
                head=tail=node;
            else{
                tail.next=node;
                tail=node;
            }
        }

        head=reverse(head);

        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }
}
```
