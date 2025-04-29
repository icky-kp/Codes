public class RoadCut {
   public static void main(String[] args) {
      int[] price = {1, 5, 8, 9};
      System.out.println(cutRod(price));
   } 
   static int cutRod(int[] price){
      int n = price.length;
      int[] dp = new int[n+1];
      for(int i = 1; i<= n;i++){
         for(int j=1; j<=i;j++){
            dp[i] = Math.max(dp[i],price[j-1]+dp[i-j]);
         }
      }
      return dp[n];
   }
}
