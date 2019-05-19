import java.util.ArrayDeque;
import java.util.Queue;

public class TreeHeight {
    public static void main(String[] args) {
        Node root = null;
        root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);

        System.out.println("Height of the tree " + height(root));
    }

    public static int heightR(Node root) {
        if(root == null) {
            return 0;
        }

        // traverse from left and right subtree and use max depth
        return 1 + Math.max(heightR(root.left), heightR(root.right));
    }

    public static int height(Node root) {
        if(root == null) {
            return 0;
        }

        // empty queue and add root node to begin with
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        Node front = null;
        int height = 0;

        // iterate until queue is empty
        while(!queue.isEmpty()) {
            // calc number of nodes in current level
            int size = queue.size();

            while(size-- > 0) {
                front = queue.poll();

                if(front.left != null){
                    queue.add(front.left);
                }

                if(front.right != null) {
                    queue.add(front.right);
                }
            }

            // increment height by 1 for each level
            height++;
        }

        return height;
    }

}

/**
 *             15
 *         |       |
 *        10      20
 *       |  |    |  |
 *       8  12  16  25
 *
 */


class Node {
    int key;
    Node left = null;
    Node right = null;

    Node(int key){
        this.key = key;
    }
}
