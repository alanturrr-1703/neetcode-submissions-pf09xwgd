class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        dfs(nums, target, res, combination, 0);
        return res;
    }
    public void dfs(int[] nums, int target, List<List<Integer>> res, List<Integer> combination, int i){
        if(target == 0){
            res.add(new ArrayList<>(combination));
            return;
        }
        if(i >= nums.length || target < 0) return;
        combination.add(nums[i]);
        dfs(nums, target - nums[i], res, combination, i);
        combination.remove(combination.size() - 1);
        dfs(nums, target, res, combination, i + 1);
    }
}
