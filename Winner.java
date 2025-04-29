class WinnerTree {
    private int[] tree;
    private int n;
    private int[] players;

    public WinnerTree(int[] players) {
        this.n = players.length;
        this.players = players;
        this.tree = new int[2 * n];
        initializeTree(players);
    }

    private void initializeTree(int[] players) {
        // Fill the leaf nodes
        for (int i = 0; i < n; i++) {
            tree[n + i] = players[i];
        }
        // Build the tree by calculating parents
        for (int i = n - 1; i > 0; i--) {
            tree[i] = Math.min(tree[2 * i], tree[2 * i + 1]);
        }
    }

    public void updateWinner(int index, int newScore) {
        index += n; // Move to leaf position
        tree[index] = newScore;

        players[index - n] = newScore;
        // Update the tree upwards
        while (index > 1) {
            index /= 2;
            tree[index] = Math.min(tree[2 * index], tree[2 * index + 1]);
        }
    }

    public int getWinner() {
        return tree[1]; // Root node holds the minimum value
    }

    public int getSecondMin() {
        int minVal = getWinner();
        int secondMin = Integer.MAX_VALUE;

        for (int val : players) {
            if (val != minVal && val < secondMin) {
                secondMin = val;
            }
        }
        return secondMin;
    }

    public static void main(String[] args) {
        int[] players = { 50, 30, 20, 40, 60 };
        WinnerTree winnerTree = new WinnerTree(players);
        System.out.println("Winner: " + winnerTree.getWinner()); // Output: 20
        System.out.println("Second Minimum: " + winnerTree.getSecondMin()); // Output: 30

        winnerTree.updateWinner(2, 10); // Update player at index 2 with a new score
        System.out.println("Updated Winner: " + winnerTree.getWinner()); // Output: 10
        System.out.println("Updated Second Minimum: " + winnerTree.getSecondMin()); // Output: 20
    }
}
