class Solution {
    public int characterReplacement(String s, int k) {
        int l=0,r=0;
        char[] c=s.toCharArray();
        int n=c.length;
        int maxFreq=0;
        int map[]=new int[26];
        int ans=0;

        while(r<n){
            map[c[r]-'A']++;
            maxFreq=Math.max(maxFreq,map[c[r]-'A']);
            if(r-l+1-maxFreq>k){
                map[c[l]-'A']--;
                l++;
                maxFreq=0;
                // for(int i=0;i<26;i++){
                //      maxFreq=Math.max(maxFreq,map[i]);
                // } 
            }
            ans=Math.max(ans,r-l+1);
            r++;

        }
            return ans;
      
    }
}
