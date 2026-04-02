class Solution {
    String[] digitToChar = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return res;
        backtrack(0, "", digits);
        return res;
    }
    public void backtrack(int idx, String currStr, String digits){
        if(currStr.length() == digits.length()) {
            res.add(currStr);
            return;
        }
        String chars = digitToChar[digits.charAt(idx) - '0'];
        for(char c : chars.toCharArray()) backtrack(idx + 1, currStr + c, digits);
    }
}