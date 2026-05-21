class Pair{
    int i;
    int j;
    int d;
    Pair(int i,int j,int d){
        this.i=i;
        this.j=j;
        this.d=d;
    }
}
class Solution {
    public void islandsAndTreasure(int[][] grid) {

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=-1 && grid[i][j]!=0){
                
                    bfs(grid,i,j);
                }
            }
        }

        
    }

    public void bfs(int[][] grid,int sr,int sc){
        Queue<Pair> q=new ArrayDeque<>();
        int dr[]=new int[]{-1,1,0,0};
        int dc[]=new int[]{0,0,1,-1};
        int minDist=Integer.MAX_VALUE;
        int[][] visited=new int [grid.length][grid[0].length];
        q.add(new Pair(sr,sc,0));
        while(!q.isEmpty()){
            Pair currentNode=q.poll();
            for(int j=0;j<4;j++){
                int nr=currentNode.i+dr[j];
                int nc=currentNode.j+dc[j];
                if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && visited[nr][nc]==0 && grid[nr][nc]!=-1){
                    visited[nr][nc]=1;
                    q.add(new Pair(nr,nc,currentNode.d+1));
                    if(grid[nr][nc]==0){
                        minDist=Math.min(minDist,currentNode.d+1);
                    }
                }
            }

        }
        if(minDist!=Integer.MAX_VALUE){
            grid[sr][sc]=minDist;
        
        }
        return;
    }
}
