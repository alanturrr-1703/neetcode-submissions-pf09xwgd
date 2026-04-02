class Solution {
    // [1, 1, 2, 3]
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        return set.size() < nums.length;
    }
}