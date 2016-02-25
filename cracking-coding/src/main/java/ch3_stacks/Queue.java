package ch3_stacks;

/**
 * Created by dhavalchauhan on 2/20/16.
 */
public class Queue {
    Node first;
    Node last;

    public void enque(int data){
        Node n = new Node();
        n.data = data;

        if(first == null){
            last = n;
            first = last;
        } else {
            last.next = n;
            last = n;
        }
    }

    public Node dequeue(){
        if(first != null){
            Node n = first;
            first = first.next;
            return n;
        }
        return null;
    }

    public void print(){
        while(first.next != null){
            System.out.print(first.data   + "->");
            first = first.next;
        }
        System.out.println(first.data);
    }

    private class Node{
        int data;
        Node next;
    }


    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enque(1);
        queue.enque(2);
        queue.enque(3);
        queue.enque(4);

//        queue.print();

        Node temp = queue.dequeue();
        while(temp != null){
            System.out.print(temp.data + ",");
            temp = queue.dequeue();
        }
    }
}
