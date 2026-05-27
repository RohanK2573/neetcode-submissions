class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        int r=0;
        int maxFreq=0;
        int ans=0;
        int[] map=new int[26];
        while(r<s.length()){
            map[s.charAt(r) - 'A']++;

            maxFreq = Math.max(maxFreq, map[s.charAt(r) - 'A']);
            while(r-l+1-maxFreq>k){
             map[s.charAt(l) - 'A']--;
                l++;
            }

            ans=Math.max(ans,r-l+1);
            r++;

        }
        return ans;

     
    }
}
