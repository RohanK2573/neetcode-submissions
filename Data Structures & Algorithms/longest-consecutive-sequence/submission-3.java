class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int ans=0;
         for(int ele: set){
           if(!set.contains(ele-1)){
            int c=1;
            while(set.contains(ele+1)){
                ele+=1;
                c+=1;
            }
            ans=Math.max(c,ans);
           }


         }
         return ans;
        
    }
}
