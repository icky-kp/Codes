import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalTraversal {
    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int value) {
            val = value;
            this.left = this.right = null;
        }
    }

    public static List<List<Integer>> verticalOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        // TreeMap to store nodes grouped by column
        Map<Integer, List<Integer>> verticalMap = new TreeMap<>();
        Queue<SimpleEntry<TreeNode, Integer>> nodeQueue = new LinkedList<>();

        // Start BFS with root at column 0
        nodeQueue.offer(new SimpleEntry<>(root, 0));

        while (!nodeQueue.isEmpty()) {
            SimpleEntry<TreeNode, Integer> entry = nodeQueue.poll();
            TreeNode node = entry.getKey();
            int col = entry.getValue();

            // Add node to the corresponding column in the map
            verticalMap.computeIfAbsent(col, k -> new ArrayList<>()).add(node.val);

            // Enqueue left and right children with updated column positions
            if (node.left != null)
                nodeQueue.offer(new SimpleEntry<>(node.left, col - 1));
            if (node.right != null)
                nodeQueue.offer(new SimpleEntry<>(node.right, col + 1));
        }

        // Add columns to the result list in sorted order
        for (List<Integer> column : verticalMap.values()) {
            result.add(column);
        }

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

    public static void main(String[] args) {
        // Example tree: [1, 2, 3, 4, 5, 6, 7]
        List<Integer> treeData = Arrays.asList(1, null, 3, 4, 5, 6, 7);
        TreeNode root = buildTree(treeData);

        // Perform vertical order traversal
        List<List<Integer>> result = verticalOrderTraversal(root);

        // Print the result
        System.out.println("Vertical Order Traversal: " + result);
    }
}