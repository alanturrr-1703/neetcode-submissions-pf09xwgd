class Solution {
    int rows;
    int cols;
    int[][] directions;
    public void islandsAndTreasure(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 0) dfs(grid, r, c, 0);
            }
        }
    }
    public void dfs(int[][] grid, int r, int c, int dist){
        if(r < 0 || c < 0 || r >= rows || c >= cols) return;
        if(grid[r][c] == -1) return;
        if(grid[r][c] < dist) return;
        grid[r][c] = dist;
        for(int[] dir : directions) dfs(grid, r + dir[0], c + dir[1], dist + 1);
    }
}
