import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class BoundaryTraversal {

    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int value) {
            val = value;
            this.left = this.right = null;
        }
    }

    // Collect left boundary nodes (top-down)
    static void collectLeftBoundary(TreeNode node, List<Integer> result) {
        if (node == null || (node.left == null && node.right == null))
            return;
        result.add(node.val);
        if (node.left != null) {
            collectLeftBoundary(node.left, result);
        } else if (node.right != null) {
            collectLeftBoundary(node.right, result);
        }
    }

    // Collect leaf nodes (left to right)
    static void collectLeaves(TreeNode node, List<Integer> result) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            result.add(node.val);
            return;
        }
        collectLeaves(node.left, result);
        collectLeaves(node.right, result);
    }

    // Collect right boundary nodes (bottom-up)
    static void collectRightBoundary(TreeNode node, List<Integer> result) {
        if (node == null || (node.left == null && node.right == null))
            return;
        if (node.right != null) {
            collectRightBoundary(node.right, result);
        } else if (node.left != null) {
            collectRightBoundary(node.left, result);
        }
        result.add(node.val); // Add after child recursive call for bottom-up order
    }

    public static List<Integer> boundaryTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        result.add(root.val); // Add root

        // Left boundary
        collectLeftBoundary(root.left, result);

        // Leaves
        collectLeaves(root.left, result);
        collectLeaves(root.right, result);

        // Right boundary (excluding root)
        List<Integer> rightBoundary = new ArrayList<>();
        collectRightBoundary(root.right, rightBoundary);
        result.addAll(rightBoundary);

        return result;
    }

    public static TreeNode buildTree(List<Integer> arr) {
        if (arr == null || arr.isEmpty() || arr.get(0) == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr.get(0));
        queue.add(root);

        int index = 1;
        while (!queue.isEmpty() && index < arr.size()) {
            TreeNode current = queue.poll();

            // Process left child
            if (index < arr.size() && arr.get(index) != null) {
                current.left = new TreeNode(arr.get(index));
                queue.add(current.left);
            }
            index++;

            // Process right child
            if (index < arr.size() && arr.get(index) != null) {
                current.right = new TreeNode(arr.get(index));
                queue.add(current.right);
            }
            index++;
        }
        return root;
    }

    // Existing boundary traversal methods remain unchanged
    // ... [keep previous boundaryTraversal implementation] ...

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.println("Enter tree nodes in level order (use 'null' for empty nodes):");
        String input = scanner.nextLine().trim();

        // Parse input
        List<Integer> nodes = new ArrayList<>();
        for (String part : input.split("\\s+")) {
            if (part.equalsIgnoreCase("null")) {
                nodes.add(null);
            } else {
                // try {
                // nodes.add(Integer.parseInt(part));
                // } catch (NumberFormatException e) {
                // System.out.println("Invalid input: " + part + " - using null instead");
                // nodes.add(null);
                // }
                nodes.add(Integer.parseInt(part));
            }
        }

        // Build tree and perform traversal
        TreeNode root = buildTree(nodes);
        if (root == null) {
            return;
        }

        List<Integer> result = boundaryTraversal(root);
        System.out.println("Boundary traversal: " + result);
    }
}
