class Solution {
    Boolean[][] t;
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        t = new Boolean[m + 1][n + 1];
        return dfs(0, 0, s, p, m, n);
    }
    public boolean dfs(int i, int j, String s, String p, int m, int n){
        if(j == n) return i == m;
        if(t[i][j] != null) return t[i][j];
        boolean match = i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if(j + 1 < n && p.charAt(j + 1) == '*') return t[i][j] = dfs(i, j + 2, s, p, m, n) || (match && dfs(i + 1, j, s, p, m, n));
        if(match) return t[i][j] = dfs(i + 1, j + 1, s, p, m, n);
        return false;
    }
}
