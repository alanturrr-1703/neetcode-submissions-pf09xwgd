class Solution {
    int rows;
    int cols;
    int[][] directions;
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        directions = new int[][] {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(word.charAt(0) == board[r][c]) {
                    if(dfs(board, word, r, c, 0)) return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int r, int c, int i){
        if(r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] != word.charAt(i)) return false;
        if(i == word.length() - 1) return true;
        char temp = board[r][c];
        board[r][c] = '#';

        for(int[] dir : directions){
            if (dfs(board, word, r + dir[0], c + dir[1], i + 1)){
                return true;
            }
        }
        board[r][c] = temp;
        return false;
    }
}