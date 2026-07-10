class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int res = 0;
        HashSet<Character> set = new HashSet<>();
        for(int r = 0; r < s.length(); r++){
            if(set.contains(s.charAt(r))) {
                while(l < r && set.contains(s.charAt(r))){
                    set.remove(s.charAt(l));
                    l++;
                }
            } 
            res = Math.max(res, r - l + 1);
            set.add(s.charAt(r));
        }
        return res;
    }
}
