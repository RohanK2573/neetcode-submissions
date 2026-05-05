class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int i=1;
        int ans=0;
        int[] prev=intervals[0];
        while(i<intervals.length){
            if(intervals[i][0]<prev[1]){
                ans++;
                
            }else{
              prev=intervals[i];
            }
         
            i++;
        }
        return ans;

        
    }
}
