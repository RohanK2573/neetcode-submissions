class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            int ntake=dp[i-1]+0;
            int take=nums[i];
            if(i>1) take+=dp[i-2];
            dp[i]=Math.max(take,ntake);
        }
        return dp[nums.length-1];

        // for(int i=0;i<=nums.length;i++) dp[i]=-1;

        // return helper(nums,nums.length-1,dp);

    }

    public int helper(int[] nums,int ind,int []dp){
        if(ind==0) return nums[ind];
        if(ind<0) return 0;
        if(dp[ind]!=-1) return dp[ind];

        int pick=helper(nums,ind-2,dp)+nums[ind];
        int npick=helper(nums,ind-1,dp);
        return dp[ind]=Math.max(pick,npick);
    }
}
