class Solution {
    public String minWindow(String s, String t) {
        int len=Integer.MAX_VALUE;
        int start=-1;
        String ans="";
        for(int i=0;i<s.length();i++){
            int[] map=new int[256];
            int c=0;
            for(int j=0;j<t.length();j++) map[t.charAt(j)]++;
            int j=i;
            for( ;j<s.length();j++){
                
                if(map[s.charAt(j)]>0) c++;
                 map[s.charAt(j)]--;
                  if(c==t.length()){
                if(j-i+1<len){
                   len=j-i+1;
                   start=i;
                }
            }
            }
           
        }
        if(start==-1) return "";
        return s.substring(start,start+len);
        
    }
}
