class Solution {
    public int numIslands(char[][] grid) {
         int[][] visited=new int[grid.length][grid[0].length];
         int ans=0;
         for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    dfs(i,j,visited,grid);
                    ans++;
                }
            }
         }
         return ans;


        
    }

    public void dfs(int i,int j,int[][] visited,char[][] grid){
        visited[i][j]=1;
         int[] dr = {-1, 0, 1, 0};

        int[] dc = {0, 1, 0, -1};
        for(int n=0;n<4;n++){
            int nr=i+dr[n];
            int nc=j+dc[n];
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]=='1' && visited[nr][nc]==0){
            //   visited[nr][nc]=1;
                dfs(nr,nc,visited,grid);
            }

        }
    
    }
}
