class Solution {
    int rows;
    int cols;
    boolean[][] visited;
    int[][] directions;
    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;
        if(rows <= 2 || cols <= 2) return;
        directions = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        visited = new boolean[rows][cols];
        for(int r = 0; r < rows; r++){
            dfs(board, r, 0);
            dfs(board, r, cols - 1);
        }
        for(int c = 0; c < cols; c++){
            dfs(board, 0, c);
            dfs(board, rows - 1, c);
        }
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(board[r][c] == 'O'){
                    if(!visited[r][c]) board[r][c] = 'X';
                }
            }
        }
    }
    public void dfs(char[][] board, int r, int c){
        if(r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] == 'X' || visited[r][c]) return;
        visited[r][c] = true;
        for(int[] dir : directions) dfs(board, r + dir[0], c + dir[1]);
        return;
    }
}
