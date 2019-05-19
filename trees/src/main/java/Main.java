import java.util.Arrays;
import java.util.List;

// Data structure to store a Binary Tree node
class TreeNode
{
    int data;
    TreeNode left, right;

    // Function to create a new binary tree node having given key
    public TreeNode(int key)
    {
        data = key;
        left = right = null;
    }
};

// Simple pair class to store the path of a particular key in 
// the binary tree
class Pair
{
    private String path;
    private int key;

    public Pair(String path, int key) {
        this.path = path;
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public String getPath() {
        return path;
    }
};

class Main
{
    // Function to insert given key into the tree
    public static TreeNode insert(TreeNode root, String level, int key)
    {
        // tree is empty
        if (level.length() == 0) {
            return new TreeNode(key);
        }

        TreeNode curr = root;
        for (int i = 0; i < level.length() - 1; i++)
        {
            if (level.charAt(i) == 'L') {
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
        }

        if (level.charAt(level.length() - 1) == 'L') {
            curr.left = new TreeNode(key);
        } else {
            curr.right = new TreeNode(key);
        }

        return root;
    }

    // Recursive function to perform pre-order traversal of the tree
    public static void preorder(TreeNode root)
    {
        // return if the current node is empty
        if (root == null) {
            return;
        }

        // Display the data part of the root (or current node)
        System.out.print(root.data + " ");

        // Traverse the left subtree
        preorder(root.left);

        // Traverse the right subtree
        preorder(root.right);
    }

    public static void main(String[] args)
    {
		/* Construct below tree
                   1
                 /   \
                /     \
               2       3
              /      /  \
             /      /    \
            4      5      6
                  / \
                 /   \
                7     8
		*/

        List<Pair> keys = Arrays.asList(new Pair("", 1), new Pair("L", 2),
                new Pair("R", 3), new Pair("LL", 4),
                new Pair("RL", 5), new Pair("RR", 6),
                new Pair("RLL", 7), new Pair("RLR", 8));

        TreeNode root = null;

        for (Pair pair: keys) {
            root = insert(root, pair.getPath(), pair.getKey());
        }

        preorder(root);
    }
}