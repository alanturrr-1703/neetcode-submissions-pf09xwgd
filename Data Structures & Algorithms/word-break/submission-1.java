class Solution {
    Boolean[] t;
    public boolean wordBreak(String s, List<String> wordDict) {
        t = new Boolean[s.length()];
        return dfs(s, wordDict, 0);
    }
    public boolean dfs(String s, List<String> wordDict, int i){
        if(i == s.length()) return true;
        if(t[i] != null) return t[i];
        for(String w : wordDict){
            if(i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)){
                if(dfs(s, wordDict, i + w.length())) return t[i] = true;
            }
        }
        return t[i] = false;
    }
}