class Solution {
    private Set<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new HashSet<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>(), 0);
        return new ArrayList<>(res);
    }
    public void dfs(int[] candidates, int target, int i, List<Integer> comb, int total){
        if(total == target){
            res.add(new ArrayList<>(comb));
            return;
        }
        if(total > target || i == candidates.length) return;
        comb.add(candidates[i]);
        dfs(candidates, target, i + 1, comb, total + candidates[i]);
        comb.remove(comb.size() - 1);
        dfs(candidates, target, i + 1, comb, total);
    }
}
