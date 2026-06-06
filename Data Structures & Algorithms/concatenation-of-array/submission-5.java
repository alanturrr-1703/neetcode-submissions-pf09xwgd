class Solution {
    public int[] getConcatenation(int[] nums) {
        int size = nums.length;
        int[] res = new int[size * 2];
        for(int i = 0; i < size; i++){
            res[i] = nums[i];
            res[i + size] = nums[i];
        }
        return res;
    }
}