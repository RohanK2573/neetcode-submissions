class Pair{
    int i;
    int j;
    Pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans=0;
        int[][] visited=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && visited[i][j]==0){
                    ans=Math.max(ans,bfs(visited,grid,i,j));

                }
            }
        }
        return ans;
        
    }
    public int bfs(int[][] visited,int[][] grid,int sr,int sc){
        visited[sr][sc]=1;
        int []dr=new int[]{0,0,-1,1};
        int []dc=new int[]{1,-1,0,0};
        int c=1;
        for(int i=0;i<4;i++){
            int nr=sr+dr[i];
            int nc=sc+dc[i];
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && visited[nr][nc]!=1 && grid[nr][nc]!=0){
               c+= bfs(visited,grid,nr,nc);
            }
        }
        return c;


    }
}
