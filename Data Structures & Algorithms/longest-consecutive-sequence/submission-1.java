class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        int i=1;
        int c=1;
        int maxc=Integer.MIN_VALUE;
        while(i<nums.length){
            if(nums[i]==nums[i-1]+1){
                c++;
            }else{
                if(nums[i]!=nums[i-1]){
                   maxc= Math.max(maxc,c);
                   c=1;
                }
            }
            i++;
        }
          maxc= Math.max(maxc,c);
        return maxc;
        
    }
}
