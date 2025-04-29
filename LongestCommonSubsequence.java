public class LongestCommonSubsequence {
    //bottom-down tabulation
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        System.out.println("Length of LCS is " + lcs(str1, str2));
    }
    static int lcs(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int len = dp[m][n];
        int i =m;
        int j =n;
        int index = len-1;
        String str ="";
        for(int k = 1; k <= len; k++){
            str+="$";
        }
        StringBuilder ss = new StringBuilder(s1);
        StringBuilder str2 = new StringBuilder(str);

        while(i>0 && j>0){
            if(ss.charAt(i-1) == s2.charAt(j-1)){
                str2.setCharAt(index, ss.charAt(i-1));
                index--;
                i--;
                j--;
            }
            else if(ss.charAt(i-1)>s2.charAt(j-1)){
                i--;
            }
            else j--;
        }
        System.out.println(str2);
        return dp[m][n];
    }
}
