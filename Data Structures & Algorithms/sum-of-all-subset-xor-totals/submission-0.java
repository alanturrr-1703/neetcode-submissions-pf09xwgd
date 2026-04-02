class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }
    public int dfs(int[] nums, int i, int res){
        if(nums.length == i) return res;
        return dfs(nums, i + 1, res ^ nums[i]) + dfs(nums, i + 1, res);
    }
}