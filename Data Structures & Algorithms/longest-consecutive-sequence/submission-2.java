class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int ele=nums[i];
            int c=1;
            while(set.contains(ele+1)){
                c++;
                ele++;
            }
           ans= Math.max(ans,c);

        }
        return ans;
        
    }
}
