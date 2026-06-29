class Solution {
    public String longestPalindrome(String s) {
        char[] str=s.toCharArray();
        boolean dp[][]= new boolean[str.length][str.length];
    
        String ans="";
        for(int i=0;i<str.length;i++){
            for(int j=i;j<str.length;j++){
                if(isPalindrome(str,i,j,dp)){
                    if(j-i+1>ans.length()){
                        ans=s.substring(i,j+1);
                    }

                }
            }
        }
        return ans;

       

        
    }

    public boolean isPalindrome(char[] str,int i,int j,boolean [][] dp){

        if(i>=j) return true;
         if(dp[i][j]!=false) return dp[i][j];
        if(str[i]!=str[j]) return false;
        return dp[i][j]=isPalindrome(str,i+1,j-1,dp);
    }
}
