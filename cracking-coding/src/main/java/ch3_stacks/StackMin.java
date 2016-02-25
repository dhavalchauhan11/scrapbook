package ch3_stacks;

/**
 * Created by dhavalchauhan on 2/21/16.
 */
public class StackMin {

    Node top;

    public Node getMin(){
        Node runner = top;

        Node min = top;

        while(runner != null){
            if(runner.data < min.data){
                min = runner;
            }
            runner = runner.next;
        }

        return min;
    }

    public Node pop(){
        if(top != null){
            Node temp = top;
            top = top.next;
            return temp;
        }
        return null;
    }

    public void push(int data){
        Node n = new Node(data);

        n.next = top;
        top = n;
    }

    private class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }


    public static void main(String[] args) {
        StackMin stackMin = new StackMin();
        // multiple items
//        stackMin.push(1);
//        stackMin.push(3);
//        stackMin.push(4);
//        stackMin.push(5);

        // single
//        stackMin.push(5);

        // dups
        stackMin.push(1);
        stackMin.push(5);
        stackMin.push(5);

        Node temp = stackMin.getMin();
        System.out.println(temp.data);
    }
}
