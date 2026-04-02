class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int vote = 0;
        for(int num : nums){
            if(vote == 0) {
                candidate = num;
                vote++;
            } else if(num != candidate) {
                vote--;
            } else vote++;
        }
        return candidate;
    }
}