class Solution {
    int res = 0;
    int m;
    int n;
    int[][] directions = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(grid[r][c] == '1'){
                    res++;
                    dfs(r, c, grid);
                }
            }
        }
        return res;
    }
    public void dfs(int r, int c, char[][] grid){
        if(r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == '0') return;
        grid[r][c] = '0';
        for(int[] dir : directions){
            dfs(r + dir[0], c + dir[1], grid);
        }
    }
}
