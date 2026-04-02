class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        if(k > 26) return 0;
        int answer = 0;
        int n = s.length();
        int l = 0, r = 0;
        int freq[] = new int[26];
        while(r < n){
            freq[s.charAt(r) - 'a']++;
            while(freq[s.charAt(r) - 'a'] > 1){
                freq[s.charAt(l) - 'a']--;
                l++;
            }
            if(r - l + 1 == k){
                answer++;
                freq[s.charAt(l) - 'a']--;
                l++;
            }
            r++;
        }
        return answer;
    }
}
