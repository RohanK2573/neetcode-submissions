class Solution {
    public int lengthOfLIS(int[] nums) {
        int maxLen=0;
        int [][]dp=new int[nums.length][nums.length+1];
            for (int[] row : dp) {

            Arrays.fill(row, -1);

        }
        
        

        return helper(nums,0,-1,dp);
    
 

        
    }

    public int helper(int[] nums,int ind,int prev,int[][] dp){
        if(ind==nums.length){
            return 0;
        }
        int lenPick=0;
        if(dp[ind][prev+1]!=-1) return dp[ind][prev+1];
        if( prev==-1 || nums[ind]>nums[prev]) lenPick=helper(nums,ind+1,ind,dp)+1;
        int notPick=helper(nums,ind+1,prev,dp);
        return dp[ind][prev+1]=Math.max(lenPick,notPick);

    }
}
