class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] str=s.toCharArray();
        if(s.isEmpty()) return 0;
        int ans=1;
        for(int i=0;i<str.length;i++){
            for(int j=i+1;j<str.length;j++){
                HashSet<Character> set=new HashSet<>();
                int k;
              for( k=i;k<=j;k++){
                 if(set.contains(str[k])) break;
                 set.add(str[k]);
              }
              if(k>j){
                ans=Math.max(ans,j-i+1);
              }

            }
        }
        return ans;


        
    }
}
