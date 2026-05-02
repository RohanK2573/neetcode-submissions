class Solution {
    public int maxArea(int[] heights) {
        int i=0;
        int j=heights.length-1;
        int ans=0;
        while(i<j){
            int b=j-i;
            int h=Math.min(heights[i],heights[j]);
            ans=Math.max(ans,b*h);
            if(heights[i]>heights[j]) j--;
            else{
                i++;
            }


        }
        return ans;
        
    }
}
