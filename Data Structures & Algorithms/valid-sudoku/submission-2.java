class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        
        HashMap<Integer, HashSet<Character>> row = new HashMap<>();
        HashMap<Integer, HashSet<Character>> col = new HashMap<>();
        HashMap<String, HashSet<Character>> grid = new HashMap<>();

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                String gridKey = (r/3) + "," + (c/3);
                row.putIfAbsent(r, new HashSet<>());
                col.putIfAbsent(c, new HashSet<>());
                grid.putIfAbsent(gridKey, new HashSet<>());

                if(board[r][c] == '.') continue;
                if(row.get(r).contains(board[r][c])) return false;
                if(col.get(c).contains(board[r][c])) return false;
                if(grid.get(gridKey).contains(board[r][c])) return false;

                row.get(r).add(board[r][c]);
                col.get(c).add(board[r][c]);
                grid.get(gridKey).add(board[r][c]);
            }
        }
        return true;
    }
}
