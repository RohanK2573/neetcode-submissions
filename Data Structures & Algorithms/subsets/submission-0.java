class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        helper(ans,nums,0,curr);
         return ans;
        

        
    }

    public void helper(List<List<Integer>> ans,int[] nums,int i,List<Integer> curr){
        if(i==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        helper(ans,nums,i+1,curr);
        curr.remove(curr.size() - 1);
        helper(ans,nums,i+1,curr);
        }
}
