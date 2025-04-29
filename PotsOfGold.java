public class PotsOfGold {
    public static void main(String[] args) {
        int[] coin = { 4, 6, 2, 3 };
        System.out.println(findMaxCoins(coin, coin.length));
    }

    static int findMaxCoins(int[] coin, int n){
        if(n == 0){
            return 0;
        }
        int[][] dp = new int[n][n];
        for(int len=1; len<=n;len++){
            for(int start=0;start<=n-len;start++){
                int end = start + len -1;
                int x = (start+2 <= end) ? dp[start+1][end] : 0;
                int y = (start + 1 <= end - 1) ? dp[start + 1][end - 1] : 0;
                int z = (start <= end - 2) ? dp[start][end - 2] : 0;

                dp[start][end] = Math.max(coin[start] + Math.min(x, y), coin[end] + Math.min(y, z));
            }
        }
        
        return dp[0][n-1];
    }
}
