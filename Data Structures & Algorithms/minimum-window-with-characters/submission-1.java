class Solution {
    public String minWindow(String s, String t) {
         int map[]=new int[256];
         int l=0;
         int r=0;
         int sIndex=-1;
         int minLength=Integer.MAX_VALUE;
         for(int i=0;i<t.length();i++){
            map[s.charAt(0) < 256 ? t.charAt(i) : 0]++;
         }
         int c=0;
         while(r<s.length()){
            if(map[s.charAt(r)]>0) c++;
            map[s.charAt(r)]--;
            r++;
            while(c==t.length()){
                if(r-l < minLength){
                    sIndex=l;
                    minLength=r-l;
                }
                map[s.charAt(l)]++;
                if(map[s.charAt(l)]>0) c--;
                l++;
            }

         }
         if(sIndex==-1) return "";
         return s.substring(sIndex,sIndex+minLength);

    }

}
