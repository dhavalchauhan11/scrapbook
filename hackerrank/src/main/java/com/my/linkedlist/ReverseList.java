package com.my.linkedlist;

import java.util.Queue;
import java.util.Stack;

/**
 * Created by dhavalchauhan on 2/9/16.
 */
public class ReverseList {

    public static void main(String[] args) {
        ReverseList list = new ReverseList();
        list.addNodeToTail(2);
        list.addNodeToTail(3);
        list.addNodeToTail(4);
        list.addNodeToTail(5);
        list.print();

        head = list.reverse(head);
        System.out.println("After reverse");
        list.print();


    }

    public void print(){
        Node n = head;
        while(n.next!=null){
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.print(n.data);
        System.out.println();
    }

    private class Node{
        int data;
        Node next=null;

        public Node(int d)
        {
            this.data = d;
        }
    }

    public void addNodeToTail(int d){
        Node newNode = new Node(d);

        if(head == null){
            head = newNode;
        } else {
            Node current = head;

            // Iterate till the end of the list
            while(current.next != null){
                current = current.next;
            }

            // reached end of the list
            current.next = newNode;
        }
    }
    private static Node head;

    public Node reverse(Node head) {
        Node current = head;

        // empty list
        if(head == null){
            return null;
        }

        Node previous = null;
        Node next = null;

        while(current!=null){
            next = current.next;
            // reverse the link
            current.next = previous;
            // move by 1 node
            previous = current;
            current = next;
        }

        return previous;
    }


}
