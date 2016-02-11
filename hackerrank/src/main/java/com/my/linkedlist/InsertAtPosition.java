package com.my.linkedlist;

/**
 * Created by dhavalchauhan on 2/10/16.
 */
public class InsertAtPosition {

    public static void main(String[] args) {
        InsertAtPosition list = new InsertAtPosition();
        list.addNodeToTail(2);
        list.addNodeToTail(3);
        list.addNodeToTail(4);
        list.addNodeToTail(5);
        list.print();

//        head = list.insertNth(head,1,2);
        head = list.insertRecursive(head,1,2);
        list.print();

    }

    Node insertNth(Node head, int data, int position) {
        Node dummy = new Node();
        dummy.next = head;

        Node runner = dummy;
        for (int i = 0; i < position; ++i) {
            runner = runner.next;
        }

        Node newNode = new Node();
        newNode.data = data;
        newNode.next = runner.next;
        runner.next = newNode;

        return dummy.next;
    }

    Node insertRecursive(Node head,int data,int position){
        if(position == 0){
            Node newNode = new Node();
            newNode.data = data;
            newNode.next = head;
            return newNode;
        }
        head.next = insertRecursive(head.next,data,position-1);
        return head;
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

//        public Node(int d)
//        {
//            this.data = d;
//        }
    }

    public void addNodeToTail(int d){
        Node newNode = new Node();
        newNode.data = d;

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
}
