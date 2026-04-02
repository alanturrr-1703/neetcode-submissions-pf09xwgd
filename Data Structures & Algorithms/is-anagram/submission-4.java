class Solution {
    // carr = rarc
    public boolean isAnagram(String s, String t) {
        int[] charmap = new int[26];
        if(s.length() != t.length()) return false;
        for(int i = 0; i < s.length(); i++){
            charmap[s.charAt(i) - 'a']++;
            charmap[t.charAt(i) - 'a']--;
        }
        return isMapZero(charmap);
    }
    public boolean isMapZero(int[] charmap){
        for(int i = 0; i < 26; i++){
            if(charmap[i] != 0) return false;
        }
        return true;
    }
}
