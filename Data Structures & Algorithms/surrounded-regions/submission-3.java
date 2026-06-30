class Solution {
    public void solve(char[][] board) {
        //check board size.
        int x=board.length;
        int y=board[0].length;
        if(x<1 || y<1) return;
        int[][] visited=new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O'){
                dfs(i,0,board,visited);
            }
            if(board[i][board[0].length-1]=='O'){
                dfs(i,board[0].length-1,board,visited);
            }
        }
         for(int i=0;i<board[0].length;i++){
            if(board[0][i]=='O'){
                dfs(0,i,board,visited);
            }
            if(board[board.length-1][i]=='O'){
                dfs(board.length-1,i,board,visited);
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O' && visited[i][j]==0){
                    board[i][j]='X';
                }
            }
        }

        
    }

    public void dfs(int srcX,int srcY,char[][] board,int[][] visited){
        int[] dx=new int[]{0,0,1,-1};
        int[] dy=new int[]{1,-1,0,0};
        visited[srcX][srcY]=1;
       
        for(int i=0;i<4;i++){
            int nx=srcX+dx[i];
            int ny=srcY+dy[i];
            if(nx>=0 && nx<board.length && ny>=0 && ny<board[0].length && visited[nx][ny]==0 && board[nx][ny]=='O'){
                visited[nx][ny]=1;
                dfs(nx,ny,board,visited);
            }
        }
        

    }
}
