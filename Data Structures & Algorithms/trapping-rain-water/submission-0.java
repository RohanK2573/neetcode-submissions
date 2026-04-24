class Solution {
    public int trap(int[] height) {
        int l=0;
        int r=height.length-1;
        int lMax=0;
        int rMax=height.length-1;;
        int ans=0;
        while(l<r){
            if(height[l]<=height[r]){
                if(height[l]<=height[lMax]){
                    ans+=height[lMax]-height[l];

                }else{  
                    lMax=l;
                }
                l++;
            }else{
                 if(height[r]<=height[rMax]){
                    ans+=height[rMax]-height[r];

                }else{  
                    rMax=r;
                }
                r--;

            }
        }
        return ans;
        
    }
}
