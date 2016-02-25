package ch3_stacks;

/**
 * Created by dhavalchauhan on 2/20/16.
 */
public class Stack {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(4);
        stack.push(5);

        stack.print();
    }

    public void print(){
        Node n = top;
        while(n.next != null){
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println(n.data);
    }

    Node top;

    Node pop(){
        if(top!=null){
            Node item = top;
            top = top.next;
            return item;
        }
        return null;
    }

    void push(int data){
        Node t = new Node();
        t.data = data;
        t.next = top;
        top = t;
    }

    private class Node{
        Node next;
        int data;
    }
}
