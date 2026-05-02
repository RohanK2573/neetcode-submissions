class Solution {
    public int characterReplacement(String s, int k) {
        char[] str=s.toCharArray();
        int ans=0;
        for(int i=0;i<str.length;i++){
            int[] map=new int[256];
            int maxFreq=0;
            for(int j=i;j<str.length;j++){
                map[str[j]-'A']++;
                if(maxFreq<map[str[j]-'A']){
                    maxFreq=map[str[j]-'A'];
                }
                int changes=j-i+1-maxFreq;
                if(changes>k) break;
                else{
                   ans=Math.max(ans,j-i+1);
                }

            }

        }
        return ans;
    }
}
