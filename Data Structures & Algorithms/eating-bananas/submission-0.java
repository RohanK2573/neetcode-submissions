class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile=0;
   
        Arrays.sort(piles);

        int low=1,high=piles[piles.length-1];
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(timeToEat(piles,mid,h)) {
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
            
        }
        return ans;

        
    }

    public boolean timeToEat(int[] piles,int pH,int d){
        int t=0;
        for(int i=0;i<piles.length;i++){
            t+=Math.ceil((double)piles[i]/(double)pH);
        }
        return t<=d;

    }
}
