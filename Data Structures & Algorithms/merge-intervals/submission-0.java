class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[] init=intervals[0];
        List<int[]> ans=new ArrayList<>();
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=init[1]){
                init[0]=Math.min(init[0],intervals[i][0]);
                init[1]=Math.max(init[1],intervals[i][1]);
            }else{
                ans.add(init);
                init=intervals[i];
            }

        }
        ans.add(init);
        int[][] finalAns=new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            finalAns[i]=ans.get(i);
        }
        return finalAns;
        
    }
}
