package ch4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by dhavalchauhan on 2/24/16.
 */
public class TreeTraversal {

    Node root;

    public List<Node> preOrder(Node root){

        List<Node> list = new ArrayList<Node>();

        if(root == null){
            return list;
        }

        Stack<Node> stack = new Stack<Node>();
        stack.push(root);

        while(!stack.empty()){
            Node n = stack.pop();
            list.add(n);

            // push right element
            if(n.right != null)
                stack.push(n.right);

            if(n.left != null)
                stack.push(n.left);
        }

        return list;
    }

    private class Node{
        int value;
        Node right;
        Node left;

        public Node(int value){
            this.value = value;
        }
    }
}
