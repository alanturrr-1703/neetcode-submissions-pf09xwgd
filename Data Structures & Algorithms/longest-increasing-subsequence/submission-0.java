class Solution {
    int[][] t;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        t = new int[n][n + 1];
        for(int[] row : t) Arrays.fill(row, -1);
        return dfs(nums , 0, -1);
    }
    private int dfs(int[] nums, int i, int j){
        if(i == nums.length) return 0;
        if(t[i][j + 1] != -1) return t[i][j+1];
        int LIS = dfs(nums, i + 1, j);
        if(j == -1 || nums[j] < nums[i]){
            LIS = Math.max(LIS, 1 + dfs(nums, i + 1, i));
        }
        t[i][j + 1] = LIS;
        return LIS;
    }
}
