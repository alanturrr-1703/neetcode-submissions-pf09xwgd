class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        int length = 0;
        int longest = 0;
        for(int num : set){
            if(!(set.contains(num - 1))){
                length = 1;
                while(set.contains(num + 1)){
                    length++;
                    num++;
                }
            }
            longest = Math.max(longest, length);
        }
        return longest;
    }
}
