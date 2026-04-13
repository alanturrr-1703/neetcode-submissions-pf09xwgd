class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] sArr = new int[26];
        int[] tArr = new int[26];
        for(int i = 0; i < s.length(); i++){
            sArr[s.charAt(i) - 'a']++;
            tArr[t.charAt(i) - 'a']++;
        }
        return valid(sArr, tArr);
    }
    public boolean valid(int[] s, int[] t){
        for(int i = 0; i < 26; i++){
            if(s[i] != t[i]) return false;
        }
        return true;
    }
}
