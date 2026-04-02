class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int minLen = Math.min(first.length(), last.length());
        int r = 0;
        while(r < minLen && first.charAt(r) == last.charAt(r)) r++;
        return first.substring(0, r);
    }
}