class Solution {
    public int longestIncreasingPath(int[][] matrix){

int ans=0;
int[][] dp=new int[matrix.length][matrix[0].length];
      for(int i=0;i<matrix.length;i++){
        for(int j=0;j<matrix[0].length;j++){
            int[][] visited=new int[matrix.length][matrix[0].length];
            visited[i][j]=1;
            ans=Math.max(ans,dfs(matrix,i,j,visited,dp));

        }
      } 
      return ans;
        
    }

    public int dfs(int[][] matrix,int i,int j,int[][]visited,int[][] dp){
   
   if(dp[i][j]!=0) return dp[i][j];
        visited[i][j]=1;
        
        int ul=1;
        int ll=1;
        int rl=1;
        int dl=1;

        if(i>0 && matrix[i-1][j]>matrix[i][j] && visited[i-1][j]==0) {
            ul=dfs(matrix,i-1,j,visited,dp)+1;
        } 
        if(i+1<matrix.length && matrix[i+1][j]>matrix[i][j] && visited[i+1][j]==0){
            dl=dfs(matrix,i+1,j,visited,dp)+1;
        }
        if(j>0 && matrix[i][j-1]>matrix[i][j] && visited[i][j-1]==0){
            ll=dfs(matrix,i,j-1,visited,dp)+1;
        }
        if(j+1<matrix[0].length && matrix[i][j+1]>matrix[i][j]&& visited[i][j+1]==0){
            rl=dfs(matrix,i,j+1,visited,dp)+1;
        }
        visited[i][j]=0;
        dp[i][j]=Math.max(Math.max(ul,dl),Math.max(ll,rl));
        return dp[i][j];
    }

}
