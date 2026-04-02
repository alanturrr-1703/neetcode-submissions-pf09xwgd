class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 0) dfs(grid, rows, cols, i, j, 0);
            }
        }
    }
    public void dfs(int[][] grid, int rows, int cols, int i, int j, int dist){
        if(i < 0 || j < 0 || i >= rows || j >= cols) return;
        if(grid[i][j] == -1) return;
        if(grid[i][j] < dist) return;
        grid[i][j] = dist;
        dfs(grid, rows, cols, i + 1, j, dist + 1); 
        dfs(grid, rows, cols, i - 1, j, dist + 1); 
        dfs(grid, rows, cols, i, j + 1, dist + 1); 
        dfs(grid, rows, cols, i, j - 1, dist + 1);
    }
}