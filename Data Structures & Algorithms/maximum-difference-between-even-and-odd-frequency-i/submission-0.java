class Solution {
    public int maxDifference(String s) {
        int[] count = new int[26];
        int oddMax = 0;
        int evenMin = s.length();
        for(char c : s.toCharArray()) count[c - 'a']++;
        for(int i : count){
            if(i % 2 == 1) oddMax = Math.max(oddMax, i);
            else if(i > 0) evenMin = Math.min(evenMin, i);
        }
        return oddMax - evenMin;
    }
}