class Pair{
    int end;
    int len;
    Pair(int len,int end){
        this.end=end;
        this.len=len;
    }
}
class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[] queriesClone=queries.clone();
        Arrays.sort(queriesClone);
        HashMap<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.len-b.len);
        int idx=0;
        for(int que:queriesClone){
            while(idx<intervals.length && intervals[idx][0]<=que){
                pq.offer(new Pair(intervals[idx][1]-intervals[idx][0]+1,intervals[idx][1]));
                idx++;
            }
            while(!pq.isEmpty() && pq.peek().end<que){
                pq.poll();
            }
            if(pq.isEmpty()) map.put(que,-1);
            else {
                map.put(que,pq.peek().len);
            };

        }
        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            ans[i]=map.get(queries[i]);
        }
        return ans;

    



        
    }
}
