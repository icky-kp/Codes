public class LongestCommonSubsequenceRec {
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        System.out.println("Length of LCS is " + lcs(str1, str2));
    }

    private static int lcs(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        return lcsRec(str1, str2, m, n);
    }

    private static int lcsRec(String str1, String str2, int m, int n) {
        if(m == 0 || n == 0){
            return 0;
        }
        if(str1.charAt(m - 1) == (str2.charAt(n - 1))){
            return 1 + lcsRec(str1, str2, m-1, n-1);
        }
        else{
            return Math.max(lcsRec(str1, str2, m, n-1), lcsRec(str1, str2, m-1, n));
        }
    }
}
