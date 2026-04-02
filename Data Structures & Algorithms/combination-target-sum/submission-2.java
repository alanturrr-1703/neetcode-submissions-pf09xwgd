class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> possibleSum = new ArrayList<>();
        dfs(nums, res, possibleSum, 0, target);
        return res;
    }
    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> possibleSum, int i, int target){
        if(target == 0){
            res.add(new ArrayList<>(possibleSum));
            return;
        }
        if(target < 0 || i >= nums.length) return;
        possibleSum.add(nums[i]);
        dfs(nums, res, possibleSum, i, target - nums[i]);
        possibleSum.remove(possibleSum.size() - 1);
        dfs(nums, res, possibleSum, i + 1, target);
    }
}
