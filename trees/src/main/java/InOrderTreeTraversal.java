import java.util.Stack;

public class InOrderTreeTraversal {
    public static void main(String[] args) {
        /**
         *             15
         *         |       |
         *        10      20
         *       |  |    |  |
         *       8  12  16  25
         *
         */

        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);


        inOrderTraverseR(root);
        inOrderTraverse(root);
    }

    public static void inOrderTraverseR(Node root) {
        if(root == null) {
            return;
        }

        // traverse left subtree
        inOrderTraverseR(root.left);

        // visit/print data for current/root node
        System.out.println(root.key);

        // traverse right subtree
        inOrderTraverseR(root.right);
    }

    public static void inOrderTraverse(Node root) {
        Stack<Node> stack = new Stack<>();

        Node current = root;

        // push current node to stack and move to its left
        // until left subtree reaches end/becomes null - move to right
        while(!stack.empty() || current != null){
            // if current node is not null then push it to stack - will revisit later
            // and move current pointer to left
            if(current != null){
                stack.push(current);
                current = current.left;
            } else {
                // if nothing left on the left side then pop the element - print it
                // and move pointer to right
                current = stack.pop();
                System.out.println(current.key + " ");

                current = current.right;
            }

        }
    }
}
