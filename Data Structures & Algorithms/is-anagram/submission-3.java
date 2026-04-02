class Solution {
    // carr = rarc
    public boolean isAnagram(String s, String t) {
        int[] sMap = new int[26];
        int[] tMap = new int[26];
        if(s.length() != t.length()) return false;
        for(int i = 0; i < s.length(); i++){
            sMap[s.charAt(i) - 'a']++;
            tMap[t.charAt(i) - 'a']++;
        }
        return twoMapSame(sMap, tMap);
    }
    public boolean twoMapSame(int[] sMap, int[] tMap){
        for(int i = 0; i < 26; i++){
            if(sMap[i] != tMap[i]) return false;
        }
        return true;
    }
}
