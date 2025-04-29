public class LPS {
    public static void main(String[] args) {
        String s = "bbabcbcab";
        System.err.println(lps(s));
    }
    static int lps(String s){
        int n = s.length();
        int[][] dp =new int[n][n];
        for(int i = n-1; i>=0;i--){
            for(int j = i; j<n;j++){
                if(i == j){
                    dp[i][j] = 1;
                    continue; 
                }
                if(s.charAt(i) == s.charAt(j)){
                    if(i+1 == j){
                        dp[i][j] = 2;

                    }
                    else{
                        dp[i][j] = dp[i+1][j-1] + 2;
                    }
                }
                else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
