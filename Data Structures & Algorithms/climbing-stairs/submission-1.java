class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return dpStairs(n,dp);
       
        
    }

    public int dpStairs(int n,int[] dp){
         if(n==0) return 1;
        if(n<0) return 0;
       
        if(dp[n]!=-1) return dp[n];
        return dp[n]= dpStairs(n-1,dp)+dpStairs(n-2,dp);
    }
}
