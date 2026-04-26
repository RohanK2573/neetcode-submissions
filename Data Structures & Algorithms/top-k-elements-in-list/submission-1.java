class Pair{
    int value;
    int index;
    Pair(int index,int value){
        this.index=index;
        this.value=value;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.value-b.value);
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
              if(pq.size()<k){
                pq.offer(new Pair(entry.getKey(),entry.getValue()));

            }else{
                if(entry.getValue()>pq.peek().value){
                pq.remove();
                pq.offer(new Pair(entry.getKey(),entry.getValue()));
               }
            }
        }

       

        int[] ans=new int[k];
        int l=0;
        while(!pq.isEmpty()){
           ans[l++]=pq.poll().index;
        }
        return ans;
        
    }
}
