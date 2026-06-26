class Solution {
    public int rob(int[] nums) {
                if(nums.length == 1) return nums[0];
        int []noFirst=new int[nums.length-1];
        int []noLast=new int[nums.length-1];
        for(int i=0;i<nums.length-1;i++){
            noLast[i]=nums[i];
        }
        for(int i=1;i<nums.length;i++){
            noFirst[i-1]=nums[i];
        }
        return Math.max(helper(noFirst),helper(noLast));

        
    }

    public int helper(int[] nums){
        int []dp=new int[nums.length];
  
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
           int take=nums[i];
           if(i>1) take+=dp[i-2];
           int notTake=0+dp[i-1];
           dp[i]=Math.max(take,notTake);
        }
        return dp[nums.length-1];

    }

   
}
