class Solution {
    int[] t;
    public int climbStairs(int n) {
        t = new int[n];
        Arrays.fill(t, -1);
        return dfs(n, 0);
    }
    public int dfs(int n, int i){
        if(i >= n) return i == n ? 1 : 0;
        if(t[i] != -1) return t[i];
        return t[i] = dfs(n, i + 1) + dfs(n, i + 2);
    }
}
