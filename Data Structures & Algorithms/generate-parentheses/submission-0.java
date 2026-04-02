class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        dfs(n, 0, 0, "");
        return res;
    }
    public void dfs(int n, int open, int close, String s){
        if(open + close == n * 2) {
            res.add(s);
            return;
        }
        if(open < n) dfs(n, open + 1, close, s + "(");
        if(close < open) dfs(n, open, close + 1, s + ")");
    }
}
