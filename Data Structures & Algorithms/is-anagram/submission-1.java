class Solution {
    public boolean isAnagram(String s, String t) {
        int[] aMap=new int[26];
        int[] bMap=new int[26];
        if(s.length()!=t.length()) return false;
        for(int i=0;i<s.length();i++){
            aMap[s.charAt(i)-'a']++;
            bMap[t.charAt(i)-'a']++;
            
        }
        for(int i=0;i<26;i++){
            if(aMap[i]!=bMap[i]) return false;
        }
        return true;

    }
}
