class Solution {
    public String customSortString(String order, String s) {
        int[] charArray = new int[26];
        for(char c : s.toCharArray()) charArray[c - 'a']++;
        
        StringBuilder res = new StringBuilder();

        for(char c : order.toCharArray()){
            int idx = c - 'a';
            while(charArray[idx] > 0){
                res.append(c);
                charArray[c - 'a']--;
            }
        }
        int count = 0;
        for(int i : charArray){
            char c = (char) ('a' + count);
            while(i > 0){
                res.append(c);
                i--;
            }
            count++;
        }
        return res.toString();
        
    }
}