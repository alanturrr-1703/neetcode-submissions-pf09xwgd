class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;
        if(grid[0][0] == 1 || grid[N - 1][N - 1] == 1) return -1;
        int[][] directions = {{0, 1}, {1,0}, {1,1},{-1,-1}, {-1,0},{0,-1},{1,-1},{-1,1}};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0,0,1});
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int r = cell[0], c = cell[1], length = cell[2];
            
            if(r == N - 1 && c == N - 1) return length;
            for(int[] d : directions){
                int nr = r + d[0], nc = c + d[1];
                if(nr >= 0 && nr < N && nc >= 0 && nc < N && grid[nr][nc] == 0){
                    q.offer(new int[] {nr, nc, length + 1});
                    grid[nr][nc] = 1;
                }
            }
        }
        return -1;

    }
}