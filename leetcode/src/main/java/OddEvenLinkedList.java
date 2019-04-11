/**
 * Author: dchauhan
 * Date: 6/6/16.
 */
public class OddEvenLinkedList {

    private ListNode head;

    public static void main(String[] args) {
        OddEvenLinkedList list = new OddEvenLinkedList();
        list.addNodeToTail(1);
        list.addNodeToTail(2);
        list.addNodeToTail(3);
        list.addNodeToTail(4);
        list.addNodeToTail(5);
        list.addNodeToTail(6);
        list.print();

        list.oddEvenList();

    }

    public ListNode oddEvenList(){
        if(head == null){
            return null;
        }

        ListNode odd = head;
        ListNode even = odd.next;
        ListNode evenHead = even;

        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }

    public ListNode oddEvenList2(){

        ListNode orderedList;

        ListNode odd = null;
        ListNode even = null;
        int pointer = 0;

        ListNode current = head;

        while(current != null){
            pointer++;

            if(pointer % 2 == 0){
                if(even == null){
                    even = new ListNode(current.val);
                } else {
                    ListNode temp = even;
                    while(temp.next != null){
                        temp = temp.next;
                    }
                    temp.next = new ListNode(current.val);
                }
            } else {
                if(odd == null){
                    odd = new ListNode(current.val);
                } else {
                    ListNode temp = odd;
                    while(temp.next != null){
                        temp = temp.next;
                    }
                    temp.next = new ListNode(current.val);
                }
            }
            current = current.next;
        }

        orderedList = odd;
        while(odd.next != null){
            odd = odd.next;
        }

        odd.next = even;

        return orderedList;
    }

    public void print(){
        ListNode n = head;
        while(n.next!=null){
            System.out.print(n.val + " -> ");
            n = n.next;
        }
        System.out.print(n.val);
    }

    public void addNodeToTail(int d){
        ListNode newListNode = new ListNode(d);

        if(head == null){
            head = newListNode;
        } else {
            ListNode current = head;

            // Iterate till the end of the list
            while(current.next != null){
                current = current.next;
            }

            // reached end of the list
            current.next = newListNode;
        }
    }

    private class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }


}
