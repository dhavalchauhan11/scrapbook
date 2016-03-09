import java.util.Stack;

/**
 * Author: dchauhan
 * Date: 2/23/16.
 */
public class LinkedListPalindrome {
    public Node head;

    public static void main(String[] args) {
        LinkedListPalindrome list = new LinkedListPalindrome();

        list.add("R");
        list.add("A");
        list.add("D");
        list.add("A");
        list.add("R");

        list.print();
        System.out.println();

        boolean isPali = list.isPalindrome(list.head);
        System.out.println(isPali);
    }

    /**
     * Create reverse linked list
     * traverse throguh the first and compare with elements of the second
     *
     * Time O(n) -- space O(n)
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(Node head){
        if(head == null)
            return false;

        Node current = head;
        Node rev = new Node(current.data);

        // reverse the list
        while(current.next != null){
            Node temp = new Node(current.next.data);
            temp.next = rev;
            rev = temp;
            current = current.next;
        }

        Node n1 = head;
        Node n2 = rev;

        while(n1 != null){
            if(!n1.data.equals(n2.data)){
                return false;
            }

            n1 = n1.next;
            n2 = n2.next;
        }

        return true;
    }

    public boolean isPalindromeStack(Node head){
        if(head == null)
            return true;

        Stack<Node> stack = new Stack<Node>();

        Node current = head;

        // Generate stack out of the list - stack - LIFO nature will automatically reverse the list
        while(current.next != null){
            stack.push(current);
            current = current.next;
        }

        while(current.next != null){
            Node stackNode = stack.pop();
            if(!current.data.equals(stackNode.data)){
                return false;
            }
        }
        return true;
    }

    public void print(){
        Node n = head;
        while(n.next!=null){
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.print(n.data);
    }

    public void add(String data){

        Node n = new Node(data);

        if(head == null){
            head = n;
        } else {
            Node current = head;
            while(current.next != null){
                current = current.next;
            }

            current.next = n;
        }
    }

    private class Node{
        String data;
        Node next;

        Node(String data){
            this.data = data;
        }
    }
}
