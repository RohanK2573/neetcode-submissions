class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[][] visitedPacific =new int[heights.length][heights[0].length];
        int[][] visitedAtlantic =new int[heights.length][heights[0].length];

        int topRow=0;
        int bottomRow=heights.length-1;
        int leftColumn=0;
        int rightColumn=heights[0].length-1;
        for(int i=0;i<heights[0].length;i++){
            if(visitedPacific[topRow][i]==0){
                visitedPacific[topRow][i]=1;
                dfs(topRow,i,visitedPacific,heights);
            }
            if(visitedAtlantic[bottomRow][i]==0){
                visitedAtlantic[bottomRow][i]=1;
                dfs(bottomRow,i,visitedAtlantic,heights);
            }

        }
        for(int i=0;i<heights.length;i++){
            if(visitedPacific[i][leftColumn]==0){
                visitedPacific[i][leftColumn]=1;
                dfs(i,leftColumn,visitedPacific,heights);
            }
            if(visitedAtlantic[i][rightColumn]==0){
                visitedAtlantic[i][rightColumn]=1;
                dfs(i,rightColumn,visitedAtlantic,heights);
            }

        }
        List<List<Integer>> ans= new ArrayList<>();

        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(visitedAtlantic[i][j]==1 && visitedPacific[i][j]==1){
                    List<Integer> subAns=new ArrayList<>();
                    subAns.add(i);
                    subAns.add(j);
                    ans.add(subAns);

                }
            }
        }
        return ans;


       



        
        
        
        
    }

    public void dfs(int sr,int sc,int[][] visited,int[][] heights)
    {
        int []dr=new int[]{0,0,-1,1};
        int []dc=new int[]{-1,1,0,0};
        for(int i=0;i<4;i++){
            int nr=sr+dr[i];
            int nc=sc+dc[i];
            if(nr>=0 && nr<heights.length && nc>=0 && nc<heights[0].length && visited[nr][nc]==0 && heights[nr][nc]>=heights[sr][sc]){
                visited[nr][nc]=1;
                dfs(nr,nc,visited,heights);
            }
        }
    }
}
