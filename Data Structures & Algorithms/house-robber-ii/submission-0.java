class Solution {
    Integer[] t;
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        int case1 = solve(nums, 0, nums.length - 2);
        int case2 = solve(nums, 1, nums.length - 1);
        return Math.max(case1, case2);
    }
    public int solve(int[] nums, int start, int end){
        t = new Integer[nums.length];
        return dfs(nums, start, end);
    }
    public int dfs(int[] nums, int i, int end){
        if(i > end) return 0;
        if(t[i] != null) return t[i];
        int rob = nums[i] + dfs(nums, i + 2, end);
        int skip = dfs(nums, i + 1, end);
        return t[i] = Math.max(rob, skip);
    }
}
