package ch4;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Author: dchauhan
 * Date: 3/3/16.
 */
public class BinarySearchTreeBFS {

    public static void main(String[] args) {
        BinarySearchTreeBFS bt = new BinarySearchTreeBFS();

        bt.insert(35);
        bt.insert(15);
        bt.insert(18);
        bt.insert(10);
        bt.insert(5);
        bt.insert(45);
        bt.insert(41);
        bt.insert(55);
        bt.insert(60);

        bt.BFS();
    }

    public void BFS(){
        Queue<Node> queue = new ConcurrentLinkedQueue<Node>();

        // first iteration
        if(queue.isEmpty()){
            queue.add(root);
        }

        while(!queue.isEmpty()){
            Node visited = queue.poll();
            // 1. visit
            System.out.print(visited.data + "->");

            //2. enqueue its children
            if(visited.left != null){
                queue.add(visited.left);
            }

            if(visited.right != null){
                queue.add(visited.right);
            }
        }
    }

    /**
     *
     * @param data
     */
    public void insert(int data){
        Node node = new Node(data);
        if(root == null){
            root = node;
            return;
        }
        insertHelper(root,node);
    }

    /**
     *
     * @param currentRoot
     * @param node
     */
    private void insertHelper(Node currentRoot, Node node) {
        if(currentRoot.data > node.data){
            if(currentRoot.left == null){
                currentRoot.left = node;
                System.out.println("Inserting " +node.data+ " to the LEFT of " +currentRoot.data);
                return;
            }else {
                insertHelper(currentRoot.left,node);
            }
        } else {
            if(currentRoot.right == null){
                currentRoot.right = node;
                System.out.println("Inserting "+node.data+ " to the RIGHT of " +currentRoot.data);
                return;
            } else{
                insertHelper(currentRoot.right,node);
            }
        }
    }

    Node root;

    private class Node{
        Node(int data){
            this.data = data;
        }
        int data;
        Node left;
        Node right;
    }
}
