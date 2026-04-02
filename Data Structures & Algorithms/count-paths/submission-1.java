class Solution {
    int[][] t;
    public int uniquePaths(int m, int n) {
        t = new int[m][n];
        for(int[] a : t) Arrays.fill(a, -1);
        return dfs(0, 0, m, n);
    }
    public int dfs(int i, int j, int m, int n){
        if(i >= m || j >= n) return 0;
        if(i == m - 1 && j == n - 1) return 1;
        if(t[i][j] != -1) return t[i][j];
        return t[i][j] = dfs(i, j + 1, m, n) + dfs(i + 1, j, m, n);
    }
}
