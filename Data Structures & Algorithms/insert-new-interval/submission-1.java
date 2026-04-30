class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i=0;
   
        List<int[]> ans=new ArrayList<>();
        int n=intervals.length;
        while(i<n && newInterval[0]>intervals[i][1]){
       
            ans.add(intervals[i]);
                 i++;
        }

        while(i<n && newInterval[1]>=intervals[i][0]){
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        ans.add(newInterval);
        while(i<n){
            ans.add(intervals[i]);
            i++;
        }
        int[][] finalAns=new int[ans.size()][2];
        for(int j=0;j<ans.size();j++){
            finalAns[j]=ans.get(j);

        }
        return finalAns;
        
    }
}
