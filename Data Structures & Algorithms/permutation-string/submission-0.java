class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] map=new int[26];
        for(int i=0;i<s1.length();i++) map[s1.charAt(i)-'a']++;
        int l=0,r=0;
        int c=0;
         while(r<s2.length()){
            if(r-l+1<=s1.length()){
                if(map[s2.charAt(r)-'a']>0) c++;
                map[s2.charAt(r)-'a']--;
                r++;
            }else{
                map[s2.charAt(l)-'a']++;
                if(map[s2.charAt(l)-'a']>0)c--;
                l++;
            }
            if(c==s1.length()) return true;
         }
         return false;
        
    }
}
