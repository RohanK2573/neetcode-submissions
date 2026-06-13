class Solution {
    public List<Integer> majorityElement(int[] nums) {
       Arrays.sort(nums);
       List<Integer> ans=new ArrayList<>();
       int i=1;
       int count=1;
       while(i<nums.length){
          if(nums[i-1]==nums[i]){
            count++;
          }else{
            if(count>nums.length/3){
                ans.add(nums[i-1]);
            
            }
                count=1;
          }
          i++;
         
       }
        if(count>nums.length/3){
                ans.add(nums[i-1]);
                count=1;
            }
       return ans;
        
    }
}