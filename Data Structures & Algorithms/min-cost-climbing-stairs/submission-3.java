class Solution {
    int[] t;
    public int minCostClimbingStairs(int[] cost) {
        t = new int[cost.length];
        Arrays.fill(t, -1);
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }
    public int dfs(int[] cost, int i){
        if(i >= cost.length) return 0;
        if(t[i] != -1) return t[i];
        return t[i] = cost[i] + Math.min(dfs(cost, i + 1), dfs(cost, i + 2));
    }
}
