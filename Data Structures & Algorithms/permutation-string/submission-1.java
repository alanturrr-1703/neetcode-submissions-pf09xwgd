class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> s1Count = new HashMap<>();
        HashMap<Character, Integer> s2Count = new HashMap<>();
        if(s1.length() > s2.length()) return false;
        for(int i = 0; i < s1.length(); i++){
            s1Count.put(s1.charAt(i), s1Count.getOrDefault(s1.charAt(i), 0) + 1);
            s2Count.put(s2.charAt(i), s2Count.getOrDefault(s2.charAt(i), 0) + 1);
        }
        int l = 0;
        int r = s1.length() - 1;
        while(r < s2.length()){
            if(s1Count.equals(s2Count)) return true;
            else{
                int count = s2Count.get(s2.charAt(l));
                count--;
                if(count > 0) s2Count.put(s2.charAt(l), count);
                else s2Count.remove(s2.charAt(l));
                l++;
                r++;
                if(r < s2.length()) s2Count.put(s2.charAt(r), s2Count.getOrDefault(s2.charAt(r), 0) + 1);
            }
        }
        return false;
    }
}
