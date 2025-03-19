public class RecoverBT {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    // Variables to store the two swapped nodes
    private TreeNode first = null, second = null, prev = null;

    public void recoverTree(TreeNode root) {
        // Perform in-order traversal to find the swapped nodes
        inOrderTraversal(root);

        // Swap the values of the two nodes to fix the BST
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        // Traverse the left subtree
        inOrderTraversal(node.left);

        // Check for swapped nodes
        if (prev != null && node.val < prev.val) {
            // If this is the first violation, mark 'first' and 'second'
            if (first == null) {
                first = prev;
            }
            // Mark 'second' for the second violation
            second = node;
        }
        prev = node; // Update the previous node

        // Traverse the right subtree
        inOrderTraversal(node.right);
    }

    // Helper method to print the in-order traversal of the tree
    public void printInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        RecoverBT recoverBT = new RecoverBT();

        // Create a BST with swapped nodes
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(23);

        System.out.println("In-order traversal before recovery:");
        recoverBT.printInOrder(root);

        // Recover the BST
        recoverBT.recoverTree(root);

        System.out.println("\nIn-order traversal after recovery:");
        recoverBT.printInOrder(root);
    }
}
