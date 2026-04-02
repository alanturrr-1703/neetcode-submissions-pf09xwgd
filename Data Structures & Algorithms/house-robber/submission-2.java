class Solution {
    int[] t;
    public int rob(int[] nums) {
        t = new int[nums.length];
        Arrays.fill(t, -1);
        return Math.max(dfs(nums, 0), dfs(nums, 1));
    }
    public int dfs(int[] nums, int i){
        if(i >= nums.length) return 0;
        if(t[i] != -1) return t[i];
        return t[i] = Math.max(nums[i] + dfs(nums, i + 2), dfs(nums, i + 1));
    }
}
