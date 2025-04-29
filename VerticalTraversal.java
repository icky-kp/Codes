import java.util.*;

public class VerticalTraversal {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    static class Pair {
        TreeNode node;
        int hd; // Horizontal Distance
        int level; // Level of the node

        Pair(TreeNode node, int hd, int level) {
            this.node = node;
            this.hd = hd;
            this.level = level;
        }
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        // TreeMap to store nodes grouped by horizontal distance (HD)
        TreeMap<Integer, List<Pair>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0, 0)); // Start with root at HD = 0 and level = 0

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            TreeNode node = current.node;
            int hd = current.hd;
            int level = current.level;

            // Add the node to the map grouped by HD
            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(current);

            // Add left and right children to the queue
            if (node.left != null)
                queue.add(new Pair(node.left, hd - 1, level + 1));
            if (node.right != null)
                queue.add(new Pair(node.right, hd + 1, level + 1));
        }

        // Process the TreeMap to build the result
        for (Map.Entry<Integer, List<Pair>> entry : map.entrySet()) {
            List<Pair> pairs = entry.getValue();

            // Sort nodes by level first, and by value if levels are the same
            pairs.sort((a, b) -> {
                if (a.level == b.level) {
                    return Integer.compare(a.node.val, b.node.val);
                }
                return Integer.compare(a.level, b.level);
            });

            // Extract the node values for the current HD
            List<Integer> vertical = new ArrayList<>();
            for (Pair pair : pairs) {
                vertical.add(pair.node.val);
            }
            result.add(vertical);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Vertical Traversal: " + verticalTraversal(root));
    }
}