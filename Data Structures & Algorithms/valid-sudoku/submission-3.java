class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> rows = new HashMap<>();
        HashMap<Integer, HashSet<Character>> cols = new HashMap<>();
        HashMap<String, HashSet<Character>> grid = new HashMap<>();
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                String gridKey = (r/3) + "," + (c/3);
                rows.putIfAbsent(r, new HashSet<>());
                cols.putIfAbsent(c, new HashSet<>());
                grid.putIfAbsent(gridKey, new HashSet<>());
                char curr = board[r][c];
                if(curr != '.'){
                    if(rows.get(r).contains(curr)) return false;
                    if(cols.get(c).contains(curr)) return false;
                    if(grid.get(gridKey).contains(curr)) return false;
                    rows.get(r).add(curr);
                    cols.get(c).add(curr);
                    grid.get(gridKey).add(curr);
                }
            }
        }
        return true;
    }
}
