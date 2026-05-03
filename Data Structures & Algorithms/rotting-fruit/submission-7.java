class Pair {
    int row;
    int col;
    int time;

    Pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new ArrayDeque<>();
        int fresh = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j, 0));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        int time = 0;

        while (!q.isEmpty()) {
            Pair node = q.poll();

            int cr = node.row;
            int cc = node.col;
            int t = node.time;

            time = Math.max(time, t);

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (nr >= 0 && nr < grid.length &&
                    nc >= 0 && nc < grid[0].length &&
                    grid[nr][nc] == 1) {

                    grid[nr][nc] = 2;
                    fresh--;
                    q.offer(new Pair(nr, nc, t + 1));
                }
            }
        }

        return fresh == 0 ? time : -1;
    }
}