package com.my.linkedlist;

/**
 * Author: dchauhan
 * Date: 3/9/16.
 */
public class CompareLists {

    public static void main(String[] args) {
        CompareLists lists = new CompareLists();
        head1 = lists.insert(head1,2);
        head1 = lists.insert(head1,3);
        head1 = lists.insert(head1,4);

        head2 = lists.insert(head2,2);
        head2 = lists.insert(head2,3);
        head2 = lists.insert(head2,4);
        head2 = lists.insert(head2,5);

        System.out.printf("list1: ");
        lists.print(head1);

        System.out.println();

        System.out.printf("list2: ");
        lists.print(head2);

        System.out.println(lists.compare(head1,head2));

    }

    /**
     * Compare the two linked lists and return 1 if the lists are equal. Otherwise, return 0. Do NOT print anything to stdout/console.
     * @param head1
     * @param head2
     * @return
     */
    private boolean compare(Node head1, Node head2) {
        Node current1 = head1;
        Node current2 = head2;
        while(current1 != null && current2 != null){
            if(current1.data != current2.data){
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return true;
    }

    private void print(Node head) {
        StringBuilder sb = new StringBuilder();
        if(head != null){
            Node current = head;
            while(current != null){
                if(sb.length() != 0){
                    sb.append(" -> ");
                }
                sb.append(current.data);
                current = current.next;
            }
        }
        System.out.println(sb.toString());
    }

    public Node insert(Node head,int data){
        Node nNode = new Node(data);
        if(head == null){
            head = nNode;
        } else {
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = nNode;
        }

        return head;
    }

    static Node head1;
    static Node head2;

    private class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

}

