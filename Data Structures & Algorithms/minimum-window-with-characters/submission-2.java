class Solution {
    public String minWindow(String s, String t) {
        int[] map=new int[256];
        for(int i=0;i<t.length();i++){
            map[t.charAt(i)]++;
        }
        int r=0;
        int c=0;
        int l=0;
        int ans=Integer.MAX_VALUE;
        int startIndex=-1;
        while(r<s.length()){
            if(map[s.charAt(r)]>0){
                c++;
                map[s.charAt(r)]--;
                if(c==t.length()){
                    while(c==t.length()){
                        if(r-l+1<ans){
                            startIndex=l;
                            ans=r-l+1;
                        }
                        map[s.charAt(l)]++;
                        if(map[s.charAt(l)]>0) c--;
                        l++;
                     }
                }
            }else{
                map[s.charAt(r)]--;
            }
            r++;
        }
        if(startIndex==-1) return "";
        return s.substring(startIndex,startIndex+ans);

       
        



         
        
    }
}
