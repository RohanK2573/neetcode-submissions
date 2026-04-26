class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> a-b);
        int j=0;
        while(j<nums.length){
            if(pq.size()<k) pq.offer(nums[j]);
            else{
                if(nums[j]>pq.peek()){
                    pq.remove();
                    pq.offer(nums[j]);
                }
            }

            j++;
        }
        return pq.poll();
        
    }
}
