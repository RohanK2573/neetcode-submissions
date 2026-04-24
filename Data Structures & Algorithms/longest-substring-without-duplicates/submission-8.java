class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] str=s.toCharArray();
        HashMap<Character,Integer> mapIndex=new HashMap<>();
        int l=0;
        int ans=0;
        int r;
        for( r=0;r<str.length;r++){
            if(mapIndex.containsKey(str[r]) && mapIndex.get(str[r])>=l)
            {
               l=mapIndex.get(str[r])+1;
               mapIndex.remove(str[r]);
            }
            ans=Math.max(ans,r-l+1);
            mapIndex.put(str[r],r);


        }
        

return ans;
        
    }
}
