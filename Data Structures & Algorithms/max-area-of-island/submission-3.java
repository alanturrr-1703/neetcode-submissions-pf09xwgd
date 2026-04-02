class Solution {
    int[][] directions = {{1,0}, {-1,0}, {0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 1){
                    int area = dfs(grid, r, c);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
    public int dfs(int[][] grid, int r, int c){
        if(r < 0 || c < 0 || r > grid.length -1 || c > grid[0].length -1 || grid[r][c] == 0) return 0;
        grid[r][c] = 0;
        int area = 1;
        for(int[] dir : directions) area += dfs(grid, r + dir[0], c + dir[1]);
        return area;
    }
}
