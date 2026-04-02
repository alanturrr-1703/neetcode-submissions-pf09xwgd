class Solution {
    Set<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> subsets = new ArrayList<>();
        res = new HashSet<>();
        Arrays.sort(nums);
        dfs(nums, subsets, 0);
        return new ArrayList<>(res);
    }
    public void dfs(int[] nums, List<Integer> subsets, int i){
        if(i >= nums.length){
            res.add(new ArrayList<>(subsets));
            return;
        }
        subsets.add(nums[i]);
        dfs(nums, subsets, i + 1);
        subsets.remove(subsets.size() - 1);
        dfs(nums, subsets, i + 1);
    }
}
