class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int max = 0;
        while (r < s.length()){
            for(int i = l; i < r; i++){
                if(s.charAt(i) == s.charAt(r)){
                    l = i + 1;
                    break;
                }
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
        
    }
}
