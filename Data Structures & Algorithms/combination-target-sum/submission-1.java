class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        dfs(nums, target, res, comb, 0);
        return res;
    }
    public void dfs(int[] nums, int target, List<List<Integer>> res, List<Integer> comb, int i){
        if(target == 0){
            res.add(new ArrayList<>(comb));
            return;
        }
        if(target < 0 || i >= nums.length) return;
        comb.add(nums[i]);
        dfs(nums, target - nums[i], res, comb, i);
        comb.remove(comb.size() - 1);
        dfs(nums, target, res, comb, i + 1);
    }
}
