class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int i = 1;
        while(i < set.size() + 1){
            if(!set.contains(i)) break;
            i++;
        }
        return i;
    }
}