package ch2;

import java.util.Hashtable;
import java.util.List;

/**
 * @author dhavalchauhan
 * @data 2/3/16
 */
public class RemoveDups {

    public static void main(String[] args) {
        RemoveDups rd = new RemoveDups();

    }

    public static void deleteDup(Node node){
        Hashtable table = new Hashtable();
        Node previous = null;
        while(node.next != null){
            if(table.containsKey(node.data)){
                previous.next = node.next;
            } else{
                table.put(node.data,true);
                previous = node;
            }
        }
    }

    class Node{
        int data;
        Node next = null;
        Node(int d){
            this.data = d;
        }
    }
}
