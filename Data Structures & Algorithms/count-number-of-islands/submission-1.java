class Solution {
    int[][] directions = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int islands = 0;
        int cols = grid[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }
    public void dfs(char[][] grid, int r, int c){
        if(r < 0 || c < 0 || r > grid.length - 1 || c > grid[0].length - 1 || grid[r][c] == '0') return;
        grid[r][c] = '0';
        for(int[] dir : directions) dfs(grid, r + dir[0], c + dir[1]);
    }
}
