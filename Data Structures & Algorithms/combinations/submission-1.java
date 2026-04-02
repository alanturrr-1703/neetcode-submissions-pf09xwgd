class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        dfs(n, k, 1, 0, new ArrayList<>());
        return res;
    }
    public void dfs(int n, int k, int i, int size, List<Integer> comb){
        if(size == k){
            res.add(new ArrayList<>(comb));
            return;
        }
        if(i > n) return;
        comb.add(i);
        dfs(n, k, i + 1, size + 1, comb);
        comb.remove(comb.size() - 1);
        dfs(n, k, i + 1, size, comb);
    }
}