class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int total = nums[l] + nums[r];
            if(total == target) return new int[] {l + 1, r + 1};
            else if(total > target) r--;
            else l++;
        }
        return new int[] {-1, -1};
    }
}
