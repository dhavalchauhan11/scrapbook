public class DeleteBinaryTree {
    // main function
    public static void main(String[] args)
    {

        /**
         *             15
         *         |       |
         *        10      20
         *       |  |    |  |
         *       8  12  16  25
         *
         */

        Node root = null;

        root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);

        deleteBinaryTree(root);

        if(root == null){
            System.out.println("Tree deleted successfully");
        }

    }

    public static void deleteBinaryTree(Node root) {
        if(root == null){
            return;
        }

        deleteBinaryTree(root.left);
        deleteBinaryTree(root.right);

        root = null;

    }
}




