/*
========================================
PROBLEM: REMOVE KTH NODE FROM END
========================================

Problem Statement:
Kohinoor is managing the queue for the hostel's famous midnight
Maggi counter.

The queue is stored as a linked list, where each node represents
a student's token number.

Just before ordering, one student checks their account balance,
realizes they have only ₹12 left, and quietly disappears from the line.

The student happens to be the Kth person from the end of the queue.

Help Kohinoor update the linked list by removing that student
and print the updated queue.

----------------------------------------
Sample Input
5
101 102 103 104 105
2

Sample Output
101 102 103 105
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

    static Node remove(Node head,int k){

        Node d=new Node(0);
        d.next=head;

        Node f=d,s=d;

        for(int i=0;i<=k;i++){
            f=f.next;
        }

        while(f!=null){
            f=f.next;
            s=s.next;
        }

        s.next=s.next.next;

        return d.next;
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

        head=remove(head,sc.nextInt());

        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }
}
```
