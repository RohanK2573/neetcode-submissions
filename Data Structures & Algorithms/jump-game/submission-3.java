class Solution {
    public boolean canJump(int[] nums) {
        int maxJump=0;
        for(int i=0;i<nums.length;i++){
            System.out.println(i);
            if(maxJump==nums.length-1) return true;
            if(nums[i]==0 && maxJump<=i) return false;
            maxJump=Math.max(maxJump,nums[i]+i);
        }
        return true;
        
    }
}
