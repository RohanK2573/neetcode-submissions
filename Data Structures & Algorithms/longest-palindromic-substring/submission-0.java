class Solution {
    public String longestPalindrome(String s) {
        char[] str=s.toCharArray();
        String ans="";
        for(int i=0;i<str.length;i++){
            for(int j=i;j<str.length;j++){
                if(isPalindrome(str,i,j)){
                    if(j-i+1>ans.length()){
                        ans=s.substring(i,j+1);
                    }

                }
            }
        }
        return ans;

       

        
    }

    public boolean isPalindrome(char[] str,int i,int j){
        if(i>=j) return true;
        if(str[i]!=str[j]) return false;
        return isPalindrome(str,i+1,j-1);
    }
}
